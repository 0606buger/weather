package com.weather.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DailySummary {
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date date;
	private String summary;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
    public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
    	return sdf.format(date)+"-"+summary;
    }
}
