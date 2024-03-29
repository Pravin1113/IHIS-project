package com.pravin.binding;

public class Education {

	private Long CaseNo;

	private String highestDeegree;

	private Long gradutionDtlId;

	private String university;

	public Long getCaseNo() {
		return CaseNo;
	}

	public void setCaseNo(Long caseNo) {
		CaseNo = caseNo;
	}

	public String getHighestDeegree() {
		return highestDeegree;
	}

	public void setHighestDeegree(String highestDeegree) {
		this.highestDeegree = highestDeegree;
	}

	public Long getGradutionDtlId() {
		return gradutionDtlId;
	}

	public void setGradutionDtlId(Long gradutionDtlId) {
		this.gradutionDtlId = gradutionDtlId;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Education [CaseNo=" + CaseNo + ", highestDeegree=" + highestDeegree + ", gradutionDtlId="
				+ gradutionDtlId + ", university=" + university + "]";
	}
	
	

}
