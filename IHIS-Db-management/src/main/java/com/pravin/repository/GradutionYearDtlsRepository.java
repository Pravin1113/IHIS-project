package com.pravin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.GraduationYearDtls;

@Repository
public interface GradutionYearDtlsRepository  extends JpaRepository<GraduationYearDtls, Long>{

}
