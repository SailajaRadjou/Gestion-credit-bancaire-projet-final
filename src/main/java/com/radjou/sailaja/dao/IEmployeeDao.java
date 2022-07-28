package com.radjou.sailaja.dao;

import com.radjou.sailaja.metier.Employee;

public interface IEmployeeDao {

	Employee save(Employee emp);
	Employee update(Employee emp);
	Employee find(String username, String password);
}
