package com.pravin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.CitizenChild;

@Repository
public interface CitizenChildRepository extends JpaRepository<CitizenChild, Long> {

	Optional<List<CitizenChild>> findByCaseNo(Long caseNo);

}
