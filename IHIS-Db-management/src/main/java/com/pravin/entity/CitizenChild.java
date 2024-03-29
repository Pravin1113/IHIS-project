package com.pravin.entity;

import java.time.LocalDate;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
public class CitizenChild {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private Long caseNo;
	private String  childName;
	private LocalDate childDob;
	private Integer childSsn;


	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	
	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;
	
	@LastModifiedBy
	private String LastModifyBy;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	

	public Long getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(Long caseNo) {
		this.caseNo = caseNo;
	}

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
		return "CitizenChild [Id=" + Id + ", caseNo=" + caseNo + ", childName=" + childName + ", childDob=" + childDob
				+ ", childSsn=" + childSsn + ", CreatedDate=" + CreatedDate + ", UpdatedDate=" + UpdatedDate
				+ ", CreatedBy=" + CreatedBy + ", LastModifyBy=" + LastModifyBy + "]";
	}
	
	
}
