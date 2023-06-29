package com.Tracker.authenticationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse
{
    private String message;
    private List<String> errors;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public ErrorResponse(String message, List<String> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}
	public ErrorResponse() {
		super();
	}
	
}
