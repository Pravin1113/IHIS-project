package com.pravin.service;

import com.pravin.entity.AppPlan;
import com.pravin.entity.CwAccount;

public interface AdminApiService {
	
	public CwAccount createCaseWkAcc(CwAccount account);
	
	public String deleteCaseWkAcc(Long id);
	
	public AppPlan createplan(AppPlan appPlan);
	
	
	
	
	
	

}
