package com.weather.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="location")
@PropertySource("classpath:application.properties")
public class Configuration {

	private String camp;
	
	private String oma;
	
	private String aus;
	
	private String nis;
	
	private String jak;

	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	public String getOma() {
		return oma;
	}

	public void setOma(String oma) {
		this.oma = oma;
	}

	public String getAus() {
		return aus;
	}

	public void setAus(String aus) {
		this.aus = aus;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getJak() {
		return jak;
	}

	public void setJak(String jak) {
		this.jak = jak;
	}
	
}
