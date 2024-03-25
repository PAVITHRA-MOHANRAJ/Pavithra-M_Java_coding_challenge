package com.model;

public class Customer {

	private int id;
	private String name;
	private String emailAddress;
	private String phoneNumber;
	private String address;
	private int creditScore;
	
	// constructor without arguments
	public Customer() {	}

	// constructor with all fields
	public Customer(int id, String name, String emailAddress, String phoneNumber, String address, int creditScore) {
		super();
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditScore = creditScore;
	}

	// constructor without id
	public Customer(String name, String emailAddress, String phoneNumber, String address, int creditScore) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditScore = creditScore;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	// to string method
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", creditScore=" + creditScore + "]";
	}
	
	
		
}
