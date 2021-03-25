package com.blazepizza.ProjectB.bean;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class ProfileBean {

	
	@NotNull
	private String userid;
	
	@NotNull(message="First name cannot be missing or empty")
	private String firstName;
	
	@NotNull(message="First name cannot be missing or empty")
	private String lastName;
	
	
	private String gender;
	
	@Size(min=10,max=10,message="phone number should be of length 10")
	@NotNull(message="phone is a required field")
	private String phone;
	@NotNull(message="street is a required field")
	private String street;
	@NotNull(message="city is a required field")
	private String city;
	@NotNull(message="pincode is a required field")
	private String pincode;
	@NotNull(message="State is a required field")
	private String state;
	
	@Email
	private String email;
	
	@NotNull(message="Password is a required field")
	@Size(min = 8, max = 16, message = "Password must be equal to or greater than 8 characters and less than 16 character")
	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
