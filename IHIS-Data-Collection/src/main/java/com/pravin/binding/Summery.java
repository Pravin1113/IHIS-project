package com.pravin.binding;

public class Summery {
	
	private PlanSelection planSelection;
	
	private Childs childs;
	 
	private Education education;
	
	private Income income;

	public PlanSelection getPlanSelection() {
		return planSelection;
	}

	public void setPlanSelection(PlanSelection planSelection) {
		this.planSelection = planSelection;
	}

	public Childs getChilds() {
		return childs;
	}

	public void setChilds(Childs childs) {
		this.childs = childs;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Summery [planSelection=" + planSelection + ", childs=" + childs + ", education=" + education
				+ ", income=" + income + "]";
	}
	
	

}
