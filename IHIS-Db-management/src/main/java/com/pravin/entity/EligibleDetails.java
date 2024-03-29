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
public class EligibleDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;

	private Long caseNo;
	private String planName;

	private String planStatus;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String benefitAmt;
	
	private String daniealReason;

	
	

	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	
	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;
	
	@LastModifiedBy
	private String LastModifyBy;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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
	
	

	public Long getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getBenefitAmt() {
		return benefitAmt;
	}

	public void setBenefitAmt(String benefitAmt) {
		this.benefitAmt = benefitAmt;
	}

	public String getDaniealReason() {
		return daniealReason;
	}

	public void setDaniealReason(String daniealReason) {
		this.daniealReason = daniealReason;
	}

	@Override
	public String toString() {
		return "EligibleDetails [Id=" + Id + ", caseNo=" + caseNo + ", planName=" + planName + ", planStatus="
				+ planStatus + ", startDate=" + startDate + ", endDate=" + endDate + ", benefitAmt=" + benefitAmt
				+ ", daniealReason=" + daniealReason + ", CreatedDate=" + CreatedDate + ", UpdatedDate=" + UpdatedDate
				+ ", CreatedBy=" + CreatedBy + ", LastModifyBy=" + LastModifyBy + "]";
	}

	
	
}
