package com.pravin.cw.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pravin.cw.service.ApplicationRegistrationService;
import com.pravin.entity.CitizenApp;
import com.pravin.repository.CitizenAppRepository;

public class ApplicationRegServiceImpl implements ApplicationRegistrationService {
	
	@Autowired
	CitizenAppRepository citizenAppRepository;

	@Override
	public CitizenApp applicationReg(CitizenApp application) {
		return citizenAppRepository.save(application);
	}

	@Override
	public List<CitizenApp> TotalApplication() {
		return citizenAppRepository.findAll();
	}

}
