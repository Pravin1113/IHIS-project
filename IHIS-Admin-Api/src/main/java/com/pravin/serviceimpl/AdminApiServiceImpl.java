package com.pravin.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.entity.AppPlan;
import com.pravin.entity.CwAccount;
import com.pravin.repository.AppPlanRepository;
import com.pravin.repository.CwAccountRepository;
import com.pravin.service.AdminApiService;

@Service
public class AdminApiServiceImpl implements AdminApiService {

	@Autowired
	CwAccountRepository cwAccountRepository;
	
	@Autowired
	AppPlanRepository appPlanRepository;

	public AdminApiServiceImpl(CwAccountRepository cwAccountRepository) {
		this.cwAccountRepository = cwAccountRepository;
	}

	@Override
	public CwAccount createCaseWkAcc(CwAccount account) {
		return cwAccountRepository.save(account);
	}

	@Override
	public String deleteCaseWkAcc(Long id) {
		Optional<CwAccount> cwAccount = cwAccountRepository.findById(id);
		if (cwAccount.isPresent()) {
			cwAccountRepository.deleteById(id);
			return "case Worker account deleted succesfully";
		} else {
			return "case Worker account not found";
		}

	}

	@Override
	public AppPlan createplan(AppPlan appPlan) {
		return appPlanRepository.save(appPlan);
	}
}
