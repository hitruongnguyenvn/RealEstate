package com.unknown.enums;

public enum GenderEnum {

	FEMALE("Nữ"), MALE("Nam"), ORTHER("Khác");

	private final String genderValue;

	GenderEnum(String genderValue) {
		this.genderValue = genderValue;
	}

	public String getGenderValue() {
		return this.genderValue;
	}

}
