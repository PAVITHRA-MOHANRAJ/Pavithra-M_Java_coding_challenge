package com.model;

public class Loan {

	private int id;
	private int customerId;
	private double principalAmount;
	private double interestRate;
	private int loanTerm;
	private String loanType;
	private String loanStatus;
	
	// constructor without arguments
	public Loan() {	}
	
	// constructor with all fields
	public Loan(int id, int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
	}
	
	// constructor without id
	public Loan(int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super();
		this.customerId = customerId;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	// to string method
	@Override
	public String toString() {
		return "Loan [id=" + id + ", customerId=" + customerId + ", principalAmount=" + principalAmount
				+ ", interestRate=" + interestRate + ", loanTerm=" + loanTerm + ", loanType=" + loanType
				+ ", loanStatus=" + loanStatus + "]";
	}
	
	
}
