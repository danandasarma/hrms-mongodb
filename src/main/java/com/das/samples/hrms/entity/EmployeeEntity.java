package com.das.samples.hrms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.das.samples.hrms.dto.Employee;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "employees")
public class EmployeeEntity {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String contactNumber;

	private AddressEntity officeAddressEntity;

	private DesignationEntity designationEntity;

	public Employee toEmployee() {

		// @formatter:off
		return Employee.builder()
				.id(getId())
				.firstName(getFirstName())
				.lastName(getLastName())
				.emailId(getEmailId())
				.contactNumber(getContactNumber())
				.officeAddress(getOfficeAddressEntity().toAddress())
				.designation(getDesignationEntity().toString())
				.build();
		// @formatter:on
	}
}
