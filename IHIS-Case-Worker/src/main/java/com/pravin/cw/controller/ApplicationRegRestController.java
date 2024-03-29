package com.pravin.cw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.cw.serviceimpl.ApplicationRegServiceImpl;
import com.pravin.entity.CitizenApp;
import com.pravin.exception.CustomException;

@RestController
@RequestMapping("/application")
public class ApplicationRegRestController {

	@Autowired
	ApplicationRegServiceImpl applicationRegServiceImpl;

	@GetMapping(value = "/registration")
	public ResponseEntity applicationReg(@RequestBody CitizenApp application) {
		try {
			CitizenApp citizenmAppl = applicationRegServiceImpl.applicationReg(application);
			ResponseEntity<CitizenApp> response = new ResponseEntity<CitizenApp>(citizenmAppl,
					HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to create case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

	@GetMapping(value = "/get-all-reg")
	public ResponseEntity<?> findAllApplication() {
		try {
			List<CitizenApp> citizenmAppl = applicationRegServiceImpl.TotalApplication();
			ResponseEntity<List<CitizenApp>> response = new ResponseEntity<List<CitizenApp>>(citizenmAppl,
					HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to create case worker account");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}

	}

}
