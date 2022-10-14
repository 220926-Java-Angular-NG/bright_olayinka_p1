package com.brightola.repos;

import com.brightola.models.Employee;
import com.brightola.utils.ConnectionManager;
import com.brightola.utils.CRUDDaoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.jws.soap.SOAPBinding;


public class EmployeeRepo implements CRUDDaoInterface<Employee> {
    public static Connection conn;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepo.class);


    public EmployeeRepo() {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project1";
        String username = "postgres";
        String password = "mysecretpassword";


        try {

            // this is the code that can throw an error
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.getSchema());


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException.getMessage());
        }

    }


    @Override
    public int create(Employee employee) {
        try {
            String sql = "INSERT INTO employee (id, first_name, last_name, gender, user_name, email, pass_word, phone_no, isManager) VALUES (default,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, employee.getFirst_name());
            pstmt.setString(2, employee.getLast_name());
            pstmt.setString(3, employee.getGender());
            pstmt.setString(4, employee.getUser_name());
            pstmt.setString(5, employee.getEmail());
            pstmt.setString(6, employee.getPass_word());
            pstmt.setString(7, employee.getPhone_no());
            pstmt.setBoolean(8, employee.getIsManager());

            // this executes the sql statement above
            pstmt.executeUpdate();

            // this gives us a result set of the row that was just created
            ResultSet rs = pstmt.getGeneratedKeys();

            // the cursor is right in front of the first (or only) element in our result set
            // calling rs.next() iterates us into the first row
            rs.next();

            return rs.getInt("id");

        } catch (SQLException sqlException) {
            //LOGGER.error(sqlException.getMessage());
            System.out.println(sqlException.getMessage());
        }

        return 0;

    }

    // This is read method//
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();

        try {

            String sql = "SELECT * FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            Employee employee;
            while (rs.next()) {
                employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setFirst_name(rs.getString("first_name"));
                employee.setLast_name(rs.getString("last_name"));
                employee.setGender(rs.getString("gender"));
                employee.setUser_name(rs.getString("user_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPass_word(rs.getString("pass_word"));
                employee.setPhone_no(rs.getString("phone_no"));
                employee.setIsManager(rs.getBoolean("isManager"));


                employees.add(employee);

            }

            return employees;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }


    @Override
    public Employee getById(int id) {
        try {
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            // we are returning a user
            // therefore we have to create a new instance of a user from the database
            Employee employee = new Employee();
            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setFirst_name(rs.getString("first_name"));
                employee.setLast_name(rs.getString("last_name"));
                employee.setGender(rs.getString("geneder"));
                employee.setUser_name(rs.getString("user_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPass_word(rs.getString("pass_word"));
                employee.setPhone_no(rs.getString("phone_no"));
                employee.setIsManager(rs.getBoolean("isManager"));
            }
            return employee;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //update
    @Override
    public  Employee update(Employee employee) {
        try {
            String sql = "UPDATE employees SET email = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getEmail());
            pstmt.setInt(2, employee.getId());
            System.out.println(pstmt.executeUpdate());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(Employee employee) {
        try {
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, employee.getId());
            int numberAffected = pstmt.executeUpdate();
            return numberAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changePos(Employee employee) {
        return false;
    }

    public Employee getLogin(String user_name, String pass_word) {
        return null;
    }
}