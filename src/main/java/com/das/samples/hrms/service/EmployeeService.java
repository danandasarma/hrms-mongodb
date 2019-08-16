package com.das.samples.hrms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.das.samples.hrms.dto.Employee;
import com.das.samples.hrms.entity.EmployeeEntity;
import com.das.samples.hrms.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity savedEmployeeEntity = employeeRepository
				.insert(employee.toEmployeeEntity());
		return savedEmployeeEntity.toEmployee();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		EmployeeEntity savedEmployeeEntity = employeeRepository
				.save(employee.toEmployeeEntity());
		return savedEmployeeEntity.toEmployee();
	}

	@Override
	public void deleteEmplooyee(String employeeId) {
		Optional<EmployeeEntity> employeeEnittyOptional = employeeRepository
				.findById(employeeId);
		if (employeeEnittyOptional.isPresent()) {
			EmployeeEntity employeeEntity = employeeEnittyOptional.get();
			employeeRepository.delete(employeeEntity);
		}
	}

	@Override
	public Employee getEmployee(String employeeId) {
		Employee employee = null;
		Optional<EmployeeEntity> employeeEntityOptional = employeeRepository
				.findById(employeeId);
		if (employeeEntityOptional.isPresent()) {
			employee = employeeEntityOptional.get().toEmployee();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		return employeeEntities.stream()
				.map(employeeEntity -> employeeEntity.toEmployee())
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesByCity(String cityName) {
		List<EmployeeEntity> employeeEntities = employeeRepository
				.findByCity(cityName);
		return employeeEntities.stream()
				.map(employeeEntity -> employeeEntity.toEmployee())
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesByDesignation(String designation) {
		List<EmployeeEntity> employeeEntities = employeeRepository
				.findByDesignation(designation);
		return employeeEntities.stream()
				.map(employeeEntity -> employeeEntity.toEmployee())
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesByCityAndDesignation(String designation, String city) {
		List<EmployeeEntity> employeeEntities = employeeRepository
				.findByDesignationAndCity(designation, city);
		return employeeEntities.stream()
				.map(employeeEntity -> employeeEntity.toEmployee())
				.collect(Collectors.toList());
	}
}
