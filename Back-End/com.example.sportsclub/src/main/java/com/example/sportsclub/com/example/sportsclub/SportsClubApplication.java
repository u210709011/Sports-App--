package com.example.sportsclub.com.example.sportsclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SportsClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsClubApplication.class, args);
	}

}
