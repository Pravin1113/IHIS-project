package com.pravin.cw.binding;

public class LoginForm {
	
	private String mail;
	
	private String pwd;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "LoginForm [mail=" + mail + ", pwd=" + pwd + "]";
	}
	
 

}
