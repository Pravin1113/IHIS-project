package com.pravin.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pravin.binding.Child;
import com.pravin.binding.Childs;
import com.pravin.binding.Education;
import com.pravin.binding.Income;
import com.pravin.binding.PlanSelection;
import com.pravin.binding.Summery;
import com.pravin.entity.AppPlan;
import com.pravin.entity.CitizenChild;
import com.pravin.entity.CitizenPlan;
import com.pravin.entity.CityzenIncomeDtls;
import com.pravin.entity.GraduationYearDtls;
import com.pravin.entity.GradutionDtls;
import com.pravin.repository.AppPlanRepository;
import com.pravin.repository.CitizenChildRepository;
import com.pravin.repository.CitizenIncomeDtlsRepository;
import com.pravin.repository.CitizenPlanRepository;
import com.pravin.repository.GradutionDtlsRepository;
import com.pravin.repository.GradutionYearDtlsRepository;
import com.pravin.service.DataCollectionService;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	private AppPlanRepository appPlanRepository;
	
	@Autowired
	private GradutionDtlsRepository gradutionDtlsRepository;
	
	@Autowired
	private CitizenIncomeDtlsRepository citizenIncomeDtlsRepository;
	
	@Autowired
	private GradutionYearDtlsRepository gradutionYearDtlsRepository;

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Autowired
	private CitizenChildRepository citizenChildRepository;

	@Override
	public List<AppPlan> getPlanName() {
		return appPlanRepository.findAll();
	}

	@Override
	public String savePlan(PlanSelection planSelection) {

		CitizenPlan citizenPlan = new CitizenPlan();
		BeanUtils.copyProperties(planSelection, citizenPlan);
		citizenPlanRepository.save(citizenPlan);

		return "citizen plan saved successfully";
	}

	@Override
	public List<GraduationYearDtls> getGradutionyears() {

		return gradutionYearDtlsRepository.findAll();
	}

	@Override
	public String saveEducation(Education education) {
		GradutionDtls gradutionDtls = new GradutionDtls();
		BeanUtils.copyProperties(gradutionDtls, education);
		gradutionDtlsRepository.save(gradutionDtls);

		return "gradution details saved successfully";

	}

	@Override
	public String saveKids(Childs childs) {

		List<Child> child = childs.getChilds();
		child.forEach(chils -> {
			CitizenChild CitizenChild = new CitizenChild();
			BeanUtils.copyProperties(CitizenChild, childs);
			CitizenChild.setCaseNo(childs.getCaseNo());
			citizenChildRepository.save(CitizenChild);
		});

		return "child details saved successfully";

	}

	@Override
	public Summery getSummery(Long caseNo) {

		Optional<CitizenPlan> appPlan = citizenPlanRepository.findByCaseNo(caseNo);
		Optional<GradutionDtls> gradutionDtls = gradutionDtlsRepository.findByCaseNo(caseNo);
		Optional<List<CitizenChild>> citizenChild = citizenChildRepository.findByCaseNo(caseNo);
		Optional<CityzenIncomeDtls> cityzenIncomeDtls = citizenIncomeDtlsRepository.findByCaseNo(caseNo);
		Summery summery = new Summery();

		PlanSelection planSelection = new PlanSelection();
		Childs childs = new Childs();
		Education education = new Education();
		Income income = new Income();

		if (appPlan.isPresent()) {
			BeanUtils.copyProperties(appPlan, planSelection);
		}
		if (gradutionDtls.isPresent()) {
			BeanUtils.copyProperties(gradutionDtls, education);
		}
		if (citizenChild.isPresent()) {
			BeanUtils.copyProperties(citizenChild, childs);
		}
		if (cityzenIncomeDtls.isPresent()) {
			BeanUtils.copyProperties(cityzenIncomeDtls, income);
		}
		summery.setChilds(childs);
		summery.setEducation(education);
		summery.setIncome(income);
		summery.setPlanSelection(planSelection);
		return summery;
	}

	@Override
	public String saveincome(Income income) {
		CityzenIncomeDtls incomeDtls = new CityzenIncomeDtls();
		BeanUtils.copyProperties(income, incomeDtls);
		citizenIncomeDtlsRepository.save(incomeDtls);

		return "incomeDtls details saved successfully";
	}

}
