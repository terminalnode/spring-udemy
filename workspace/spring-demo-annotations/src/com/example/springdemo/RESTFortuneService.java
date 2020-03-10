package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component("restFortuneService") // no idea what the default name for this one is
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Itsa mee, RESTFortuneService!";
	}

}
