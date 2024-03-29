package com.pravin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CityzenIncomeDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long incomeId;
	private Long caseNo;
	private Long salaryIncome;
	private Long rentIncome;
	private Long propertyIncome;
	public Long getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}
	public Long getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}
	public Long getSalaryIncome() {
		return salaryIncome;
	}
	public void setSalaryIncome(Long salaryIncome) {
		this.salaryIncome = salaryIncome;
	}
	public Long getRentIncome() {
		return rentIncome;
	}
	public void setRentIncome(Long rentIncome) {
		this.rentIncome = rentIncome;
	}
	public Long getPropertyIncome() {
		return propertyIncome;
	}
	public void setPropertyIncome(Long propertyIncome) {
		this.propertyIncome = propertyIncome;
	}
	@Override
	public String toString() {
		return "CityzenIncomeDtls [incomeId=" + incomeId + ", caseNo=" + caseNo + ", salaryIncome=" + salaryIncome
				+ ", rentIncome=" + rentIncome + ", propertyIncome=" + propertyIncome + "]";
	}
	
	
	
	
	
}
