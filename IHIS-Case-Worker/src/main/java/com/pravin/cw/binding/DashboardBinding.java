package com.pravin.cw.binding;

public class DashboardBinding {
	
	private Long appsCount;
	
	private Long plansCount;
	
	private Integer approvedCount;
	
	private Integer declinedCount;

	public Long getAppsCount() {
		return appsCount;
	}

	public void setAppsCount(Long appsCount) {
		this.appsCount = appsCount;
	}

	public Long getPlansCount() {
		return plansCount;
	}

	public void setPlansCount(Long plansCount) {
		this.plansCount = plansCount;
	}

	public Integer getApprovedCount() {
		return approvedCount;
	}

	public void setApprovedCount(Integer approvedDetail) {
		this.approvedCount = approvedDetail;
	}

	public Integer getDeclinedCount() {
		return declinedCount;
	}

	public void setDeclinedCount(Integer denialDetail) {
		this.declinedCount = denialDetail;
	}

	@Override
	public String toString() {
		return "DashboardBinding [appsCount=" + appsCount + ", plansCount=" + plansCount + ", approvedCount="
				+ approvedCount + ", declinedCount=" + declinedCount + "]";
	}
	
	
	

}
