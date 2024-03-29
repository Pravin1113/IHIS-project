package com.pravin.cw.binding;

public class Profile {
	
	private String fullName;
	
	private String email;
	private String mobileNo;
	private String gender;
	private Long ssn;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "Profile [fullName=" + fullName + ", email=" + email + ", mobileNo=" + mobileNo + ", gender=" + gender
				+ ", ssn=" + ssn + "]";
	}
	
	      

}
