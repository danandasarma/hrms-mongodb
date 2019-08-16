package com.das.samples.hrms.entity;

import java.util.Arrays;
import java.util.List;

public enum DesignationEntity {
	SE("SOFTWARE_ENGINEER"), SSE("SENIOR_SOFTWARE_ENGINEER"), PE(
			"PRINCIPAL_ENGINEER"), ARCHITECT("ARCHITECT"), MANAGER("MANAGER");

	private String value;

	DesignationEntity(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public static DesignationEntity fromValue(String desigValue) {
		for (DesignationEntity d : DesignationEntity.values()) {
			if (String.valueOf(d.value).equals(desigValue)) {
				return d;
			}
		}
		return null;
	}

	public List<DesignationEntity> asList() {
		return Arrays.asList(DesignationEntity.values());
	}
}
