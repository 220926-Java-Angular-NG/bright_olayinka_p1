package com.brightola.services;

import com.brightola.models.Employee;
import com.brightola.repos.EmployeeRepo;
import com.brightola.utils.CRUDDaoInterface;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private EmployeeRepo employeeRepo;

    //    we are creating a new instance of our EmployeeRepo
    public EmployeeService(){
        employeeRepo = new EmployeeRepo();
    }

    //    here we are passing in an existing UserRepo
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    //    create
    public int createEmployee(Employee employee){

        return employeeRepo.create(employee);
    }

    //    read all
    public List<Employee> getAllEmployee(){
        return employeeRepo.getAll();
    }

    //    readById
    public Employee getEmployeeById(int id){
        return employeeRepo.getById(id);
    }

    //    readByUsername
    public Employee getEmployeeByUser_name(String user_name, String pass_word)
    { return employeeRepo.getLogin(user_name, pass_word);}

//    check for username
//    public boolean checkUsername(String username){return userRepo.checkUsername(username);}

    //    update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.update(employee);
    }

    //    delete
    public boolean deleteEmployee(Employee employee){
        return employeeRepo.delete(employee);
    }

    public boolean changePos(Employee employee) {return employeeRepo.changePos(employee);}

    public Object deleteEmployeeById(int id) {
        return null;
    }
}