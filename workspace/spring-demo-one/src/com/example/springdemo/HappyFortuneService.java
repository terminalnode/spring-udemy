package com.example.springdemo;

public class HappyFortuneService implements FortuneService {
	@Override
	public String getFortune() {
		return "You will die today.";
	}
}
