package com.crafts_demo.ScoreBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ScorerBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorerBoardApplication.class, args);
	}

}
