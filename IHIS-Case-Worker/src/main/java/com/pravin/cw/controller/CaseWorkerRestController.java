package com.pravin.cw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.cw.binding.LoginForm;
import com.pravin.cw.binding.Profile;
import com.pravin.cw.serviceimpl.CaseWorkerServiceImpl;
import com.pravin.exception.CustomException;

@RestController
@RequestMapping("cw")
public class CaseWorkerRestController {

	@Autowired
	private CaseWorkerServiceImpl caseWorkerServiceImpl;

	@PostMapping(value = "/login")
	public ResponseEntity loginCaseAc(@RequestBody LoginForm form) {
		try {
			String msg = caseWorkerServiceImpl.login(form);
			ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to create case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@PostMapping(value = "/update")
	public ResponseEntity updateCaseAc(@RequestBody Profile form) {
		try {
			String msg = caseWorkerServiceImpl.updateProfile(form);
			ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to update case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@PostMapping(value = "/update{email}")
	public ResponseEntity forgotCwPwd(@PathVariable String email) {
		try {
			String msg = caseWorkerServiceImpl.forgotPwd(email);
			ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to forgot pwd");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@GetMapping(value = "/dashboard")
	public ResponseEntity dashboardSummery() {
		try {
			Map<String, Long> countSummery = caseWorkerServiceImpl.countSummery();
			ResponseEntity<Map> response = new ResponseEntity<Map>(countSummery, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to fetch data");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@GetMapping(value = "/fetch-data{email}")
	public ResponseEntity dashboardSummery(@PathVariable String email) {
		try {
			Profile cwAccData = caseWorkerServiceImpl.fetchCwData(email);
			ResponseEntity<Profile> response = new ResponseEntity<Profile>(cwAccData, HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to fetch data");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

}
