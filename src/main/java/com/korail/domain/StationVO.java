package com.korail.domain;

public class StationVO {
	private String station_Id;
	private String station_Type;
	private String station_Station;

	public StationVO() {
	}

	public StationVO(String station_Id, String station_Type, String station_Station) {
		super();
		this.station_Id = station_Id;
		this.station_Type = station_Type;
		this.station_Station = station_Station;
	}

	public String getStation_Id() {
		return station_Id;
	}

	public void setStation_Id(String station_Id) {
		this.station_Id = station_Id;
	}

	public String getStation_Type() {
		return station_Type;
	}

	public void setStation_Type(String station_Type) {
		this.station_Type = station_Type;
	}

	public String getStation_Station() {
		return station_Station;
	}

	public void setStation_Station(String station_Station) {
		this.station_Station = station_Station;
	}

	@Override
	public String toString() {
		return "StationVO [station_Id=" + station_Id + ", station_Type=" + station_Type + ", station_Station="
				+ station_Station + "]";
	}

}
