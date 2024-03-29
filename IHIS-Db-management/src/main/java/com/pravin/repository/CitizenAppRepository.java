package com.pravin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.CitizenApp;

@Repository
public interface CitizenAppRepository extends JpaRepository<CitizenApp, Long> {

	Optional<CitizenApp> findByCaseNum(Long caseNo);

}
