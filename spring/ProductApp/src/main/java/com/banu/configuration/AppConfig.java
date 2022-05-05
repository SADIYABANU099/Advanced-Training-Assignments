package com.banu.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.banu.ProductApp.App;

@Configuration
@ComponentScan("com.soumyajit")
public class AppConfig {
	
	@Bean
	public App getApp() {
		
		return new App();
	}

}


