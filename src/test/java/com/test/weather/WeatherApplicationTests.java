package com.test.weather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.util.JSON;
import com.weather.entity.Weather;
import com.weather.model.DailySummary;
import com.weather.util.WeatherUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

	private SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
	
	@Autowired
	MongoTemplate mongoTemplate;
 
//	@Test
//	public void saveTest() {
//		Weather Weather = new Weather();
//		//Weather.setDate(new Date());
//		try {
//			Weather.setDay(sdf.format(new Date()));
//			Weather.setLocation("Campbell");
//			Weather.setDetail(WeatherUtil.getWeather(""));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(mongoTemplate);
//		
//		mongoTemplate.save(Weather);	
//	}
// 
//	@Test
//	public void insertTest() {
//		Weather Weather = new Weather();
//		//Weather.setDate(new Date());
//		Weather.setDetail("sing");
//		System.out.println(mongoTemplate);
// 
//		mongoTemplate.insert(Weather);	
//	}
//	
//	@Test
//	public void insertAllTest() {
//		ArrayList<Weather> manyWeather = new ArrayList<>();
//		Weather Weather1 = new Weather();
//		//Weather1.setDate(new Date());
//		Weather1.setDetail("sing");
//		manyWeather.add(Weather1);
//		Weather Weather2 = new Weather();
//		//Weather2.setDate(new Date());
//		Weather2.setDetail("sing");
//		//Weather2.setWeather("rainm");
//		manyWeather.add(Weather2);
//		mongoTemplate.insertAll(manyWeather);
//	}
//	
//	@Test
//	public void update() {
//		Query query = new Query();
//		
//		query.addCriteria(Criteria.where("classId").is("1"));
//		Update update = new Update();
//		update = Update.update("teacher","WANGZE");
//		mongoTemplate.upsert(query, update, "fuzui");
//	}
//
//	@Test
//	public void addNestTest() {
//		Query query = Query.query(Criteria.where("classId").is("1"));
//		Weather Weather = new Weather();
//		Update update = new Update();
//		
//		update.push("Students",Weather);
//		//update.addToSet("Students", Weather);
//		mongoTemplate.upsert(query, update, "fuzui");
//	}
//
//	@Test
//	public void updateNestTest() {
//		Query query = Query.query(Criteria.where("classId").is("1").and("Students.name").is("wwze05"));
//		Update update = Update.update("Students.$.password", "456");
//		
//		//Weather Weather = new Weather("1","wwze05","wwze05","123");
//		//update.pull("students", Weather);
//		
//		mongoTemplate.upsert(query, update, "fuzui");
//	}
//
//	@Test
//	public void deleteNestTest() {
//		Query query = Query.query(Criteria.where("classId").is("1").and("Students.name").is("wwze05"));
//		Update update = new Update();
//		update.unset("Students.$");
//		mongoTemplate.upsert(query, update, "fuzui");
//	}
//
//	@Test
//	public void deleteTest() {
//		Query query = Query.query(Criteria.where("classId").is("1"));
//		mongoTemplate.remove(query,"fuzui");
//	}
// 
//	@Test
//	public void queryAll(){
//		//List<Weather> WeatherList = mongoTemplate.find(new Query(),Weather.class);
//		List<Weather> w2=mongoTemplate.find(new Query(),Weather.class);
//		
//		for(Weather w:w2) {
//			System.out.println(w.getDay());
//			System.out.println(w.getDetail());
//		}
//		//System.out.println(mongoTemplate.find(new Query(),Weather.class).get(0).getLocation());
//	}
//	@Test
//    public void doGet() throws Exception{
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet("https://api.darksky.net/forecast/4bd5cae3c1be6aeb85e4396a0f718371/37.2805374,-121.990486");
//        CloseableHttpResponse response = httpClient.execute(get);
//        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
//        HttpEntity entity = response.getEntity();
//        String s = EntityUtils.toString(entity);
//        System.out.println(s);
//        response.close();
//        httpClient.close();
//
//    }
	@Test
	public void testTool() {
		String s="{\n" + 
				"    \"latitude\": 37.2805374,\n" + 
				"    \"longitude\": -121.990486,\n" + 
				"    \"timezone\": \"America/Los_Angeles\",\n" + 
				"    \"currently\": {\n" + 
				"        \"time\": 1566135321,\n" + 
				"        \"summary\": \"Clear\",\n" + 
				"        \"icon\": \"clear-day\",\n" + 
				"        \"nearestStormDistance\": 12,\n" + 
				"        \"nearestStormBearing\": 42,\n" + 
				"        \"precipIntensity\": 0,\n" + 
				"        \"precipProbability\": 0,\n" + 
				"        \"temperature\": 56.73,\n" + 
				"        \"apparentTemperature\": 56.73,\n" + 
				"        \"dewPoint\": 53.1,\n" + 
				"        \"humidity\": 0.88,\n" + 
				"        \"pressure\": 1011.13,\n" + 
				"        \"windSpeed\": 5.43,\n" + 
				"        \"windGust\": 13.93,\n" + 
				"        \"windBearing\": 172,\n" + 
				"        \"cloudCover\": 0.11,\n" + 
				"        \"uvIndex\": 0,\n" + 
				"        \"visibility\": 9.393,\n" + 
				"        \"ozone\": 295.7\n" + 
				"    },\n" + 
				"    \"minutely\": {\n" + 
				"        \"summary\": \"Clear for the hour.\",\n" + 
				"        \"icon\": \"clear-day\",\n" + 
				"        \"data\": [\n" + 
				"            {\n" + 
				"                \"time\": 1566135300,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135360,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135420,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135480,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135540,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135600,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135660,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135720,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135780,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135840,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135900,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566135960,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136020,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136080,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136140,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136200,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136260,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136320,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136380,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136440,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136500,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136560,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136620,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136680,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136740,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136800,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136860,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136920,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136980,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137040,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137100,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137160,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137220,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137280,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137340,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137400,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137460,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137520,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137580,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137640,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137700,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137760,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137820,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137880,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566137940,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138000,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138060,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138120,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138180,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138240,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138300,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138360,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138420,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138480,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138540,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138600,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138660,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138720,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138780,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138840,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566138900,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0\n" + 
				"            }\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    \"hourly\": {\n" + 
				"        \"summary\": \"Partly cloudy throughout the day.\",\n" + 
				"        \"icon\": \"partly-cloudy-day\",\n" + 
				"        \"data\": [\n" + 
				"            {\n" + 
				"                \"time\": 1566133200,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 56.29,\n" + 
				"                \"apparentTemperature\": 56.29,\n" + 
				"                \"dewPoint\": 52.35,\n" + 
				"                \"humidity\": 0.87,\n" + 
				"                \"pressure\": 1010.75,\n" + 
				"                \"windSpeed\": 5.29,\n" + 
				"                \"windGust\": 13.42,\n" + 
				"                \"windBearing\": 172,\n" + 
				"                \"cloudCover\": 0.04,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 8.888,\n" + 
				"                \"ozone\": 296.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566136800,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 57.04,\n" + 
				"                \"apparentTemperature\": 57.04,\n" + 
				"                \"dewPoint\": 53.61,\n" + 
				"                \"humidity\": 0.88,\n" + 
				"                \"pressure\": 1011.39,\n" + 
				"                \"windSpeed\": 5.52,\n" + 
				"                \"windGust\": 14.28,\n" + 
				"                \"windBearing\": 173,\n" + 
				"                \"cloudCover\": 0.16,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 9.744,\n" + 
				"                \"ozone\": 295.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566140400,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 59.62,\n" + 
				"                \"apparentTemperature\": 59.62,\n" + 
				"                \"dewPoint\": 56.42,\n" + 
				"                \"humidity\": 0.89,\n" + 
				"                \"pressure\": 1012.06,\n" + 
				"                \"windSpeed\": 6.62,\n" + 
				"                \"windGust\": 16.5,\n" + 
				"                \"windBearing\": 178,\n" + 
				"                \"cloudCover\": 0.52,\n" + 
				"                \"uvIndex\": 1,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294.7\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566144000,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 61.99,\n" + 
				"                \"apparentTemperature\": 61.99,\n" + 
				"                \"dewPoint\": 57.99,\n" + 
				"                \"humidity\": 0.87,\n" + 
				"                \"pressure\": 1012.34,\n" + 
				"                \"windSpeed\": 7.25,\n" + 
				"                \"windGust\": 16.94,\n" + 
				"                \"windBearing\": 180,\n" + 
				"                \"cloudCover\": 0.64,\n" + 
				"                \"uvIndex\": 2,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294.5\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566147600,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 64.62,\n" + 
				"                \"apparentTemperature\": 64.62,\n" + 
				"                \"dewPoint\": 58.44,\n" + 
				"                \"humidity\": 0.8,\n" + 
				"                \"pressure\": 1012.7,\n" + 
				"                \"windSpeed\": 7.45,\n" + 
				"                \"windGust\": 15.83,\n" + 
				"                \"windBearing\": 182,\n" + 
				"                \"cloudCover\": 0.61,\n" + 
				"                \"uvIndex\": 3,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566151200,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 67.26,\n" + 
				"                \"apparentTemperature\": 67.26,\n" + 
				"                \"dewPoint\": 58.64,\n" + 
				"                \"humidity\": 0.74,\n" + 
				"                \"pressure\": 1012.81,\n" + 
				"                \"windSpeed\": 7.68,\n" + 
				"                \"windGust\": 15.31,\n" + 
				"                \"windBearing\": 184,\n" + 
				"                \"cloudCover\": 0.55,\n" + 
				"                \"uvIndex\": 5,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566154800,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 69.33,\n" + 
				"                \"apparentTemperature\": 69.33,\n" + 
				"                \"dewPoint\": 58.84,\n" + 
				"                \"humidity\": 0.69,\n" + 
				"                \"pressure\": 1012.37,\n" + 
				"                \"windSpeed\": 8.44,\n" + 
				"                \"windGust\": 14.86,\n" + 
				"                \"windBearing\": 189,\n" + 
				"                \"cloudCover\": 0.47,\n" + 
				"                \"uvIndex\": 7,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 293.5\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566158400,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 72.44,\n" + 
				"                \"apparentTemperature\": 72.44,\n" + 
				"                \"dewPoint\": 58.47,\n" + 
				"                \"humidity\": 0.62,\n" + 
				"                \"pressure\": 1012.32,\n" + 
				"                \"windSpeed\": 8.55,\n" + 
				"                \"windGust\": 13.96,\n" + 
				"                \"windBearing\": 195,\n" + 
				"                \"cloudCover\": 0.33,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 292.9\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566162000,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 74.73,\n" + 
				"                \"apparentTemperature\": 74.73,\n" + 
				"                \"dewPoint\": 57.68,\n" + 
				"                \"humidity\": 0.55,\n" + 
				"                \"pressure\": 1011.72,\n" + 
				"                \"windSpeed\": 8.58,\n" + 
				"                \"windGust\": 13.21,\n" + 
				"                \"windBearing\": 201,\n" + 
				"                \"cloudCover\": 0.2,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 292.7\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566165600,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 76.13,\n" + 
				"                \"apparentTemperature\": 76.13,\n" + 
				"                \"dewPoint\": 57.22,\n" + 
				"                \"humidity\": 0.52,\n" + 
				"                \"pressure\": 1011.61,\n" + 
				"                \"windSpeed\": 8.71,\n" + 
				"                \"windGust\": 13.22,\n" + 
				"                \"windBearing\": 205,\n" + 
				"                \"cloudCover\": 0.14,\n" + 
				"                \"uvIndex\": 7,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 292.9\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566169200,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 76.83,\n" + 
				"                \"apparentTemperature\": 76.83,\n" + 
				"                \"dewPoint\": 57.08,\n" + 
				"                \"humidity\": 0.51,\n" + 
				"                \"pressure\": 1011.55,\n" + 
				"                \"windSpeed\": 8.83,\n" + 
				"                \"windGust\": 13.31,\n" + 
				"                \"windBearing\": 219,\n" + 
				"                \"cloudCover\": 0.08,\n" + 
				"                \"uvIndex\": 5,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 293.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566172800,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 76.76,\n" + 
				"                \"apparentTemperature\": 76.76,\n" + 
				"                \"dewPoint\": 56.98,\n" + 
				"                \"humidity\": 0.5,\n" + 
				"                \"pressure\": 1011.46,\n" + 
				"                \"windSpeed\": 8.64,\n" + 
				"                \"windGust\": 13,\n" + 
				"                \"windBearing\": 223,\n" + 
				"                \"cloudCover\": 0.04,\n" + 
				"                \"uvIndex\": 3,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566176400,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0.0007,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 74.87,\n" + 
				"                \"apparentTemperature\": 74.87,\n" + 
				"                \"dewPoint\": 56.68,\n" + 
				"                \"humidity\": 0.53,\n" + 
				"                \"pressure\": 1011.56,\n" + 
				"                \"windSpeed\": 8,\n" + 
				"                \"windGust\": 12.26,\n" + 
				"                \"windBearing\": 229,\n" + 
				"                \"cloudCover\": 0.03,\n" + 
				"                \"uvIndex\": 1,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 294.5\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566180000,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 71.84,\n" + 
				"                \"apparentTemperature\": 71.84,\n" + 
				"                \"dewPoint\": 56.24,\n" + 
				"                \"humidity\": 0.58,\n" + 
				"                \"pressure\": 1011.15,\n" + 
				"                \"windSpeed\": 6.64,\n" + 
				"                \"windGust\": 10.38,\n" + 
				"                \"windBearing\": 234,\n" + 
				"                \"cloudCover\": 0.03,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 295\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566183600,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 66.59,\n" + 
				"                \"apparentTemperature\": 66.59,\n" + 
				"                \"dewPoint\": 55.24,\n" + 
				"                \"humidity\": 0.67,\n" + 
				"                \"pressure\": 1011.58,\n" + 
				"                \"windSpeed\": 5.19,\n" + 
				"                \"windGust\": 6.25,\n" + 
				"                \"windBearing\": 244,\n" + 
				"                \"cloudCover\": 0.04,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 295.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566187200,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 64.52,\n" + 
				"                \"apparentTemperature\": 64.52,\n" + 
				"                \"dewPoint\": 54.61,\n" + 
				"                \"humidity\": 0.7,\n" + 
				"                \"pressure\": 1012.22,\n" + 
				"                \"windSpeed\": 4.6,\n" + 
				"                \"windGust\": 6.04,\n" + 
				"                \"windBearing\": 241,\n" + 
				"                \"cloudCover\": 0.14,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 296.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566190800,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 62.65,\n" + 
				"                \"apparentTemperature\": 62.65,\n" + 
				"                \"dewPoint\": 54.08,\n" + 
				"                \"humidity\": 0.74,\n" + 
				"                \"pressure\": 1013.05,\n" + 
				"                \"windSpeed\": 4.01,\n" + 
				"                \"windGust\": 5.85,\n" + 
				"                \"windBearing\": 227,\n" + 
				"                \"cloudCover\": 0.27,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 9.828,\n" + 
				"                \"ozone\": 297.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566194400,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 61.11,\n" + 
				"                \"apparentTemperature\": 61.11,\n" + 
				"                \"dewPoint\": 54.03,\n" + 
				"                \"humidity\": 0.78,\n" + 
				"                \"pressure\": 1013.73,\n" + 
				"                \"windSpeed\": 3.54,\n" + 
				"                \"windGust\": 5.65,\n" + 
				"                \"windBearing\": 224,\n" + 
				"                \"cloudCover\": 0.39,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 7.896,\n" + 
				"                \"ozone\": 298.1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566198000,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 60.26,\n" + 
				"                \"apparentTemperature\": 60.26,\n" + 
				"                \"dewPoint\": 53.85,\n" + 
				"                \"humidity\": 0.79,\n" + 
				"                \"pressure\": 1013.99,\n" + 
				"                \"windSpeed\": 3.41,\n" + 
				"                \"windGust\": 5.39,\n" + 
				"                \"windBearing\": 221,\n" + 
				"                \"cloudCover\": 0.47,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 8.058,\n" + 
				"                \"ozone\": 298.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566201600,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 59.83,\n" + 
				"                \"apparentTemperature\": 59.83,\n" + 
				"                \"dewPoint\": 54.04,\n" + 
				"                \"humidity\": 0.81,\n" + 
				"                \"pressure\": 1014.25,\n" + 
				"                \"windSpeed\": 3.42,\n" + 
				"                \"windGust\": 5.12,\n" + 
				"                \"windBearing\": 213,\n" + 
				"                \"cloudCover\": 0.54,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 9.254,\n" + 
				"                \"ozone\": 298.1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566205200,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0007,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 59.55,\n" + 
				"                \"apparentTemperature\": 59.55,\n" + 
				"                \"dewPoint\": 54.26,\n" + 
				"                \"humidity\": 0.83,\n" + 
				"                \"pressure\": 1014.09,\n" + 
				"                \"windSpeed\": 3.42,\n" + 
				"                \"windGust\": 4.93,\n" + 
				"                \"windBearing\": 213,\n" + 
				"                \"cloudCover\": 0.6,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566208800,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0007,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 59.17,\n" + 
				"                \"apparentTemperature\": 59.17,\n" + 
				"                \"dewPoint\": 54.36,\n" + 
				"                \"humidity\": 0.84,\n" + 
				"                \"pressure\": 1014.1,\n" + 
				"                \"windSpeed\": 3.29,\n" + 
				"                \"windGust\": 4.89,\n" + 
				"                \"windBearing\": 210,\n" + 
				"                \"cloudCover\": 0.64,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298.8\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566212400,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0006,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 58.74,\n" + 
				"                \"apparentTemperature\": 58.74,\n" + 
				"                \"dewPoint\": 54.87,\n" + 
				"                \"humidity\": 0.87,\n" + 
				"                \"pressure\": 1014.13,\n" + 
				"                \"windSpeed\": 3.11,\n" + 
				"                \"windGust\": 4.93,\n" + 
				"                \"windBearing\": 207,\n" + 
				"                \"cloudCover\": 0.69,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 299.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566216000,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0005,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 58.21,\n" + 
				"                \"apparentTemperature\": 58.21,\n" + 
				"                \"dewPoint\": 54.91,\n" + 
				"                \"humidity\": 0.89,\n" + 
				"                \"pressure\": 1014.27,\n" + 
				"                \"windSpeed\": 3,\n" + 
				"                \"windGust\": 4.9,\n" + 
				"                \"windBearing\": 205,\n" + 
				"                \"cloudCover\": 0.71,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566219600,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0005,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 57.14,\n" + 
				"                \"apparentTemperature\": 57.14,\n" + 
				"                \"dewPoint\": 55.06,\n" + 
				"                \"humidity\": 0.93,\n" + 
				"                \"pressure\": 1014.62,\n" + 
				"                \"windSpeed\": 2.99,\n" + 
				"                \"windGust\": 4.61,\n" + 
				"                \"windBearing\": 201,\n" + 
				"                \"cloudCover\": 0.73,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566223200,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0.0005,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 57.12,\n" + 
				"                \"apparentTemperature\": 57.12,\n" + 
				"                \"dewPoint\": 55.59,\n" + 
				"                \"humidity\": 0.95,\n" + 
				"                \"pressure\": 1015.12,\n" + 
				"                \"windSpeed\": 3.03,\n" + 
				"                \"windGust\": 4.24,\n" + 
				"                \"windBearing\": 199,\n" + 
				"                \"cloudCover\": 0.74,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 301.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566226800,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0.0004,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 57.92,\n" + 
				"                \"apparentTemperature\": 57.92,\n" + 
				"                \"dewPoint\": 56.36,\n" + 
				"                \"humidity\": 0.95,\n" + 
				"                \"pressure\": 1015.54,\n" + 
				"                \"windSpeed\": 3.07,\n" + 
				"                \"windGust\": 4.02,\n" + 
				"                \"windBearing\": 197,\n" + 
				"                \"cloudCover\": 0.73,\n" + 
				"                \"uvIndex\": 1,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 301.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566230400,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0.0002,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 59.86,\n" + 
				"                \"apparentTemperature\": 59.86,\n" + 
				"                \"dewPoint\": 56.98,\n" + 
				"                \"humidity\": 0.9,\n" + 
				"                \"pressure\": 1015.54,\n" + 
				"                \"windSpeed\": 3.01,\n" + 
				"                \"windGust\": 4.06,\n" + 
				"                \"windBearing\": 199,\n" + 
				"                \"cloudCover\": 0.69,\n" + 
				"                \"uvIndex\": 2,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.5\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566234000,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 62.98,\n" + 
				"                \"apparentTemperature\": 62.98,\n" + 
				"                \"dewPoint\": 57.73,\n" + 
				"                \"humidity\": 0.83,\n" + 
				"                \"pressure\": 1015.42,\n" + 
				"                \"windSpeed\": 2.95,\n" + 
				"                \"windGust\": 4.25,\n" + 
				"                \"windBearing\": 216,\n" + 
				"                \"cloudCover\": 0.63,\n" + 
				"                \"uvIndex\": 3,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 299.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566237600,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 66.56,\n" + 
				"                \"apparentTemperature\": 66.56,\n" + 
				"                \"dewPoint\": 58.56,\n" + 
				"                \"humidity\": 0.75,\n" + 
				"                \"pressure\": 1015.45,\n" + 
				"                \"windSpeed\": 3.15,\n" + 
				"                \"windGust\": 4.48,\n" + 
				"                \"windBearing\": 234,\n" + 
				"                \"cloudCover\": 0.57,\n" + 
				"                \"uvIndex\": 5,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298.7\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566241200,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 70.52,\n" + 
				"                \"apparentTemperature\": 70.52,\n" + 
				"                \"dewPoint\": 59.26,\n" + 
				"                \"humidity\": 0.68,\n" + 
				"                \"pressure\": 1015.41,\n" + 
				"                \"windSpeed\": 3.74,\n" + 
				"                \"windGust\": 4.75,\n" + 
				"                \"windBearing\": 208,\n" + 
				"                \"cloudCover\": 0.44,\n" + 
				"                \"uvIndex\": 7,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 299.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566244800,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 74.71,\n" + 
				"                \"apparentTemperature\": 74.71,\n" + 
				"                \"dewPoint\": 59.1,\n" + 
				"                \"humidity\": 0.58,\n" + 
				"                \"pressure\": 1015.07,\n" + 
				"                \"windSpeed\": 4.54,\n" + 
				"                \"windGust\": 5.08,\n" + 
				"                \"windBearing\": 312,\n" + 
				"                \"cloudCover\": 0.28,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566248400,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 77.53,\n" + 
				"                \"apparentTemperature\": 77.53,\n" + 
				"                \"dewPoint\": 58.88,\n" + 
				"                \"humidity\": 0.53,\n" + 
				"                \"pressure\": 1014.7,\n" + 
				"                \"windSpeed\": 5.27,\n" + 
				"                \"windGust\": 5.43,\n" + 
				"                \"windBearing\": 270,\n" + 
				"                \"cloudCover\": 0.15,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.7\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566252000,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 78.86,\n" + 
				"                \"apparentTemperature\": 78.86,\n" + 
				"                \"dewPoint\": 58.22,\n" + 
				"                \"humidity\": 0.49,\n" + 
				"                \"pressure\": 1014.39,\n" + 
				"                \"windSpeed\": 5.91,\n" + 
				"                \"windGust\": 5.91,\n" + 
				"                \"windBearing\": 261,\n" + 
				"                \"cloudCover\": 0.09,\n" + 
				"                \"uvIndex\": 7,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566255600,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 79.12,\n" + 
				"                \"apparentTemperature\": 79.12,\n" + 
				"                \"dewPoint\": 57.82,\n" + 
				"                \"humidity\": 0.48,\n" + 
				"                \"pressure\": 1014.03,\n" + 
				"                \"windSpeed\": 6.46,\n" + 
				"                \"windGust\": 6.46,\n" + 
				"                \"windBearing\": 297,\n" + 
				"                \"cloudCover\": 0.04,\n" + 
				"                \"uvIndex\": 5,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 299.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566259200,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 78.49,\n" + 
				"                \"apparentTemperature\": 78.49,\n" + 
				"                \"dewPoint\": 57.47,\n" + 
				"                \"humidity\": 0.49,\n" + 
				"                \"pressure\": 1013.84,\n" + 
				"                \"windSpeed\": 6.69,\n" + 
				"                \"windGust\": 6.69,\n" + 
				"                \"windBearing\": 287,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 3,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298.9\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566262800,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 75.63,\n" + 
				"                \"apparentTemperature\": 75.63,\n" + 
				"                \"dewPoint\": 57.01,\n" + 
				"                \"humidity\": 0.52,\n" + 
				"                \"pressure\": 1013.9,\n" + 
				"                \"windSpeed\": 6.4,\n" + 
				"                \"windGust\": 6.46,\n" + 
				"                \"windBearing\": 272,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 1,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298.1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566266400,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 71.39,\n" + 
				"                \"apparentTemperature\": 71.39,\n" + 
				"                \"dewPoint\": 56.3,\n" + 
				"                \"humidity\": 0.59,\n" + 
				"                \"pressure\": 1014.03,\n" + 
				"                \"windSpeed\": 5.77,\n" + 
				"                \"windGust\": 5.94,\n" + 
				"                \"windBearing\": 311,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 297.2\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566270000,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 67.49,\n" + 
				"                \"apparentTemperature\": 67.49,\n" + 
				"                \"dewPoint\": 55.36,\n" + 
				"                \"humidity\": 0.65,\n" + 
				"                \"pressure\": 1014.36,\n" + 
				"                \"windSpeed\": 5.12,\n" + 
				"                \"windGust\": 5.37,\n" + 
				"                \"windBearing\": 294,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 296.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566273600,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 65.09,\n" + 
				"                \"apparentTemperature\": 65.09,\n" + 
				"                \"dewPoint\": 54.53,\n" + 
				"                \"humidity\": 0.69,\n" + 
				"                \"pressure\": 1014.81,\n" + 
				"                \"windSpeed\": 4.48,\n" + 
				"                \"windGust\": 4.76,\n" + 
				"                \"windBearing\": 296,\n" + 
				"                \"cloudCover\": 0.05,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 296.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566277200,\n" + 
				"                \"summary\": \"Clear\",\n" + 
				"                \"icon\": \"clear-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 63.12,\n" + 
				"                \"apparentTemperature\": 63.12,\n" + 
				"                \"dewPoint\": 54.21,\n" + 
				"                \"humidity\": 0.73,\n" + 
				"                \"pressure\": 1015.44,\n" + 
				"                \"windSpeed\": 3.81,\n" + 
				"                \"windGust\": 4.18,\n" + 
				"                \"windBearing\": 288,\n" + 
				"                \"cloudCover\": 0.12,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 296.4\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566280800,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 61.37,\n" + 
				"                \"apparentTemperature\": 61.37,\n" + 
				"                \"dewPoint\": 53.98,\n" + 
				"                \"humidity\": 0.77,\n" + 
				"                \"pressure\": 1015.99,\n" + 
				"                \"windSpeed\": 3.35,\n" + 
				"                \"windGust\": 3.94,\n" + 
				"                \"windBearing\": 289,\n" + 
				"                \"cloudCover\": 0.19,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 296.9\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566284400,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 59.94,\n" + 
				"                \"apparentTemperature\": 59.94,\n" + 
				"                \"dewPoint\": 53.53,\n" + 
				"                \"humidity\": 0.79,\n" + 
				"                \"pressure\": 1016.36,\n" + 
				"                \"windSpeed\": 3.25,\n" + 
				"                \"windGust\": 4.28,\n" + 
				"                \"windBearing\": 291,\n" + 
				"                \"cloudCover\": 0.23,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 298\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566288000,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 58.93,\n" + 
				"                \"apparentTemperature\": 58.93,\n" + 
				"                \"dewPoint\": 53.37,\n" + 
				"                \"humidity\": 0.82,\n" + 
				"                \"pressure\": 1016.5,\n" + 
				"                \"windSpeed\": 3.35,\n" + 
				"                \"windGust\": 4.9,\n" + 
				"                \"windBearing\": 277,\n" + 
				"                \"cloudCover\": 0.27,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 299.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566291600,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperature\": 57.94,\n" + 
				"                \"apparentTemperature\": 57.94,\n" + 
				"                \"dewPoint\": 53.38,\n" + 
				"                \"humidity\": 0.85,\n" + 
				"                \"pressure\": 1016.4,\n" + 
				"                \"windSpeed\": 3.38,\n" + 
				"                \"windGust\": 5.45,\n" + 
				"                \"windBearing\": 278,\n" + 
				"                \"cloudCover\": 0.32,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 300.6\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566295200,\n" + 
				"                \"summary\": \"Partly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0011,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 57.21,\n" + 
				"                \"apparentTemperature\": 57.21,\n" + 
				"                \"dewPoint\": 53.56,\n" + 
				"                \"humidity\": 0.88,\n" + 
				"                \"pressure\": 1016.29,\n" + 
				"                \"windSpeed\": 3.26,\n" + 
				"                \"windGust\": 5.67,\n" + 
				"                \"windBearing\": 280,\n" + 
				"                \"cloudCover\": 0.43,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 9.677,\n" + 
				"                \"ozone\": 300.3\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566298800,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0012,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 56.68,\n" + 
				"                \"apparentTemperature\": 56.68,\n" + 
				"                \"dewPoint\": 54.25,\n" + 
				"                \"humidity\": 0.92,\n" + 
				"                \"pressure\": 1016.29,\n" + 
				"                \"windSpeed\": 3.08,\n" + 
				"                \"windGust\": 5.8,\n" + 
				"                \"windBearing\": 284,\n" + 
				"                \"cloudCover\": 0.54,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 8.496,\n" + 
				"                \"ozone\": 299.5\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566302400,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.0012,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 56.26,\n" + 
				"                \"apparentTemperature\": 56.26,\n" + 
				"                \"dewPoint\": 54.44,\n" + 
				"                \"humidity\": 0.94,\n" + 
				"                \"pressure\": 1016.39,\n" + 
				"                \"windSpeed\": 2.99,\n" + 
				"                \"windGust\": 6.09,\n" + 
				"                \"windBearing\": 285,\n" + 
				"                \"cloudCover\": 0.63,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 7.82,\n" + 
				"                \"ozone\": 299.1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566306000,\n" + 
				"                \"summary\": \"Mostly Cloudy\",\n" + 
				"                \"icon\": \"partly-cloudy-night\",\n" + 
				"                \"precipIntensity\": 0.001,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperature\": 55.65,\n" + 
				"                \"apparentTemperature\": 55.65,\n" + 
				"                \"dewPoint\": 54.84,\n" + 
				"                \"humidity\": 0.97,\n" + 
				"                \"pressure\": 1016.69,\n" + 
				"                \"windSpeed\": 3,\n" + 
				"                \"windGust\": 6.77,\n" + 
				"                \"windBearing\": 286,\n" + 
				"                \"cloudCover\": 0.67,\n" + 
				"                \"uvIndex\": 0,\n" + 
				"                \"visibility\": 8.077,\n" + 
				"                \"ozone\": 299.6\n" + 
				"            }\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    \"daily\": {\n" + 
				"        \"summary\": \"No precipitation throughout the week, with high temperatures bottoming out at 77°F on Tuesday.\",\n" + 
				"        \"icon\": \"clear-day\",\n" + 
				"        \"data\": [\n" + 
				"            {\n" + 
				"                \"time\": 1566111600,\n" + 
				"                \"summary\": \"Partly cloudy throughout the day.\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"sunriseTime\": 1566134903,\n" + 
				"                \"sunsetTime\": 1566183487,\n" + 
				"                \"moonPhase\": 0.61,\n" + 
				"                \"precipIntensity\": 0.0002,\n" + 
				"                \"precipIntensityMax\": 0.0011,\n" + 
				"                \"precipIntensityMaxTime\": 1566133200,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperatureHigh\": 76.83,\n" + 
				"                \"temperatureHighTime\": 1566169200,\n" + 
				"                \"temperatureLow\": 57.12,\n" + 
				"                \"temperatureLowTime\": 1566223200,\n" + 
				"                \"apparentTemperatureHigh\": 76.83,\n" + 
				"                \"apparentTemperatureHighTime\": 1566169200,\n" + 
				"                \"apparentTemperatureLow\": 57.12,\n" + 
				"                \"apparentTemperatureLowTime\": 1566223200,\n" + 
				"                \"dewPoint\": 55.25,\n" + 
				"                \"humidity\": 0.72,\n" + 
				"                \"pressure\": 1011.66,\n" + 
				"                \"windSpeed\": 6.47,\n" + 
				"                \"windGust\": 16.94,\n" + 
				"                \"windGustTime\": 1566144000,\n" + 
				"                \"windBearing\": 198,\n" + 
				"                \"cloudCover\": 0.21,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"uvIndexTime\": 1566162000,\n" + 
				"                \"visibility\": 9.685,\n" + 
				"                \"ozone\": 294.9,\n" + 
				"                \"temperatureMin\": 56.29,\n" + 
				"                \"temperatureMinTime\": 1566133200,\n" + 
				"                \"temperatureMax\": 76.83,\n" + 
				"                \"temperatureMaxTime\": 1566169200,\n" + 
				"                \"apparentTemperatureMin\": 56.29,\n" + 
				"                \"apparentTemperatureMinTime\": 1566133200,\n" + 
				"                \"apparentTemperatureMax\": 76.83,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566169200\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566198000,\n" + 
				"                \"summary\": \"Mostly cloudy throughout the day.\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"sunriseTime\": 1566221354,\n" + 
				"                \"sunsetTime\": 1566269810,\n" + 
				"                \"moonPhase\": 0.64,\n" + 
				"                \"precipIntensity\": 0.0002,\n" + 
				"                \"precipIntensityMax\": 0.0007,\n" + 
				"                \"precipIntensityMaxTime\": 1566205200,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperatureHigh\": 79.12,\n" + 
				"                \"temperatureHighTime\": 1566255600,\n" + 
				"                \"temperatureLow\": 55.65,\n" + 
				"                \"temperatureLowTime\": 1566306000,\n" + 
				"                \"apparentTemperatureHigh\": 79.12,\n" + 
				"                \"apparentTemperatureHighTime\": 1566255600,\n" + 
				"                \"apparentTemperatureLow\": 55.65,\n" + 
				"                \"apparentTemperatureLowTime\": 1566306000,\n" + 
				"                \"dewPoint\": 56.09,\n" + 
				"                \"humidity\": 0.73,\n" + 
				"                \"pressure\": 1014.75,\n" + 
				"                \"windSpeed\": 4.11,\n" + 
				"                \"windGust\": 6.69,\n" + 
				"                \"windGustTime\": 1566259200,\n" + 
				"                \"windBearing\": 257,\n" + 
				"                \"cloudCover\": 0.37,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"uvIndexTime\": 1566248400,\n" + 
				"                \"visibility\": 9.892,\n" + 
				"                \"ozone\": 298.9,\n" + 
				"                \"temperatureMin\": 57.12,\n" + 
				"                \"temperatureMinTime\": 1566223200,\n" + 
				"                \"temperatureMax\": 79.12,\n" + 
				"                \"temperatureMaxTime\": 1566255600,\n" + 
				"                \"apparentTemperatureMin\": 57.12,\n" + 
				"                \"apparentTemperatureMinTime\": 1566223200,\n" + 
				"                \"apparentTemperatureMax\": 79.12,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566255600\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566284400,\n" + 
				"                \"summary\": \"Partly cloudy throughout the day.\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"sunriseTime\": 1566307805,\n" + 
				"                \"sunsetTime\": 1566356132,\n" + 
				"                \"moonPhase\": 0.67,\n" + 
				"                \"precipIntensity\": 0.0004,\n" + 
				"                \"precipIntensityMax\": 0.0012,\n" + 
				"                \"precipIntensityMaxTime\": 1566298800,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperatureHigh\": 76.79,\n" + 
				"                \"temperatureHighTime\": 1566342000,\n" + 
				"                \"temperatureLow\": 55.92,\n" + 
				"                \"temperatureLowTime\": 1566392400,\n" + 
				"                \"apparentTemperatureHigh\": 76.79,\n" + 
				"                \"apparentTemperatureHighTime\": 1566342000,\n" + 
				"                \"apparentTemperatureLow\": 55.92,\n" + 
				"                \"apparentTemperatureLowTime\": 1566392400,\n" + 
				"                \"dewPoint\": 55.86,\n" + 
				"                \"humidity\": 0.76,\n" + 
				"                \"pressure\": 1016.6,\n" + 
				"                \"windSpeed\": 5.24,\n" + 
				"                \"windGust\": 11.92,\n" + 
				"                \"windGustTime\": 1566349200,\n" + 
				"                \"windBearing\": 305,\n" + 
				"                \"cloudCover\": 0.37,\n" + 
				"                \"uvIndex\": 8,\n" + 
				"                \"uvIndexTime\": 1566331200,\n" + 
				"                \"visibility\": 9.719,\n" + 
				"                \"ozone\": 300.8,\n" + 
				"                \"temperatureMin\": 55.65,\n" + 
				"                \"temperatureMinTime\": 1566306000,\n" + 
				"                \"temperatureMax\": 76.79,\n" + 
				"                \"temperatureMaxTime\": 1566342000,\n" + 
				"                \"apparentTemperatureMin\": 55.65,\n" + 
				"                \"apparentTemperatureMinTime\": 1566306000,\n" + 
				"                \"apparentTemperatureMax\": 76.79,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566342000\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566370800,\n" + 
				"                \"summary\": \"Partly cloudy throughout the day.\",\n" + 
				"                \"icon\": \"partly-cloudy-day\",\n" + 
				"                \"sunriseTime\": 1566394256,\n" + 
				"                \"sunsetTime\": 1566442453,\n" + 
				"                \"moonPhase\": 0.7,\n" + 
				"                \"precipIntensity\": 0.0002,\n" + 
				"                \"precipIntensityMax\": 0.0008,\n" + 
				"                \"precipIntensityMaxTime\": 1566378000,\n" + 
				"                \"precipProbability\": 0.01,\n" + 
				"                \"precipType\": \"rain\",\n" + 
				"                \"temperatureHigh\": 83.67,\n" + 
				"                \"temperatureHighTime\": 1566424800,\n" + 
				"                \"temperatureLow\": 59.37,\n" + 
				"                \"temperatureLowTime\": 1566478800,\n" + 
				"                \"apparentTemperatureHigh\": 83.8,\n" + 
				"                \"apparentTemperatureHighTime\": 1566424800,\n" + 
				"                \"apparentTemperatureLow\": 59.37,\n" + 
				"                \"apparentTemperatureLowTime\": 1566478800,\n" + 
				"                \"dewPoint\": 57,\n" + 
				"                \"humidity\": 0.7,\n" + 
				"                \"pressure\": 1014.58,\n" + 
				"                \"windSpeed\": 4.62,\n" + 
				"                \"windGust\": 11.49,\n" + 
				"                \"windGustTime\": 1566432000,\n" + 
				"                \"windBearing\": 292,\n" + 
				"                \"cloudCover\": 0.2,\n" + 
				"                \"uvIndex\": 10,\n" + 
				"                \"uvIndexTime\": 1566417600,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 291.4,\n" + 
				"                \"temperatureMin\": 55.92,\n" + 
				"                \"temperatureMinTime\": 1566392400,\n" + 
				"                \"temperatureMax\": 83.67,\n" + 
				"                \"temperatureMaxTime\": 1566424800,\n" + 
				"                \"apparentTemperatureMin\": 55.92,\n" + 
				"                \"apparentTemperatureMinTime\": 1566392400,\n" + 
				"                \"apparentTemperatureMax\": 83.8,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566424800\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566457200,\n" + 
				"                \"summary\": \"Clear throughout the day.\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"sunriseTime\": 1566480706,\n" + 
				"                \"sunsetTime\": 1566528773,\n" + 
				"                \"moonPhase\": 0.73,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipIntensityMax\": 0,\n" + 
				"                \"precipIntensityMaxTime\": 1566504000,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperatureHigh\": 88.27,\n" + 
				"                \"temperatureHighTime\": 1566514800,\n" + 
				"                \"temperatureLow\": 60.04,\n" + 
				"                \"temperatureLowTime\": 1566565200,\n" + 
				"                \"apparentTemperatureHigh\": 88.7,\n" + 
				"                \"apparentTemperatureHighTime\": 1566514800,\n" + 
				"                \"apparentTemperatureLow\": 60.22,\n" + 
				"                \"apparentTemperatureLowTime\": 1566565200,\n" + 
				"                \"dewPoint\": 59.65,\n" + 
				"                \"humidity\": 0.69,\n" + 
				"                \"pressure\": 1010.5,\n" + 
				"                \"windSpeed\": 3,\n" + 
				"                \"windGust\": 9.43,\n" + 
				"                \"windGustTime\": 1566518400,\n" + 
				"                \"windBearing\": 245,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 10,\n" + 
				"                \"uvIndexTime\": 1566504000,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 290.4,\n" + 
				"                \"temperatureMin\": 59.37,\n" + 
				"                \"temperatureMinTime\": 1566478800,\n" + 
				"                \"temperatureMax\": 88.27,\n" + 
				"                \"temperatureMaxTime\": 1566514800,\n" + 
				"                \"apparentTemperatureMin\": 59.37,\n" + 
				"                \"apparentTemperatureMinTime\": 1566478800,\n" + 
				"                \"apparentTemperatureMax\": 88.7,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566514800\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566543600,\n" + 
				"                \"summary\": \"Clear throughout the day.\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"sunriseTime\": 1566567157,\n" + 
				"                \"sunsetTime\": 1566615092,\n" + 
				"                \"moonPhase\": 0.77,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipIntensityMax\": 0,\n" + 
				"                \"precipIntensityMaxTime\": 1566612000,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperatureHigh\": 87.58,\n" + 
				"                \"temperatureHighTime\": 1566597600,\n" + 
				"                \"temperatureLow\": 59.92,\n" + 
				"                \"temperatureLowTime\": 1566648000,\n" + 
				"                \"apparentTemperatureHigh\": 89.26,\n" + 
				"                \"apparentTemperatureHighTime\": 1566597600,\n" + 
				"                \"apparentTemperatureLow\": 59.92,\n" + 
				"                \"apparentTemperatureLowTime\": 1566648000,\n" + 
				"                \"dewPoint\": 60.78,\n" + 
				"                \"humidity\": 0.71,\n" + 
				"                \"pressure\": 1011.57,\n" + 
				"                \"windSpeed\": 2.86,\n" + 
				"                \"windGust\": 9.54,\n" + 
				"                \"windGustTime\": 1566604800,\n" + 
				"                \"windBearing\": 246,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 9,\n" + 
				"                \"uvIndexTime\": 1566590400,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 291.7,\n" + 
				"                \"temperatureMin\": 60.04,\n" + 
				"                \"temperatureMinTime\": 1566565200,\n" + 
				"                \"temperatureMax\": 87.58,\n" + 
				"                \"temperatureMaxTime\": 1566597600,\n" + 
				"                \"apparentTemperatureMin\": 60.22,\n" + 
				"                \"apparentTemperatureMinTime\": 1566565200,\n" + 
				"                \"apparentTemperatureMax\": 89.26,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566597600\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566630000,\n" + 
				"                \"summary\": \"Clear throughout the day.\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"sunriseTime\": 1566653607,\n" + 
				"                \"sunsetTime\": 1566701410,\n" + 
				"                \"moonPhase\": 0.8,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipIntensityMax\": 0,\n" + 
				"                \"precipIntensityMaxTime\": 1566666000,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperatureHigh\": 91.07,\n" + 
				"                \"temperatureHighTime\": 1566684000,\n" + 
				"                \"temperatureLow\": 61.28,\n" + 
				"                \"temperatureLowTime\": 1566734400,\n" + 
				"                \"apparentTemperatureHigh\": 93.08,\n" + 
				"                \"apparentTemperatureHighTime\": 1566684000,\n" + 
				"                \"apparentTemperatureLow\": 61.28,\n" + 
				"                \"apparentTemperatureLowTime\": 1566734400,\n" + 
				"                \"dewPoint\": 60.85,\n" + 
				"                \"humidity\": 0.67,\n" + 
				"                \"pressure\": 1012.99,\n" + 
				"                \"windSpeed\": 2.23,\n" + 
				"                \"windGust\": 6.14,\n" + 
				"                \"windGustTime\": 1566680400,\n" + 
				"                \"windBearing\": 313,\n" + 
				"                \"cloudCover\": 0,\n" + 
				"                \"uvIndex\": 9,\n" + 
				"                \"uvIndexTime\": 1566676800,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 287.1,\n" + 
				"                \"temperatureMin\": 59.92,\n" + 
				"                \"temperatureMinTime\": 1566648000,\n" + 
				"                \"temperatureMax\": 91.07,\n" + 
				"                \"temperatureMaxTime\": 1566684000,\n" + 
				"                \"apparentTemperatureMin\": 59.92,\n" + 
				"                \"apparentTemperatureMinTime\": 1566648000,\n" + 
				"                \"apparentTemperatureMax\": 93.08,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566684000\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"time\": 1566716400,\n" + 
				"                \"summary\": \"Clear throughout the day.\",\n" + 
				"                \"icon\": \"clear-day\",\n" + 
				"                \"sunriseTime\": 1566740057,\n" + 
				"                \"sunsetTime\": 1566787727,\n" + 
				"                \"moonPhase\": 0.84,\n" + 
				"                \"precipIntensity\": 0,\n" + 
				"                \"precipIntensityMax\": 0,\n" + 
				"                \"precipIntensityMaxTime\": 1566734400,\n" + 
				"                \"precipProbability\": 0,\n" + 
				"                \"temperatureHigh\": 92.4,\n" + 
				"                \"temperatureHighTime\": 1566770400,\n" + 
				"                \"temperatureLow\": 61.26,\n" + 
				"                \"temperatureLowTime\": 1566820800,\n" + 
				"                \"apparentTemperatureHigh\": 94.26,\n" + 
				"                \"apparentTemperatureHighTime\": 1566770400,\n" + 
				"                \"apparentTemperatureLow\": 61.26,\n" + 
				"                \"apparentTemperatureLowTime\": 1566820800,\n" + 
				"                \"dewPoint\": 60.31,\n" + 
				"                \"humidity\": 0.64,\n" + 
				"                \"pressure\": 1013.7,\n" + 
				"                \"windSpeed\": 2.12,\n" + 
				"                \"windGust\": 5.61,\n" + 
				"                \"windGustTime\": 1566777600,\n" + 
				"                \"windBearing\": 317,\n" + 
				"                \"cloudCover\": 0.02,\n" + 
				"                \"uvIndex\": 10,\n" + 
				"                \"uvIndexTime\": 1566763200,\n" + 
				"                \"visibility\": 10,\n" + 
				"                \"ozone\": 280.7,\n" + 
				"                \"temperatureMin\": 61.28,\n" + 
				"                \"temperatureMinTime\": 1566734400,\n" + 
				"                \"temperatureMax\": 92.4,\n" + 
				"                \"temperatureMaxTime\": 1566770400,\n" + 
				"                \"apparentTemperatureMin\": 61.28,\n" + 
				"                \"apparentTemperatureMinTime\": 1566734400,\n" + 
				"                \"apparentTemperatureMax\": 94.26,\n" + 
				"                \"apparentTemperatureMaxTime\": 1566770400\n" + 
				"            }\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    \"flags\": {\n" + 
				"        \"sources\": [\n" + 
				"            \"nwspa\",\n" + 
				"            \"cmc\",\n" + 
				"            \"gfs\",\n" + 
				"            \"hrrr\",\n" + 
				"            \"icon\",\n" + 
				"            \"isd\",\n" + 
				"            \"madis\",\n" + 
				"            \"nam\",\n" + 
				"            \"sref\",\n" + 
				"            \"darksky\",\n" + 
				"            \"nearest-precip\"\n" + 
				"        ],\n" + 
				"        \"nearest-station\": 0.698,\n" + 
				"        \"units\": \"us\"\n" + 
				"    },\n" + 
				"    \"offset\": -7\n" + 
				"}";
		List<DailySummary> list=WeatherUtil.getSummary(s);
		for(DailySummary en:list) {
			System.err.println(en.getDate()+"《》"+en.getSummary());
		}
	}
	
    @Test
    public void testDay() {
    	Date d=new Date(1566111600l*1000);
    	//d.setTime(1566111600l);
    	System.out.println(d);
    }
}
