package com.encora.dreambox.client.util.enums;

public enum DataServiceModulesEnum {

	STUDENT("student"), SCHOOL("school");

	private String description;

	private DataServiceModulesEnum(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}
