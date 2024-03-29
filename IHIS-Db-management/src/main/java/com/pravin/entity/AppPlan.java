package com.pravin.entity;

import java.time.LocalDate;
import java.util.Date;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long planId;
	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private long CategoryId;
	
	private String activeSwitch;
	
	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	
	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;
	
	@LastModifiedBy
	private String LastModifyBy;

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
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
		return "AppPlan [planId=" + planId + ", planName=" + planName + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", CategoryId=" + CategoryId + ", activeSwitch=" + activeSwitch
				+ ", CreatedDate=" + CreatedDate + ", UpdatedDate=" + UpdatedDate + ", CreatedBy=" + CreatedBy
				+ ", LastModifyBy=" + LastModifyBy + "]";
	}

	
}
