package com.brightola;

import com.brightola.Controllers.EmployeeController;
import com.brightola.models.Employee;
import com.brightola.Controllers.TicketController;
import com.brightola.repos.EmployeeRepo;
import com.brightola.services.EmployeeService;

import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);
        //EmployeeService employeeService = new EmployeeService();
        EmployeeController employeeController = new EmployeeController();
        TicketController ticketController = new TicketController();


        app.post("/employee", employeeController.createNewEmployee);
        app.get("/employees", employeeController.getAllEmployees);
        app.get("/employee", employeeController.getEmployeeById);
        app.put("/employee", employeeController.updateEmployee);
        app.delete("/employee", employeeController.deleteEmployee);
        app.post("/login", employeeController.loginEmployee);
        app.get("/login", employeeController.loginEmployee);


       /* app.post("/Ticket", ticketController.createTicket);
        app.get("/ticket", ticketController.getAllTicket);
        app.get("/ticket", ticketController.getTicketById);
        app.put("/ticket", ticketController.updateTicket);
        app.delete("/ticket", ticketController.deleteTicket);
        app.post("/login", ticketController.loginTicket);
        app.get("/login", ticketController.loginTicket);

        */


        //Employee employee1 = new Employee("bright.ola", "123456password", true);

       /* app.get("/", context -> {
            context.result("HomePage to management.com project-1\n"
                    + "go to /employee  to manage employees\n"
                    + "go to /tickets to manage tickets\n"
                    + "go to /login  to login to your account\n"
                    + "go to /register into a new account");
        });

        app.delete("/employee", ticketController.delEmployee);

        //this method is login info
        app.get("/login", ticketController.loginGet);
        app.post("/login", ticketController.login);
        app.delete("/login", ticketController.loginout);

        //register new user check
        app.get("/register", ticketController.registerHome);
        app.post("/register", ticketController.register);



        app.post("/ticket", ticketController.createTicket);
        app.get("/ticket", ticketController.allPrevTicket);
        //        app.get("/ticket", mainController.allPrevTicket);

//        Tickets: Manager -> Process unprocessed employee tickets by
//                 approved or denied, in a queue and removed when processed
        app.get("/ticketManager", ticketController.managerTickets);
        app.post("/ticketManager", ticketController.managerUpdateTickets);
//        Optional:
//                Reinbursement type


//                Change Roles
//        USERS: Manager -> delete user by id
        app.post("/editUser", ticketController.changePos);


//                upload pic of reciept
//                update account feature

        app.get("/info", ticketController.checkStatus);



    }
}
*/
    }
}