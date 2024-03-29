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
public class PlanCategoryMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long CategoryId;
	
	private String catogoryName;
	
	@CreationTimestamp
	private LocalDate CreatedDate;
	
	@UpdateTimestamp
	private LocalDate UpdatedDate;
	
	@org.springframework.data.annotation.CreatedBy
	private String CreatedBy;
	
	@LastModifiedBy
	private String LastModifyBy;

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

	public String getCatogoryName() {
		return catogoryName;
	}

	public void setCatogoryName(String catogoryName) {
		this.catogoryName = catogoryName;
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
		return "PlanCategoryMaster [CategoryId=" + CategoryId + ", catogoryName=" + catogoryName + ", CreatedDate="
				+ CreatedDate + ", UpdatedDate=" + UpdatedDate + ", CreatedBy=" + CreatedBy + ", LastModifyBy="
				+ LastModifyBy + "]";
	}
	
	
	
	
	
	
	

}
