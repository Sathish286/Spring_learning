package com.sathish.mobileapp.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRest {

//	@NotNull
//	private String userId;
//	@NotNull(message="firstName cannot be null")
	private String firstName;
	@NotNull(message="lastName cannot be null")
	private String lastName;
	@NotNull
	@Size(min=2,max=16,message="Password cannot be less than 2 or more than 16")
	private String password;
	@Email
	@NotNull
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
