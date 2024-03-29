package com.pravin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.EligibleDetails;

@Repository
public interface EligibleDetailsRepository extends JpaRepository<EligibleDetails, Long> {

	EligibleDetails findByCaseNo(Long caseNo);

}
