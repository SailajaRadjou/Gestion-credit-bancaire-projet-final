package com.radjou.sailaja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	Employee employee;
	Connection conn = SingletonConnection.getConnection();
	@Override
	public Employee save(Employee emp) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into employee (username, email, password) values (?, ?, md5(?))");
			
			pStmt.setString(1, emp.getUserName());
			pStmt.setString(2, emp.getEmail());			
			pStmt.setString(3, emp.getPassword());			
			
			pStmt.executeUpdate();
			System.out.println("Inserted a new record Successfully....");
			pStmt.close();
			
			pStmt = conn.prepareStatement("select max(emp_id) as Last_Record from employee");
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				emp.setEmpId(rSet.getInt("Last_Record"));
				pStmt.close();
				return emp;
			}			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee find(String username, String password) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from employee where username = ? and password = md5(?)");
			
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			
			ResultSet rSet = pStmt.executeQuery();
			System.out.println("executed");
			if(rSet.next()) {
				employee = new Employee();
				employee.setEmpId(rSet.getInt("emp_id"));
				employee.setUserName(rSet.getString("username"));
				employee.setEmail(rSet.getString("email"));	
				employee.setPassword(rSet.getString("password"));
				employee.setStatus(rSet.getInt("status"));
				System.out.println(employee);
				return employee;
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
