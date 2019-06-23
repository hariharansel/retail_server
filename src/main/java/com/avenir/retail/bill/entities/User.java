package com.avenir.retail.bill.entities;

import com.avenir.retail.bill.enums.UserTypeEnum;

/**
 * This is considered as entity mapped to table.
 *
 */
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private UserTypeEnum type;
	//private Date createdDate;
	
	public User() {}
	
	public User(Long id, String firstName, String lastName, String email, String phoneNumber, UserTypeEnum type) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.type = type;
		//this.createdDate 
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public UserTypeEnum getType() {
		return type;
	}
	public void setType(UserTypeEnum type) {
		this.type = type;
	}
	
}
