package com.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weather.service.WeatherService;

@Controller
@RequestMapping("weather")
@SpringBootApplication
@ComponentScan(basePackages = {"com.weather"})
public class WeatherApplication {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("citys", weatherService.getWeathers());
		return "list";
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
