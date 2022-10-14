 package com.brightola.Controllers;

import com.brightola.models.Employee;
import com.brightola.services.EmployeeService;
import io.javalin.http.Handler;
//import jdk.vm.ci.services.Services;

 public class EmployeeController {
    public Handler getEmployeeById = context -> {
            Employee employee = context.bodyAsClass(Employee.class);
            //employee = service.updateEmployeeById(employee);
            if (employee != null) {
                context.json(employee);
            } else {
                context.result("Could not update employee.").status(400);
            }
        };
    EmployeeService service;

    public EmployeeController(){
        service = new EmployeeService();
    }

    public EmployeeController(EmployeeService service){
        this.service = service;
    }


    //Create Employee Handler
    //create employee handler
    public Handler createNewEmployee = context -> {


        //grab the object from the request body (postman)
        //send the incoming user to our service, so it can
        //reach out to our repo layer and execute the request
        Employee employee = context.bodyAsClass(Employee.class); //change the json from postman to an object
        System.out.println(employee);
        int id = service.createEmployee(employee);

        if(id > 0){
//            valid number (represents the primary key)
            employee.setId(id);
            context.json(employee);
        }else{
            //something went wrong
            context.result("Employee not created").status(400);
        }

    };

    //login employee
    //login employee
    public Handler loginEmployee = context -> {
        Employee employee = context.bodyAsClass(Employee.class);
        System.out.println(employee);
        int id = service.createEmployee(employee);

        if(id > 0){
            employee.setId(id);
            context.json(employee);
        }else{
            //something went wrong
            context.result("Employee not created").status(400);
        }

    };

    //updating employee
    //updating employee
    public Handler updateEmployee = context -> {
        Employee employee = context.bodyAsClass(Employee.class);
        employee = service.updateEmployee(employee);
        if (employee != null) {
            context.json(employee);
        } else {
            context.result("Could not update employee.").status(400);
        }
    };

    //Delete employee handler
    //delete employee handler
    public Handler deleteEmployee = context -> {
        Employee employee = context.bodyAsClass(Employee.class);
        if (service.deleteEmployee(employee)) {
            context.status(200);
        } else {
            context.status(400).result("could not delete Employee.");
        }
    };

    //get all Employee handler
    //get all employee handler
    public Handler getAllEmployees = context -> {
        context.json(service.getAllEmployee());
    };

}
