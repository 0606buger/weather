package com.weather.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.DailySummary;

public class WeatherUtil {
	
	private static ObjectMapper MAPPER=new ObjectMapper();
	
    public static String getWeather(String location) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://api.darksky.net/forecast/4bd5cae3c1be6aeb85e4396a0f718371/"+location);
        CloseableHttpResponse response = httpClient.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);
        response.close();
        httpClient.close();
        return s;
    }
    
    public static List<DailySummary> getSummary(String weatherString) {
    	try {
			JsonNode node=MAPPER.readTree(weatherString).get("daily").get("data");
			boolean flag=true;
			List<DailySummary> list=new ArrayList<>();
			int i=0;
			while(flag) {
				if(node.has(i)) {
					DailySummary dsum=new DailySummary();
					JsonNode day=node.get(i);
					Long time=day.get("time").asLong()*1000;
					Date date=new Date();
					date.setTime(time);
					dsum.setDate(date);
					dsum.setSummary(day.get("summary").asText());
//					String dateString=SDF_DD_MM_YYYY.format(date);
//					map.put(dateString, day.get("summary").asText());
					list.add(dsum);
					i++;
				}else {
					flag=false;
				}
			}
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

}
