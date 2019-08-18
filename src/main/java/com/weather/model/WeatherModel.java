package com.weather.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;


public class WeatherModel {
	@NotEmpty(message="City Name canot be null")
	private String name;

	private List<DailySummary> dailySummarys;

	public List<DailySummary> getDailySummarys() {
		return dailySummarys;
	}

	public void setDailySummarys(List<DailySummary> dailySummarys) {
		this.dailySummarys = dailySummarys;
	}

	public WeatherModel() {
	}

	public WeatherModel(String name, List<DailySummary> dailySummary) {
		super();
		this.name = name;
		this.setDailySummarys(dailySummary);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
