package com.das.samples.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.das.samples.hrms.dto.Employee;
import com.das.samples.hrms.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(
			@RequestBody Employee employee) {

		Employee createdEmployee = employeeService.createEmployee(employee);

		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(
			@RequestBody Employee employee) {

		Employee updatedEmployee = employeeService.updateEmployee(employee);

		return new ResponseEntity<>(updatedEmployee, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Employee> deleteEmployee(
			@PathVariable String employeeId) {

		employeeService.deleteEmplooyee(employeeId);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployee(
			@PathVariable String employeeId) {

		Employee retrievedEmployee = employeeService.getEmployee(employeeId);

		return new ResponseEntity<>(retrievedEmployee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {

		List<Employee> employeesList = employeeService.getAllEmployees();

		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}

	@GetMapping("/filter/{designation}/{cityName}")
	public ResponseEntity<List<Employee>> getFilteredEmployees(
			@PathVariable String designation, @PathVariable String cityName) {

		List<Employee> employeesByCity = employeeService
				.getEmployeesByCityAndDesignation(designation, cityName);
		return new ResponseEntity<>(employeesByCity, HttpStatus.OK);
	}
}
