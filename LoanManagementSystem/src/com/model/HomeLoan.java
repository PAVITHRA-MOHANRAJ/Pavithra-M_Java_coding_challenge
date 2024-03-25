package com.model;

public class HomeLoan extends Loan{

	private int propertyValue;
	private String propertyAddress;
	
	
	
	public HomeLoan() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HomeLoan(int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super(customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus);
		// TODO Auto-generated constructor stub
	}



	public HomeLoan(int id, int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super(id, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus);
		// TODO Auto-generated constructor stub
	}



	public HomeLoan(int propertyValue, String propertyAddress) {
		super();
		this.propertyValue = propertyValue;
		this.propertyAddress = propertyAddress;
	}



	public int getPropertyValue() {
		return propertyValue;
	}



	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}



	public String getPropertyAddress() {
		return propertyAddress;
	}



	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}



	@Override
	public String toString() {
		return "HomeLoan [propertyValue=" + propertyValue + ", propertyAddress=" + propertyAddress + "]";
	}
	
	
	
}
