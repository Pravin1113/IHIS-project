package com.pravin.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
public class GradutionDtls {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long caseNo;
	
	private String highestDeegree;
	
	private Long gradutionDtlId;
	
	private String university;

	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	
	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;
	
	@LastModifiedBy
	private String LastModifyBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "GradutionDtls [id=" + id + ", caseNo=" + caseNo + ", highestDeegree=" + highestDeegree
				+ ", gradutionDtlId=" + gradutionDtlId + ", university=" + university + ", CreatedDate=" + CreatedDate
				+ ", UpdatedDate=" + UpdatedDate + ", CreatedBy=" + CreatedBy + ", LastModifyBy=" + LastModifyBy + "]";
	}
	
	

}
