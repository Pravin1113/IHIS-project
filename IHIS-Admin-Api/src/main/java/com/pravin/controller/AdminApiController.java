package com.pravin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.entity.AppPlan;
import com.pravin.entity.CwAccount;
import com.pravin.exception.CustomException;
import com.pravin.serviceimpl.AdminApiServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminApiController {

	@Autowired
	AdminApiServiceImpl adminApiServiceImpl;

	@PostMapping(value = "/create-cw")
	public ResponseEntity createCaseAc(@RequestBody CwAccount csAccount) {
		try {
			CwAccount cwAccount = adminApiServiceImpl.createCaseWkAcc(csAccount);
			ResponseEntity<CwAccount> response = new ResponseEntity<CwAccount>(cwAccount, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to create case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@DeleteMapping(value = "/delete-cw/{id}")
	public ResponseEntity deleteCaseWc(@PathVariable Long id) {
		try {
			String msg = adminApiServiceImpl.deleteCaseWkAcc(id);
			ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatusCode.valueOf(200));
			return response;

		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to delete case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}
	}

	@PostMapping(value = "/create-plan")
	public ResponseEntity createPlanForCitizen(@RequestBody AppPlan appPlan) {
		try {
			AppPlan plans = adminApiServiceImpl.createplan(appPlan);
			ResponseEntity<AppPlan> response = new ResponseEntity<AppPlan>(plans, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to create app plan");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}
}
