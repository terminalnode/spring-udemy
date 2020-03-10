package com.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springdemo")
public class ConfigurationClass {
	
	@Bean
	public FortuneService fortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(fortuneService());
	}
}
