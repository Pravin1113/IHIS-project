package com.pravin.serviceimpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.binding.EligibleResponse;
import com.pravin.entity.AppPlan;
import com.pravin.entity.CitizenApp;
import com.pravin.entity.CitizenPlan;
import com.pravin.entity.CityzenIncomeDtls;
import com.pravin.entity.CorrespondenceTrigger;
import com.pravin.entity.EligibleDetails;
import com.pravin.repository.AppPlanRepository;
import com.pravin.repository.CitizenAppRepository;
import com.pravin.repository.CitizenChildRepository;
import com.pravin.repository.CitizenIncomeDtlsRepository;
import com.pravin.repository.CitizenPlanRepository;
import com.pravin.repository.CorrespondenceTriggerRepository;
import com.pravin.repository.EligibleDetailsRepository;
import com.pravin.service.CitizenEligibilityService;
import com.pravin.util.RandomUtil;

@Service
public class CitizenEligibiltyServiceImpl implements CitizenEligibilityService {

	
	@Autowired
	private CitizenAppRepository citizenAppRepository;

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Autowired
	private AppPlanRepository appPlanRepository;

	@Autowired
	private CitizenIncomeDtlsRepository citizenIncomeDtlsRepository;

	@Autowired
	private CitizenChildRepository citizenChildRepository;

	@Autowired
	private EligibleDetailsRepository detailsRepository;

	@Autowired
	private CorrespondenceTriggerRepository correspondenceTriggerRepository;

	@Override
	public EligibleResponse eligibleForPlan(Long caseNo) {
		EligibleResponse eligibleResponse = new EligibleResponse();

		Optional<CitizenPlan> citizenplanOpt = citizenPlanRepository.findByCaseNo(caseNo);
		if (citizenplanOpt.isEmpty()) {
			eligibleResponse.setDanialReason("case number not found");
			return eligibleResponse;
		}
		CitizenPlan citizenPlan = citizenplanOpt.get();
		AppPlan appPlan = appPlanRepository.findById(citizenPlan.getPlanId()).get();

		CityzenIncomeDtls incomeDtls = citizenIncomeDtlsRepository.findByCaseNo(caseNo).get();

		if ("SAP".equals(appPlan.getPlanName()) && incomeDtls.getSalaryIncome() < 300) {
			eligibleResponse.setDanialReason("salary is less for this plan");
			return eligibleResponse;

		}
		CitizenApp citizenApp = citizenAppRepository.findByCaseNum(caseNo).get();
		if ("MEICLAIME".equals(appPlan.getPlanName()) && RandomUtil.getAge(citizenApp.getDob()) > 65) {
			eligibleResponse.setDanialReason("Age is greater for apply this plan");
			return eligibleResponse;

		}
		eligibleResponse.setStartDate(LocalDate.now());
		eligibleResponse.setEndDate(LocalDate.now().plusYears(1));
		eligibleResponse.setDanialReason("NA");
		eligibleResponse.setPlanStatus("APPROVED");
		eligibleResponse.setBenefitAmt("500");

		saveEligibleDtls(eligibleResponse, caseNo);

		saveCorrespondenceTrigger(caseNo);

		return eligibleResponse;

	}

	private void saveCorrespondenceTrigger(Long caseNo) {
		CorrespondenceTrigger trigger = new CorrespondenceTrigger();
		trigger.setCaseNo(caseNo);
		trigger.setTrigerStatus("PENDING");
		trigger.setNotice(null);

		correspondenceTriggerRepository.save(trigger);

	}

	private void saveEligibleDtls(EligibleResponse eligibleResponse, Long caseNo) {

		EligibleDetails details = new EligibleDetails();
		details.setBenefitAmt(eligibleResponse.getBenefitAmt());
		details.setCaseNo(caseNo);
		details.setPlanName(eligibleResponse.getPlanName());
		details.setDaniealReason(eligibleResponse.getDanialReason());
		details.setPlanStatus(eligibleResponse.getPlanStatus());
		details.setStartDate(eligibleResponse.getStartDate());
		details.setEndDate(eligibleResponse.getEndDate());
		detailsRepository.save(details);

	}

}
