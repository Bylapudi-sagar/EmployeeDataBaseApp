package com.jsp.EmployeeDBApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.EmployeeDBApp.db.DBConnection;
import com.jsp.EmployeeDBApp.dto.Employee;

public class EmployeeDAO {
         
	public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            ps.executeUpdate();
            System.out.println("✅ Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	
	 public void updateSalary(int id, double salary) {
	        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setDouble(1, salary);
	            ps.setInt(2, id);
	            if (ps.executeUpdate() > 0)
	                System.out.println(" Salary updated successfully.");
	            else
	                System.out.println(" Employee not found.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteEmployee(int id) {
	        String sql = "DELETE FROM employees WHERE id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            if (ps.executeUpdate() > 0)
	                System.out.println(" Employee deleted successfully.");
	            else
	                System.out.println(" Employee not found.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public Employee fetchEmployeeById(int id) {
	        String sql = "SELECT * FROM employees WHERE id = ?";
	        Employee emp = null;

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    emp = new Employee(
	                            rs.getInt("id"),
	                            rs.getString("name"),
	                            rs.getString("email"),
	                            rs.getString("department"),
	                            rs.getDouble("salary")
	                    );
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return emp;
	    }

	
}
