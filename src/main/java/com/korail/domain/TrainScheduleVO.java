package com.korail.domain;

public class TrainScheduleVO {
	private String adultcharge;
	private String arrplacename;
	private String arrplandtime;
	private String depplacename;
	private String depplandtime;
	private String traingradename;

	@Override
	public String toString() {
		return "TrainScheduleVO [adultcharge=" + adultcharge + ", arrplacename=" + arrplacename + ", arrplandtime="
				+ arrplandtime + ", depplacename=" + depplacename + ", depplandtime=" + depplandtime
				+ ", traingradename=" + traingradename + "]";
	}

	public TrainScheduleVO(String adultcharge, String arrplacename, String arrplandtime, String depplacename,
			String depplandtime, String traingradename) {
		super();
		this.adultcharge = adultcharge;
		this.arrplacename = arrplacename;
		this.arrplandtime = arrplandtime;
		this.depplacename = depplacename;
		this.depplandtime = depplandtime;
		this.traingradename = traingradename;
	}

	public TrainScheduleVO() {
		super();
	}

	public String getAdultcharge() {
		return adultcharge;
	}

	public void setAdultcharge(String adultcharge) {
		this.adultcharge = adultcharge;
	}

	public String getArrplacename() {
		return arrplacename;
	}

	public void setArrplacename(String arrplacename) {
		this.arrplacename = arrplacename;
	}

	public String getArrplandtime() {
		return arrplandtime;
	}

	public void setArrplandtime(String arrplandtime) {
		this.arrplandtime = arrplandtime;
	}

	public String getDepplacename() {
		return depplacename;
	}

	public void setDepplacename(String depplacename) {
		this.depplacename = depplacename;
	}

	public String getDepplandtime() {
		return depplandtime;
	}

	public void setDepplandtime(String depplandtime) {
		this.depplandtime = depplandtime;
	}

	public String getTraingradename() {
		return traingradename;
	}

	public void setTraingradename(String traingradename) {
		this.traingradename = traingradename;
	}
}
