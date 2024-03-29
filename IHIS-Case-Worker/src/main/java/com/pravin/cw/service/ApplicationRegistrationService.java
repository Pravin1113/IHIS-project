package com.pravin.cw.service;

import java.util.List;

import com.pravin.entity.CitizenApp;

public interface ApplicationRegistrationService {
	
	public CitizenApp applicationReg(CitizenApp application);
	
	public List<CitizenApp> TotalApplication();

}
