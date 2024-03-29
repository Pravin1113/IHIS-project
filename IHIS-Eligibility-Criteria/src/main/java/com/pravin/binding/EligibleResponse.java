package com.pravin.binding;

import java.time.LocalDate;

public class EligibleResponse {
	
	private String planName;
	
	private String planStatus;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String benefitAmt;
	
	private String danialReason;

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

	public String getDanialReason() {
		return danialReason;
	}

	public void setDanialReason(String danialReason) {
		this.danialReason = danialReason;
	}

	@Override
	public String toString() {
		return "EligibleResponse [planName=" + planName + ", planStatus=" + planStatus + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", benefitAmt=" + benefitAmt + ", danialReason=" + danialReason + "]";
	}
	
	
	

}
