package com.xworkz.product.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.product")
@EnableWebMvc

public class WebConfiguration {
	
	public WebConfiguration() {
		System.out.println("No-arg const in WebConfiguration");
	}

}
