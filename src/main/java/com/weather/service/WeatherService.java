package com.weather.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.dao.WeatherDAO;
import com.weather.entity.Weather;
import com.weather.model.WeatherModel;
import com.weather.util.Configuration;
import com.weather.util.WeatherUtil;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	@Autowired
	private Configuration conf;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
	
	public List<WeatherModel> getWeathers(){
		List<WeatherModel> list=new ArrayList<>();
		list.add(getWeather("Campbell",conf.getCamp()));
		list.add(getWeather("Omaha",conf.getOma()));
		list.add(getWeather("Austin",conf.getAus()));
		list.add(getWeather("Niseko",conf.getNis()));
		list.add(getWeather("Jakarta",conf.getJak()));
		return list;
	}
	
	public WeatherModel getWeather(String city,String loc) {
		try {
			WeatherModel model= new WeatherModel();
			model.setName(city);
			String today=sdf.format(new Date());
			Weather weather=weatherDAO.queryByDay(today,city);
			if(weather!=null) {
				return model;
			}
			System.out.println(loc);
			String weatherString=WeatherUtil.getWeather(loc);
			weather=new Weather();
			weather.setDay(today);
			weather.setDetail(weatherString);
			weatherDAO.save(weather);
			model.setDailySummarys(WeatherUtil.getSummary(weather.getDetail()));
			return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
