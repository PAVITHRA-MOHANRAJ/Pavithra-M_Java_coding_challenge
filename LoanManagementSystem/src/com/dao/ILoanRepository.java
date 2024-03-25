package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.InvalidLoanException;
import com.model.Loan;

public interface ILoanRepository {

	Loan applyLoan(int loanId, int customerId, double principalAmount, double interestRate,  int loanTenure, String loanType,
			String loanStatus) throws SQLException;

	void verifyLoanId(int loanId) throws InvalidLoanException, SQLException;

	double calculateInterest(int loanId) throws SQLException;

	List<Loan> getAllLoan() throws SQLException;

	Loan getLoanById(int loanId) throws SQLException;

	double calculateEmi(int loanId) throws SQLException;

	int getCustomer(int customerId) throws SQLException;

	int loanRepayment(int loanId, double amount, double singleEmi);

	 
}
