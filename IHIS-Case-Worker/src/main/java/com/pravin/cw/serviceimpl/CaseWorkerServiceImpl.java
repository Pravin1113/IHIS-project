package com.pravin.cw.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.cw.binding.DashboardBinding;
import com.pravin.cw.binding.LoginForm;
import com.pravin.cw.binding.Profile;
import com.pravin.cw.service.CaseWorkerService;
import com.pravin.cw.util.EmailUtil;
import com.pravin.entity.CwAccount;
import com.pravin.entity.EligibleDetails;
import com.pravin.repository.AppPlanRepository;
import com.pravin.repository.CitizenAppRepository;
import com.pravin.repository.CwAccountRepository;
import com.pravin.repository.EligibleDetailsRepository;

@Service
public class CaseWorkerServiceImpl implements CaseWorkerService {

	
	@Autowired
	 AppPlanRepository appPlanRepository;
	@Autowired
	 CitizenAppRepository citizenAppRepository;
	@Autowired
	 EligibleDetailsRepository eligibleDetailsRepository;

	@Autowired
	 EmailUtil emailUtil;
	
	@Autowired
	 CwAccountRepository cwAccountRepository;

	@Override
	public String login(LoginForm loginForm) {
		Optional<CwAccount> cwAccountOpt = cwAccountRepository.findByEmailAndPwd(loginForm.getMail(),
				loginForm.getPwd());
		if (cwAccountOpt.isEmpty()) {
			return "Invalid credentials";
		}

		return "Success";
	}

	@Override
	public String forgotPwd(String mail) {
		Optional<CwAccount> cwAccountOpt = cwAccountRepository.findByEmail(mail);
		if (cwAccountOpt.isEmpty()) {
			return "case worker acount not found";
		}

		else {
			CwAccount cwAccount = cwAccountOpt.get();
			String fileName = "recoverpwd.txt";
			;
			String subject = "Password Recovering";
			String body = readBodycontent(fileName, cwAccount);
			boolean isSent = emailUtil.sendEamil(mail, subject, body);
			if (isSent) {
				return "success";
			}
		}
		return null;
	}

	@Override
	public String updateProfile(Profile profile) {
		Optional<CwAccount> cwAccountOpt = cwAccountRepository.findByEmail(profile.getEmail());
		if (cwAccountOpt.isEmpty()) {
			return "case worker acount not found";
		}
		CwAccount cwAccount = cwAccountOpt.get();
		cwAccount.setEmail(profile.getEmail());
		cwAccount.setFullName(profile.getFullName());
		cwAccount.setMobileNo(profile.getMobileNo());
		cwAccount.setSsn(profile.getSsn());
		cwAccountRepository.save(cwAccount);
		return "case worker acount updated Successfully";
	}

	@Override
	public Map<String, Long> countSummery() {
		Long appPlanCount = appPlanRepository.count();
		Long citizenPlanCount = citizenAppRepository.count();
		List<EligibleDetails> details = eligibleDetailsRepository.findAll();

		int approvedDetail = details.stream().filter(ed -> ed.getPlanStatus().equals("Approved"))
				.collect(Collectors.toList()).size();

		int denialDetail = details.stream().filter(ed -> ed.getPlanStatus().equals("Denied"))
				.collect(Collectors.toList()).size();

		DashboardBinding binding = new DashboardBinding();

		binding.setApprovedCount(approvedDetail);
		binding.setAppsCount(citizenPlanCount);
		binding.setDeclinedCount(denialDetail);
		binding.setPlansCount(appPlanCount);

		Map<String, Long> countSummery = new HashMap();

		countSummery.put("citizen plans", citizenPlanCount);
		countSummery.put("approved Detail ", Long.valueOf(approvedDetail));
		countSummery.put("denial Detail", Long.valueOf(denialDetail));
		countSummery.put("total plans", appPlanCount);

		return countSummery;
	}

	@Override
	public Profile fetchCwData(String mail) {
		Optional<CwAccount> cwAccountOpt = cwAccountRepository.findByEmail(mail);
		if (cwAccountOpt.isEmpty()) {
			return null;
		}
		CwAccount cwAccount = cwAccountOpt.get();
		Profile profile = new Profile();
		profile.setEmail(cwAccount.getEmail());
		profile.setFullName(cwAccount.getFullName());
		profile.setGender(cwAccount.getGender());
		profile.setMobileNo(cwAccount.getMobileNo());
		profile.setSsn(cwAccount.getSsn());

		return profile;

	}

	private String readBodycontent(String filename, CwAccount cwAccount) {

		String mailBody = null;

		try {
			StringBuilder sb = new StringBuilder();

			FileReader fileReader = new FileReader(filename);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine(); // reading first line

			while (line != null) {
				sb.append(line); // appending data to buffer obj
				line = br.readLine();// reading next line

			}
			mailBody = sb.toString();

			mailBody = mailBody.replace("{FNAME}", cwAccount.getFullName());
			mailBody = mailBody.replace("{PWD}", cwAccount.getPwd());

			br.close();

		} catch (Exception e) {
			System.out.println(" exception in read body content" + e.getMessage());
		}
		return mailBody;
	}

}
