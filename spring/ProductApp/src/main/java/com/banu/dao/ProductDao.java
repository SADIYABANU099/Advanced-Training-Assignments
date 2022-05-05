package com.banu.dao;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.banu.ProductApp.App;

@Configuration
@ComponentScan("com.banu")
public class AppConfig {
	
	@Bean
	public App getApp() {
		
		return new App();
	}

}

