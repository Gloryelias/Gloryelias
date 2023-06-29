package com.Tracker.authenticationservice.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class JwtRequest
{
    @NotEmpty(message = "Please enter your username")
    private String username;
    @NotEmpty(message = "Please enter your password")
    private String userPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
    
}
