package com.crafts_demo.ScoreBoard.services;

import com.crafts_demo.ScoreBoard.entity.playerScore;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class dataConsumeServiceImpl implements dataConsumeService<playerScore> {
    @KafkaListener(topics = "leaderboard", groupId = "abc")
    public void consumeData(playerScore data) {
        System.out.println("Data is Comming " + data);
    }


}

