package com.pravin.service;

import com.pravin.binding.EligibleResponse;

public interface CitizenEligibilityService {

	public EligibleResponse eligibleForPlan(Long CaseNo);
	
}
