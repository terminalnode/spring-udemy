package com.example.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private Random random = new Random();
	private String[] fortunes = {
			"This is a fortune!",
			"This is also a fortune!",
			"YOU'RE A FORTUNE!"
	};

	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);
		return fortunes[index];
	}

}
