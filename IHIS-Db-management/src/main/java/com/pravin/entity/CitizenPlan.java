package com.pravin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CitizenPlan {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		return "CitizenPlan [citizenId=" + citizenId + ", caseNo=" + caseNo + ", PlanId=" + PlanId + "]";
	}
	
	

}
