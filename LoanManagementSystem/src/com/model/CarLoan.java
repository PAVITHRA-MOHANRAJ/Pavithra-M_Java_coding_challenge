package com.model;

public class CarLoan extends Loan{

	private int carValue;
	private String carModel;
	
	public CarLoan(int carValue, String carModel) {
		super();
		this.carValue = carValue;
		this.carModel = carModel;
	}

	public CarLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarLoan(int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super(customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus);
		// TODO Auto-generated constructor stub
	}

	public CarLoan(int id, int customerId, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		super(id, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus);
		// TODO Auto-generated constructor stub
	}

	public int getCarValue() {
		return carValue;
	}

	public void setCarValue(int carValue) {
		this.carValue = carValue;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	@Override
	public String toString() {
		return "CarLoan [carValue=" + carValue + ", carModel=" + carModel + "]";
	}
	
	
}
