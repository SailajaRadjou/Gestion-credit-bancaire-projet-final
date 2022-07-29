package com.radjou.sailaja.dao;

import java.util.ArrayList;

import com.radjou.sailaja.metier.Employee;

public interface IEmployeeDao {

	Employee save(Employee emp);
	Employee update(Employee emp);
	int delete(Employee emp);
	
	ArrayList<Employee> getAll();
	Employee find(String username, String password);
	int find(String username);
	
	Employee find(int id);
}
