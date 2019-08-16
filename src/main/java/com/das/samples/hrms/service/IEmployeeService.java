package com.das.samples.hrms.service;

import java.util.List;

import com.das.samples.hrms.dto.Employee;

public interface IEmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmplooyee(String employeeId);

	Employee getEmployee(String employeeId);

	List<Employee> getAllEmployees();

	List<Employee> getEmployeesByCity(String cityName);

	List<Employee> getEmployeesByDesignation(String designation);
	
	List<Employee> getEmployeesByCityAndDesignation(String designation, String city);
}
