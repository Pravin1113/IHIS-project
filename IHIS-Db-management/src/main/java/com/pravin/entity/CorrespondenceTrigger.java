package com.pravin.entity;

import java.sql.Blob;
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
public class CorrespondenceTrigger {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private Long caseNo;
	
	private String trigerStatus;
	
	
	private Blob notice;


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

	public String getTrigerStatus() {
		return trigerStatus;
	}

	public void setTrigerStatus(String trigerStatus) {
		this.trigerStatus = trigerStatus;
	}

	public Blob getNotice() {
		return notice;
	}

	public void setNotice(Blob notice) {
		this.notice = notice;
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
		return "CorrespondenceTrigger [Id=" + Id + ", caseNo=" + caseNo + ", trigerStatus=" + trigerStatus + ", notice="
				+ notice + ", CreatedDate=" + CreatedDate + ", UpdatedDate=" + UpdatedDate + ", CreatedBy=" + CreatedBy
				+ ", LastModifyBy=" + LastModifyBy + "]";
	}

	
	
}
