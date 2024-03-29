package com.pravin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.CityzenIncomeDtls;

@Repository
public interface CitizenIncomeDtlsRepository extends JpaRepository<CityzenIncomeDtls, Long> {

	Optional<CityzenIncomeDtls> findByCaseNo(Long valueOf);

}
