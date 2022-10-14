package com.brightola.Controllers;

import com.brightola.models.Cache;
import com.brightola.models.Cache;
import com.brightola.models.Ticket;
import com.brightola.models.Employee;
import com.brightola.services.TicketServices;
import com.brightola.services.EmployeeService;
import io.javalin.http.Handler;

import java.util.List;


public class TicketController {
    //public Handler getAllTicket;

    //Cache caches = new Cache();


    EmployeeService employeeService = new EmployeeService();
    TicketServices ticketService = new TicketServices();


    private Cache caches;
    //////////////////////////////////////////////////////////////////
//    change pos user
    public Handler changePos = context -> {
        if(caches.level == Cache.Level.MANAGER){
            Employee in = context.bodyAsClass(Employee.class);
            System.out.println(in.getUser_name());
            boolean employee = employeeService.changePos(in);
            if (employee){
                context.result("Employee has been updated");
            }else{
                context.result("Employee has not been updated");
            }

        }

        System.out.println("You do not have the authorization to change user employment state");

    };

    //////////////////////////////////////////////////////////////////
//    delete user only manager
    public Handler checkStatus = context -> {


        context.result("Employee info:\n" + "User_name: " + caches.curUser_name + "\n"
                + "Clearance Level: " + caches.level);


    };


    //////////////////////////////////////////////////////////////////
//    delete user only manager
    public Handler delEmployee = context -> {
        if(caches.level == Cache.Level.MANAGER){
            Employee in = context.bodyAsClass(Employee.class);
            System.out.println(in.getUser_name() + "   " + in.getId());
            boolean del = employeeService.deleteEmployee(in);
            if (del){
                context.result("Employee has been deleted");
            }else{
                context.result("Employee has not been deleted");
            }

        }

        System.out.println("You do not have the authorization to delete users");

    };

    //////////////////////////////////////////////////////////////////
//    login
    public Handler loginGet = context -> {

        context.result("The options are: login (post)\n or logout (delete)\n ");
    };


    //////////////////////////////////////////////////////////////////
//    login employee
    public Handler login = context -> {

        Employee in = context.bodyAsClass(Employee.class);
        System.out.println(in.getUser_name() + "   " + in.getPass_word());
        Ticket employee = EmployeeService.getEmployeeByUser_name(in.getUser_name(), in.getPass_word());

        caches.curUserID = employee.getId();
        caches.curUser_name = employee.getUser_name();
        if(caches.curUser_name == null){
            context.result("incorrect user_name or password").status(400);
            return;
        }

        if (employee.getIsManager() == false) {
            caches.level = Cache.Level.MANAGER;
        } else{
            caches.level = Cache.Level.EMPLOYEE;
        }

        context.result(caches.curUser_name + " is logged in as an " + caches.level);
        System.out.println(caches.curUser_name + " is logged in as an " + caches.level);

    };


    //////////////////////////////////////////////////////////////////
//    login out employee
    public Handler loginout = context -> {
        caches.level = Cache.Level.NONE;
        caches.curUserID = -1;
        caches.curUser_name = "";

        context.result("You have been logged out");


    };


    //////////////////////////////////////////////////////////////////
//    register home page
    public Handler registerHome = context -> {

        context.result("The options are: register a user (post)\n or register info (get)\n ");
    };

    //////////////////////////////////////////////////////////////////
//    register user
    public Handler register = context -> {
        if (caches.level == Cache.Level.NONE){



            Employee in = context.bodyAsClass(Employee.class);

            int test = employeeService.createEmployee(in);

            if (test == 0){
                context.result("This is already taken user_name\n Please try again");
            }
            Ticket employee = employeeService.getEmployeeByUser_name(in.getUser_name(), in.getPass_word());

            caches.curUserID = employee.getId();
            caches.curUser_name = employee.getUser_name();

            if (employee.getIsManager() == false) {
                caches.level = Cache.Level.MANAGER;
            } else{
                caches.level = Cache.Level.EMPLOYEE;
            }
            context.result("Employee is created and you are logged in");
            System.out.println(caches);

        }else{
            context.result("Already logged in\n log out at /login if new employee");
        }

    };






    //////////////////////////////////////////////////////////////////
//    Create a ticket
    public Handler createTicket = context -> {
        if (caches.level == Cache.Level.EMPLOYEE) {

            Ticket in = context.bodyAsClass(Ticket.class);
            System.out.println(in.getAmount());
            if (in.getAmount() > 1 && in.getDescription().length() > 1){
                int id = ticketService.createticket(in);
                if (id == 0) {
                    context.result("does not work");
                } else {
                    context.result("Ticket Created");
                }
            }else {
                context.result("You need to add amount and description");
            }
        }else{
            context.result("You need to be an employee to create ticket");
        }

    };


    //////////////////////////////////////////////////////////////////
//   Employee views his past tickets
    public Handler allTickets = context -> {
        if (caches.level == Cache.Level.EMPLOYEE){

//            User in = context.bodyAsClass(User.class);

            List<Ticket> tickets = ticketService.getTicketByCreator_id(caches.curUserID);

            context.result("Ticket list made");
            String lists = "";
            for(Ticket tic: tickets){
                lists+=tic.toString()+"\n";
            }
            context.result(lists);

        }else{
            context.result("You need to be an employee to create ticket");
        }

    };






    public Handler managerTickets = context -> {
        if (caches.level == Cache.Level.MANAGER){

            List<Ticket> tickets = ticketService.getAll();

            context.result("Ticket list made");
            String lists = "";
            for(Ticket tic: tickets){
                lists+=tic.toString()+"\n";
            }
            context.result(lists);
            caches.ticketList = tickets;

        }else{
            context.result("You need to be an Manager to see all processing tickets");
        }


    };


    //////////////////////////////////////////////////////////////////
//   Manager updates ticket
    public Handler UpdateTicket = context -> {
        if (caches.level == Cache.Level.MANAGER){

//            User in = context.bodyAsClass(User.class);
            Ticket in = context.bodyAsClass(Ticket.class);
            boolean update = ticketService.updateTicket(in.getId(), in.status);

            if(update){
                List<Ticket> tickets = ticketService.getAll();
                String lists = "";
                for(Ticket tic: tickets){
                    lists+=tic.toString()+"\n";
                }
                context.result("Updated\nNew queue below \n" + lists);
                caches.ticketList = tickets;
            }else {
                context.result("not updated, please enter id and status");
            }

        }else{
            context.result("You need to be a Manager to update ticket");
        }


    };





}