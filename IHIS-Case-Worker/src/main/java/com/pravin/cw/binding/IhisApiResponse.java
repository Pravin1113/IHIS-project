package com.pravin.cw.binding;

public class IhisApiResponse {
	
	public String message;
	
	public String Status;
	
	public String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "IhisApiResponse [message=" + message + ", Status=" + Status + ", code=" + code + "]";
	}
	
	

}
