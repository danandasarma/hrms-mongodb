package com.das.samples.hrms.dto;

import com.das.samples.hrms.entity.AddressEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private String streetAddress;

	private String city;

	private String state;

	private String county;

	private String pincode;

	public AddressEntity toAddressEntity() {

		// @formatter:off
		return AddressEntity.builder()
				.streetAddress(getStreetAddress())
				.city(getCity())
				.state(getState())
				.county(getCounty())
				.pincode(getPincode())
				.build();
		
		// @formatter:on
	}
}
