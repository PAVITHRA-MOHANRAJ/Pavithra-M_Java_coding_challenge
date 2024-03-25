package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidLoanException;
import com.model.Loan;
import com.service.LoanManagementService;

public class LoanManagementController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoanManagementService loanManagementService = new LoanManagementService();
		
		while(true) {
			System.out.println("\n*****************LOAN MANAGEMENT SYSTEM*****************");
			System.out.println("Press 1. To apply for the loan");
			System.out.println("Press 2. To get all loan");
			System.out.println("Press 3. To get particular loan details");
			System.out.println("Press 4. For loan repayment");
			System.out.println("Press 5. To calculate interest amount for particular loan");
			System.out.println("Press 0. To exit");
			System.out.println("********************************************************\n");
			
			System.out.println("Enter your choice: ");
			int input = sc.nextInt();
			
			if(input == 0) {
				System.out.println("Exiting all operations.. Thank You !");
				break;
			}
			
			switch(input) {
			case 1:
				// To apply for the loan
				System.out.println("Enter the loan id: ");
				int loanId = sc.nextInt();
				System.out.println("Enter the customer id for applying loan: ");
				int customerId = sc.nextInt();
				System.out.println("Enter the principal amount: ");
				double principalAmount = sc.nextDouble();
				System.out.println("Enter the interest rate in percentage (%):");
				double interestRate = sc.nextDouble();
				System.out.println("Enter the loan tenure (in months): ");
				int loanTenure = sc.nextInt();
				System.out.println("Enter the loan type (Car Loan / Home Loan): ");
				String loanType = sc.nextLine();
				sc.nextLine();
				String loanStatus = "Pending"; // initially the status is pending
				
				
				System.out.println("Are you sure for applying loan (yes/no): ");
				
				String opinion = sc.next();
				
				if(opinion.equalsIgnoreCase("yes")) {
					try {
						int creditScore = loanManagementService.getCustomer(customerId);
						if(creditScore > 650) {
							loanStatus = "Approved";
						}
						Loan loanApplied = loanManagementService.applyLoan(loanId, customerId, principalAmount, interestRate, loanTenure, loanType, loanStatus);
						System.out.println("Details of your loan :");
						System.out.println(loanApplied);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
				}
				break;
				
			case 2:
				// To get all loan
				try {
					List<Loan> allLoan = loanManagementService.getAllLoan();
					System.out.println("LIST OF LOAN DETAILS: ");
					for(Loan l : allLoan) {
						System.out.println(l);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				// To get particular loan details
				System.out.println("Enter the loan id: ");
				loanId = sc.nextInt();
				try {
					loanManagementService.verifyLoanId(loanId);
					Loan loan = loanManagementService.getLoanById(loanId);
					System.out.println("Loan Details: ");
					System.out.println(loan);
				} catch (InvalidLoanException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				// Loan Repayments
				System.out.println("Enter the loan id: ");
				loanId = sc.nextInt();
				try {
					loanManagementService.verifyLoanId(loanId);
					System.out.println("Enter the amount: ");
					double amount = sc.nextDouble();
					double singleEmi = loanManagementService.calculateEmi(loanId);
					System.out.println("Single Emi : "+ singleEmi);
					if(amount < singleEmi) {
						System.out.println("Payment rejected");
						break;
					}
					else {
						int noOfEmi = loanManagementService.loanRepayment(loanId, amount, singleEmi);
						System.out.println("Number of emi paid : "+ noOfEmi);
						break;
					}
					
				} catch (InvalidLoanException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				// To calculate interest amount for particular loan
				System.out.println("Enter the loan id: ");
				loanId = sc.nextInt();
				try {
					loanManagementService.verifyLoanId(loanId);
					double interest = loanManagementService.calculateInterest(loanId);
					System.out.println("Interest : "+ interest);
				} catch (InvalidLoanException | SQLException e) {
					System.out.println(e.getMessage());
				}
			    break;
									
				
			}
		}
		
		sc.close();
	}

}
