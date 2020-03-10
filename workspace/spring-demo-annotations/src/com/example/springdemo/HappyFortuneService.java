package com.example.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	@Value("${happyFS.fortune}")
	private String fortune;
	
	@Override
	public String getFortune() {
		return fortune;
	}
}