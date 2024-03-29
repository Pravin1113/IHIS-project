package com.pravin.binding;

import java.util.List;

public class Childs {
	
	private Long caseNo;

	private List<Child> childs;

	public Long getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Childs [caseNo=" + caseNo + ", childs=" + childs + "]";
	}
	
	

}
