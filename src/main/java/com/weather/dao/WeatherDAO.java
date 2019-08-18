package com.weather.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

 
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.weather.entity.Weather;
 
@Repository
public class WeatherDAO {
	
	private SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
	@Autowired
	MongoTemplate mongoTemplate;
 
	
	public void save(Weather weather) {
		mongoTemplate.save(weather);	
	}

	public Weather queryByDay(String day,String location){
		Query query = Query.query(Criteria.where("day").is(day).andOperator(Criteria.where("location").is(location)));
		List<Weather> articles = mongoTemplate.find(query, Weather.class);
		return articles.size()==1?articles.get(0):null;
	}
	
	public void houseKeeping() {
		Date today=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, -1); 
		Date oneDayBefore = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, -1); 
		Date twoDayBefore = calendar.getTime();
		String todayString= sdf.format(today);
		String oneDayBeforeString = sdf.format(oneDayBefore);
		String twoDayBeforeString = sdf.format(twoDayBefore);
		Query query = Query.query(Criteria.where("author").nin(todayString,oneDayBeforeString,twoDayBeforeString));
		mongoTemplate.remove(query, Weather.class);
	}
}