package com.exception;

public class InvalidLoanException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidLoanException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
