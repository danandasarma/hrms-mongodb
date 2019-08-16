package com.das.samples.hrms.entity;

import com.das.samples.hrms.dto.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressEntity {

	private String streetAddress;

	private String city;

	private String state;

	private String county;

	private String pincode;

	public Address toAddress() {

		// @formatter:off
		return Address.builder()
				.streetAddress(getStreetAddress())
				.city(getCity())
				.state(getState())
				.county(getCounty())
				.pincode(getPincode())
				.build();
		// @formatter:on
	}
}
