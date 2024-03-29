package com.pravin.cw.service;

import java.util.Map;

import com.pravin.cw.binding.DashboardBinding;
import com.pravin.cw.binding.LoginForm;
import com.pravin.cw.binding.Profile;

public interface CaseWorkerService {

	
	public String login(LoginForm loginForm);
	
	public String forgotPwd(String email);
	
	public String updateProfile(Profile profile);
	
	public Map<String, Long> countSummery();
	
	public Profile fetchCwData(String mail);
	
	
	
}
