package com.pravin.binding;

public class Income {
	
	private Long caseNo;
	private Long salaryIncome;
	private Long rentIncome;
	private Long propertyIncome;
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
		return "Income [caseNo=" + caseNo + ", salaryIncome=" + salaryIncome + ", rentIncome=" + rentIncome
				+ ", propertyIncome=" + propertyIncome + "]";
	}
	
	

}
