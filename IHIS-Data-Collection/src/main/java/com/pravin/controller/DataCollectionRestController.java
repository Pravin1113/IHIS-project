package com.pravin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.binding.Childs;
import com.pravin.binding.Education;
import com.pravin.binding.Income;
import com.pravin.binding.PlanSelection;
import com.pravin.binding.Summery;
import com.pravin.entity.GraduationYearDtls;
import com.pravin.exception.CustomException;
import com.pravin.serviceimpl.DataCollectionServiceImpl;

@RestController
public class DataCollectionRestController {

	@Autowired
	private DataCollectionServiceImpl dataCollectionServiceImpl;

	@PostMapping(value = "/gradution")
	public ResponseEntity saveGradutionDtls(@RequestBody Education education) {
		try {
			String message = dataCollectionServiceImpl.saveEducation(education);
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to save education details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

	@PostMapping(value = "/income")
	public ResponseEntity saveIncome(@RequestBody Income income) {
		try {
			String message = dataCollectionServiceImpl.saveincome(income);
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to save income details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

	@PostMapping(value = "/kids")
	public ResponseEntity saveKids(@RequestBody Childs childs) {
		try {
			String message = dataCollectionServiceImpl.saveKids(childs);
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to save child details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

	@PostMapping(value = "/plans")
	public ResponseEntity savePlans(@RequestBody PlanSelection plan) {
		try {
			String message = dataCollectionServiceImpl.savePlan(plan);
			ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to save plan details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

	@GetMapping(value = "/gratution-year")
	public ResponseEntity getGradutionYear() {
		try {
			List<GraduationYearDtls> years = dataCollectionServiceImpl.getGradutionyears();
			ResponseEntity<List<GraduationYearDtls>> response = new ResponseEntity<List<GraduationYearDtls>>(years,
					HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to get years details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

	@GetMapping(value = "/summery{caseNo}")
	public ResponseEntity getSummery(@PathVariable("caseNo") Long caseNo) {
		try {
			Summery Summery = dataCollectionServiceImpl.getSummery(caseNo);
			ResponseEntity<Summery> response = new ResponseEntity<Summery>(Summery, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to get Summery details");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;
		}
	}

}
