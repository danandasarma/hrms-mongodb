package com.das.samples.hrms.dto;

import java.util.Arrays;
import java.util.List;

import com.das.samples.hrms.entity.DesignationEntity;

public enum Designation {
	SE("SOFTWARE_ENGINEER"), SSE("SENIOR_SOFTWARE_ENGINEER"), PE(
			"PRINCIPAL_ENGINEER"), ARCHITECT("ARCHITECT"), MANAGER("MANAGER");

	private String value;

	Designation(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static Designation fromValue(String desigValue) {
		for (Designation d : Designation.values()) {
			if (String.valueOf(d.value).equals(desigValue)) {
				return d;
			}
		}
		return null;
	}

	public List<Designation> asList() {
		return Arrays.asList(Designation.values());
	}

	public DesignationEntity toDesignationEntity() {
		return DesignationEntity.fromValue(this.value);
	}
}
