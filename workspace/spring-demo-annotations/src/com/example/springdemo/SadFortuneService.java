package com.example.springdemo;

public class SadFortuneService implements FortuneService {
	@Override
	public String getFortune() {
		return "Jesus christ just stop it with all these fortune services already.";
	}
}
