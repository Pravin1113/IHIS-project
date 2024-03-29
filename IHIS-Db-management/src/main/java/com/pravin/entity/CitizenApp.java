package com.pravin.entity;

import java.time.LocalDate;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
public class CitizenApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caseNum;
	private String fullName;
	private String email;
	private String mobileNo;
	private String stateName;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	private String activeSwitch;

	@CreationTimestamp
	private LocalDate CreatedDate;

	@UpdateTimestamp
	private LocalDate UpdatedDate;

	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;

	@LastModifiedBy
	private String LastModifyBy;

	public Long getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Long caseNum) {
		this.caseNum = caseNum;
	}

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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getActiveSwitch() {
		return activeSwitch;
	}

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
	}

	public LocalDate getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		CreatedDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		UpdatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getLastModifyBy() {
		return LastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		LastModifyBy = lastModifyBy;
	}

	@Override
	public String toString() {
		return "CitizenApp [caseNum=" + caseNum + ", fullName=" + fullName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", stateName=" + stateName + ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn
				+ ", activeSwitch=" + activeSwitch + ", CreatedDate=" + CreatedDate + ", UpdatedDate=" + UpdatedDate
				+ ", CreatedBy=" + CreatedBy + ", LastModifyBy=" + LastModifyBy + "]";
	}

	
}
