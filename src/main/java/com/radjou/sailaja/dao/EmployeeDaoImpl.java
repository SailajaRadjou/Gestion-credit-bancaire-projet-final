package com.radjou.sailaja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	Employee employee;
	
	Connection conn = SingletonConnection.getConnection();
	
	//for inserting data
	@Override
	public Employee save(Employee emp) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into employee (username, email, password, status) values (?, ?, md5(?), ?)");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setString(1, emp.getUserName());
			pStmt.setString(2, emp.getEmail());			
			pStmt.setString(3, emp.getPassword());			
			pStmt.setInt(4, emp.getStatus());
			
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Inserted a new record Successfully....");
			pStmt.close();
			
			// for getting the id of the row last inserted
			pStmt = conn.prepareStatement("select max(emp_id) as Last_Record from employee");
			
			//execute the above select query & retrieve the value in the variable rset
			ResultSet rSet = pStmt.executeQuery();
			
			//for setting id & it returns the object of the lastly entered data
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

	//update
	@Override
	public Employee update(Employee emp) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update employee set username = ?, email = ?, password = md5(?), status = ? where emp_id = ?");
			
			//get the values of the object & set it in the query in given order 
			pStmt.setInt(5, emp.getEmpId());
			pStmt.setString(1, emp.getUserName());
			pStmt.setString(2, emp.getEmail());			
			pStmt.setString(3, emp.getPassword());
			pStmt.setInt(4, emp.getStatus());
			
			//execute query in the prepared statement
			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();
			
			//return the updated object
			return this.find(emp.getEmpId());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	//for authentification
	@Override
	public Employee find(String username, String password) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from employee where username = ? and password = md5(?)");
			
			//get the values of the object & set it in the query in given order
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			
			//execute query in the prepared statement
			ResultSet rSet = pStmt.executeQuery();
			System.out.println("executed");
			
			//set the retrieved values in the employee entity
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

	//to get the status
	@Override
	public int find(String username) {
		int status;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select status from employee where username = ?");
			
			pStmt.setString(1, username);
			
			
			ResultSet rSet = pStmt.executeQuery();
			System.out.println("executed");
			
			if(rSet.next()) {
				
				status = rSet.getInt("status");
				return status;
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return 0;
	}

	@Override
	public int delete(Employee emp) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from employee where emp_id = ?");
			
			pStmt.setInt(1, emp.getEmpId());
			
			res = pStmt.executeUpdate();
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
		
	}

	//get employee list
	@Override
	public ArrayList<Employee> getAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from employee");
			
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				
				employee = new Employee(); 
				employee.setEmpId(rSet.getInt("emp_id"));
				employee.setUserName(rSet.getString("username"));
				employee.setEmail(rSet.getString("email"));	
				employee.setPassword(rSet.getString("password"));
				employee.setStatus(rSet.getInt("status"));
				employees.add(employee);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return employees;
	}

	//find employee by id
	@Override
	public Employee find(int id) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from employee where emp_id = ?");
			
			pStmt.setInt(1, id);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				employee = new Employee(); 
				employee.setEmpId(rSet.getInt("emp_id"));
				employee.setUserName(rSet.getString("username"));
				employee.setEmail(rSet.getString("email"));	
				employee.setPassword(rSet.getString("password"));
				employee.setStatus(rSet.getInt("status"));
				System.out.println(employee);
				pStmt.close();
				return employee;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
