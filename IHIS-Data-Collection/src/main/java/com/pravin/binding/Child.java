package com.pravin.binding;

import java.time.LocalDate;

public class Child {
	
	private Long caseNo;

	private String  childName;
	private LocalDate childDob;
	private Integer childSsn;
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public LocalDate getChildDob() {
		return childDob;
	}
	public void setChildDob(LocalDate childDob) {
		this.childDob = childDob;
	}
	public Integer getChildSsn() {
		return childSsn;
	}
	public void setChildSsn(Integer childSsn) {
		this.childSsn = childSsn;
	}
	
	
	public Long getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}
	
	@Override
	public String toString() {
		return "Child [caseNo=" + caseNo + ", childName=" + childName + ", childDob=" + childDob + ", childSsn="
				+ childSsn + "]";
	}
	
	

}
