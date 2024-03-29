package com.pravin.binding;

public class PlanSelection {
	
	private Long citizenId;
	private Long caseNo;
	private Long PlanId;


	public Long getCitizenId() {
		return citizenId;
	}


	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}


	public Long getCaseNo() {
		return caseNo;
	}


	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}


	public Long getPlanId() {
		return PlanId;
	}


	public void setPlanId(Long planId) {
		PlanId = planId;
	}


	@Override
	public String toString() {
		return "PlanSelection [citizenId=" + citizenId + ", caseNo=" + caseNo + ", PlanId=" + PlanId + "]";
	}
	

}
