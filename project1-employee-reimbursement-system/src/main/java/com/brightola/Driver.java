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

        Javalin app  = Javalin.create().start(8080);
        //EmployeeService employeeService = new EmployeeService();
       EmployeeController employeeController = new EmployeeController();



        app.get("/employees",employeeController.getAllEmployees);
        app.post("/employee", employeeController.createNewEmployee);
        app.put("/employee", employeeController.updateEmployee);
        app.delete("/employee", employeeController.deleteEmployee);





    }
}