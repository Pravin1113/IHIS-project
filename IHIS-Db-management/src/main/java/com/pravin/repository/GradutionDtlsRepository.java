package com.pravin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.GradutionDtls;

@Repository
public interface GradutionDtlsRepository extends JpaRepository<GradutionDtls, Long> {

	Optional<GradutionDtls> findByCaseNo(Long valueOf);

}
