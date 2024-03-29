package com.pravin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravin.exception.CustomException;
import com.pravin.serviceimpl.CorrespondenceTriggerSerImpl;

@RestController
public class CorrespondenceTriggerController {

	@Autowired
	private CorrespondenceTriggerSerImpl correspondenceTriggerSerImpl;

	@GetMapping(value = "/genrate-notice")
	public ResponseEntity<?> genrateNotice() {
		try {
			Map<String, Integer> count = correspondenceTriggerSerImpl.genrateNotice();
			ResponseEntity<Map<String, Integer>> response = new ResponseEntity<Map<String, Integer>>(count,
					HttpStatusCode.valueOf(200));
			return response;
		} catch (Exception e) {
			CustomException ex = new CustomException(200, "unable to genrate notice");
			ResponseEntity<CustomException> response = new ResponseEntity<>(ex, HttpStatusCode.valueOf(400));
			return response;

		}
	}
}