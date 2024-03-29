package com.pravin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.PlanCategoryMaster;

@Repository
public interface PlancategoryRepository extends JpaRepository<PlanCategoryMaster, Long> {

}
