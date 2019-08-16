package com.das.samples.hrms.dto;

import org.springframework.data.annotation.Id;

import com.das.samples.hrms.entity.DesignationEntity;
import com.das.samples.hrms.entity.EmployeeEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String contactNumber;

	private Address officeAddress;

	private String designation;

	public EmployeeEntity toEmployeeEntity() {

		// @formatter:off
		return EmployeeEntity.builder()
				.firstName(getFirstName())
				.lastName(getLastName())
				.emailId(getEmailId())
				.contactNumber(getContactNumber())
				.officeAddressEntity(getOfficeAddress().toAddressEntity())
				.designationEntity(DesignationEntity.fromValue(designation))
				.build();
		
		// @formatter:on
	}
}
