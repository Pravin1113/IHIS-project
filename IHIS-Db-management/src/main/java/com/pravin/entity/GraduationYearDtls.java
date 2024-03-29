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
public class GraduationYearDtls {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private long year;

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

	
	
	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "GraduationYearDtls [Id=" + Id + ", year=" + year + ", CreatedDate=" + CreatedDate + ", UpdatedDate="
				+ UpdatedDate + ", CreatedBy=" + CreatedBy + ", LastModifyBy=" + LastModifyBy + "]";
	}

	
	
}
