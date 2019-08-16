package com.das.samples.hrms.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.das.samples.hrms.dto.Address;
import com.das.samples.hrms.dto.Designation;
import com.das.samples.hrms.dto.Employee;
import com.das.samples.hrms.entity.EmployeeEntity;
import com.das.samples.hrms.repository.EmployeeRepository;

@Component
public class DBSeederUtil implements CommandLineRunner {

	private EmployeeRepository employeeRepository;

	public DBSeederUtil(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		// @formatter:off
		EmployeeEntity james = Employee.builder()
								.firstName("James")
								.lastName("Butt")
								.emailId("jbutt@gmail.com")
								.contactNumber("504-621-8927")
								.officeAddress(
										Address.builder()
												.streetAddress("6649 N Blue Gum St")
												.city("New Orleans")
												.state("LA")
												.county("Orleans")
												.pincode("70116")
												.build()
										)
								.designation(Designation.SE.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on
		// employeesList.add(employee);

		// @formatter:off
		EmployeeEntity josephine = Employee.builder()
								.firstName("Josephine")
								.lastName("Darakjy")
								.emailId("josephine_darakjy@darakjy.org")
								.contactNumber("810-292-9388")
								.officeAddress(
										Address.builder()
												.streetAddress("4 B Blue Ridge Blvd")
												.city("Brighton")
												.county("Livingston")
												.state("MI")
												.pincode("48116")
												.build()
										)
								.designation(Designation.SSE.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on

		// @formatter:off
		EmployeeEntity art = Employee.builder()
								.firstName("Art")
								.lastName("Venere")
								.emailId("art@venere.org")
								.contactNumber("856-636-8749")
								.officeAddress(
										Address.builder()
												.streetAddress("8 W Cerritos Ave #54")
												.city("Bridgeport")
												.county("Gloucester")
												.state("NJ")
												.pincode("8014")
												.build()
										)
								.designation(Designation.PE.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on

		// @formatter:off
		EmployeeEntity lenna = Employee.builder()
								.firstName("Lenna")
								.lastName("Paprocki")
								.emailId("lpaprocki@hotmail.com")
								.contactNumber("907-385-4412")
								.officeAddress(
										Address.builder()
												.streetAddress("639 Main St")
												.city("Anchorage")
												.county("Anchorage")
												.state("AK")
												.pincode("99501")
												.build()
										)
								.designation(Designation.ARCHITECT.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on

		// @formatter:off
		EmployeeEntity donette = Employee.builder()
								.firstName("Donette")
								.lastName("Foller")
								.emailId("donette.foller@cox.net")
								.contactNumber("513-570-1893")
								.officeAddress(
										Address.builder()
												.streetAddress("34 Center St")
												.city("Hamilton")
												.county("Butler")
												.state("OH")
												.pincode("45011")
												.build()
										)
								.designation(Designation.MANAGER.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on

		// @formatter:off
		EmployeeEntity simona = Employee.builder()
								.firstName("Simona")
								.lastName("Morasca")
								.emailId("simona@morasca.com")
								.contactNumber("419-503-2484")
								.officeAddress(
										Address.builder()
												.streetAddress("3 Mcauley Dr")
												.city("Ashland")
												.county("Ashland")
												.state("OH")
												.pincode("44805")
												.build()
										)
								.designation(Designation.MANAGER.toString())
								.build()
								.toEmployeeEntity();
		// @formatter:on

		// Delete all employees before start of every run
		this.employeeRepository.deleteAll();

		List<EmployeeEntity> employeesList = Arrays.asList(james, josephine,
				art, lenna, donette, simona);
		for (EmployeeEntity employeeEntity : employeesList) {
			this.employeeRepository.save(employeeEntity);
		}
	}

}
