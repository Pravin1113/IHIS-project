package com.pravin.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.AppPlan;

@Repository
public interface AppPlanRepository extends JpaRepository<AppPlan, Long> {

}
