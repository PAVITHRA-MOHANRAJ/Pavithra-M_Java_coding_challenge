package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.ILoanRepository;
import com.dao.ILoanRepositoryImpl;
import com.exception.InvalidLoanException;
import com.model.Loan;

public class LoanManagementService {
	ILoanRepository iLoanRepository = new ILoanRepositoryImpl();

	public Loan applyLoan(int loanId, int customerId, double principalAmount, double interestRate, int loanTenure, String loanType,
			String loanStatus) throws SQLException {
		return iLoanRepository.applyLoan(loanId, customerId, principalAmount, interestRate, loanTenure, loanType, loanStatus);
	}

	public void verifyLoanId(int loanId) throws InvalidLoanException, SQLException {
		iLoanRepository.verifyLoanId(loanId);
	}

	public double calculateInterest(int loanId) throws SQLException {
		return iLoanRepository.calculateInterest(loanId);
	}

	public List<Loan> getAllLoan() throws SQLException {
		return iLoanRepository.getAllLoan();
	}

	public Loan getLoanById(int loanId) throws SQLException {
		return iLoanRepository.getLoanById(loanId);
	}

	public double calculateEmi(int loanId) throws SQLException {
		return iLoanRepository.calculateEmi(loanId);
	}
	
	
	public int getCustomer(int customerId) throws SQLException {
		return iLoanRepository.getCustomer(customerId);
	}

	public int loanRepayment(int loanId, double amount, double singleEmi) {
		return iLoanRepository.loanRepayment(loanId, amount, singleEmi);
	}
}
