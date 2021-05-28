package com.example.api.config.validation;

public class ErrorFormDto {
	
	private String field;
	private String messageError;

	public ErrorFormDto(String field, String messageError) {
		this.field 			= field;
		this.messageError	= messageError;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return messageError;
	}
}
