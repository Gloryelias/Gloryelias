package com.Tracker.authenticationservice.dto;

import com.Tracker.authenticationservice.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest
{
    @NotEmpty(message = "First name is required")
    private String name;
    @NotEmpty(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @ValidPassword(message = "Password criteria does not match")
    private String userPassword;
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email address")
    @Pattern(regexp = ".*[a-zA-Z]\\.com$", message = "Email must be of format @abc.com")
    private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRegistrationRequest(@NotEmpty(message = "First name is required") String name,
			@NotEmpty(message = "Username is required") String username,
			@NotEmpty(message = "Password is required") String userPassword,
			@NotEmpty(message = "Email is required") @Email(message = "Invalid email address") @Pattern(regexp = ".*[a-zA-Z]\\.com$", message = "Email must be of format @abc.com") String email) {
		super();
		this.name = name;
		this.username = username;
		this.userPassword = userPassword;
		this.email = email;
	}
	public UserRegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
