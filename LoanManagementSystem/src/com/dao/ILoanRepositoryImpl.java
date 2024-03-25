package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidLoanException;
import com.model.Loan;
import com.util.DBUtil;

public class ILoanRepositoryImpl implements ILoanRepository {

	@Override
	public Loan applyLoan(int loanId, int customerId, double principalAmount, double interestRate, int loanTenure,
			String loanType, String loanStatus) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "insert into loan values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loanId);
		pstmt.setInt(2, customerId);
		pstmt.setDouble(3, principalAmount);
		pstmt.setDouble(4, interestRate);
		pstmt.setInt(5, loanTenure);
		pstmt.setString(6, loanType);
		pstmt.setString(7, loanStatus);

		pstmt.executeUpdate();

		Loan loan = new Loan(loanId, customerId, principalAmount, interestRate, loanTenure, loanType, loanStatus);
		DBUtil.dbClose();
		return loan;
	}

	@Override
	public void verifyLoanId(int loanId) throws InvalidLoanException, SQLException {
		Connection conn = DBUtil.getDBConn();
		int customerId = 0;
		String sql = "select customer_id from loan where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loanId);
		/* execute the statement */
		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {
			customerId = rst.getInt("customer_id");

		}
		if (customerId == 0) {
			throw new InvalidLoanException("Loan not found");
		}
		DBUtil.dbClose();
	}

	@Override
	public double calculateInterest(int loanId) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "select principal_amount, interest_rate, loan_term from loan where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loanId);
		/* execute the statement */
		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {
			double principalAmount = rst.getDouble("principal_amount");
			double interestRate = rst.getDouble("interest_rate");
			int loanTenure = rst.getInt("loan_term");

			double interest = (principalAmount * (interestRate / 100) * loanTenure) / 12;
			return interest;

		}
		DBUtil.dbClose();
		return 0;
	}

	@Override
	public List<Loan> getAllLoan() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Loan> list = new ArrayList<>();
		String sql = "select * from loan";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/* execute the statement */
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id = rst.getInt("id");
			int customerId = rst.getInt("customer_id");
			double principalAmount = rst.getDouble("principal_amount");
			double interestRate = rst.getDouble("interest_rate");
			int loanTenure = rst.getInt("loan_term");
			String loanType = rst.getString("loan_type");
			String loanStatus = rst.getString("loan_status");

			Loan loan = new Loan(id, customerId, principalAmount, interestRate, loanTenure, loanType, loanStatus);
			list.add(loan);

		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public Loan getLoanById(int loanId) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "select * from loan where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loanId);
		/* execute the statement */
		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {
			int id = rst.getInt("id");
			int customerId = rst.getInt("customer_id");
			double principalAmount = rst.getDouble("principal_amount");
			double interestRate = rst.getDouble("interest_rate");
			int loanTenure = rst.getInt("loan_term");
			String loanType = rst.getString("loan_type");
			String loanStatus = rst.getString("loan_status");

			Loan loan = new Loan(id, customerId, principalAmount, interestRate, loanTenure, loanType, loanStatus);
			return loan;

		}
		DBUtil.dbClose();
		return null;
	}

	@Override
	public double calculateEmi(int loanId) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "select principal_amount, interest_rate, loan_term from loan where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, loanId);
		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {

			double principalAmount = rst.getDouble("principal_amount");
			double interestRate = rst.getDouble("interest_rate");
			int loanTenure = rst.getInt("loan_term");
			double r = interestRate / 12 / 100;
			double w = Math.pow(1 + r, loanTenure);
			double z = Math.pow(1 + r, loanTenure - 1);
			double emi = (principalAmount * r * w) / z;

			return emi;

		}
		DBUtil.dbClose();
		return 0;
	}


	@Override
	public int getCustomer(int customerId) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "select credit_score from customer where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		/* execute the statement */
		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {
			int creditScore = rst.getInt("credit_score");
			return creditScore;
		}
		DBUtil.dbClose();
		return 0;
	}

	@Override
	public int loanRepayment(int loanId, double amount, double singleEmi) {
		int noOfEmi = 0;
		while(amount > singleEmi) { 
			noOfEmi +=1;
			amount = amount - singleEmi;
		}
		return noOfEmi;
	}
	
	

}
