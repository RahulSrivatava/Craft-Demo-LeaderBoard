package com.crafts_demo.LeaderBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class LeaderBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderBoardApplication.class, args);
	}

}
