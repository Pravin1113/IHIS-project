package com.pravin.exception;

public class CustomException  extends RuntimeException{
	
	int statuscode;
	String message;
	public CustomException(int statuscode, String message) {
		super();
		this.statuscode = statuscode;
		this.message = message;
	}
	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}


}
