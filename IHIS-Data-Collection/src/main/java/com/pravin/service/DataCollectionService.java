package com.pravin.service;

import java.util.List;
import java.util.Map;

import com.pravin.binding.Childs;
import com.pravin.binding.Education;
import com.pravin.binding.Income;
import com.pravin.binding.PlanSelection;
import com.pravin.binding.Summery;
import com.pravin.entity.AppPlan;
import com.pravin.entity.GraduationYearDtls;

public interface DataCollectionService {

	
	public List<AppPlan> getPlanName();
	
	public String savePlan(PlanSelection planSelection);
	
	public List<GraduationYearDtls> getGradutionyears();
	
	public String saveEducation(Education education);
	
	public String saveKids(Childs childs);
	
	public String saveincome(Income income);
	
	public Summery getSummery(Long caseNo);
	
	
}
