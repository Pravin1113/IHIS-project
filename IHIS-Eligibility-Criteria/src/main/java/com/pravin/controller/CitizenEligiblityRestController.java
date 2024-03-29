package com.pravin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.binding.EligibleResponse;
import com.pravin.entity.CitizenApp;
import com.pravin.exception.CustomException;
import com.pravin.serviceimpl.CitizenEligibiltyServiceImpl;

@RestController
public class CitizenEligiblityRestController {

	
	@Autowired
	CitizenEligibiltyServiceImpl citizenEligibiltyServiceImpl;
	
	@GetMapping(value = "/eligiblity-check{caseNo}")
	public ResponseEntity<?> findAllApplication(@PathVariable ("caseNo") Long caseNo) {
		try {
			EligibleResponse eligibleResponse = citizenEligibiltyServiceImpl.eligibleForPlan(caseNo);
			ResponseEntity<EligibleResponse> response = new ResponseEntity<EligibleResponse>(eligibleResponse,
					HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to check eligiblity");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

}
}