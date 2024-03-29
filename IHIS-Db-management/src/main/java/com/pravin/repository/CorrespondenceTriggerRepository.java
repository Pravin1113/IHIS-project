package com.pravin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravin.entity.CorrespondenceTrigger;

@Repository
public interface CorrespondenceTriggerRepository extends JpaRepository<CorrespondenceTrigger, Long>{

	List<CorrespondenceTrigger> findByTrigerStatus(String string);

}
