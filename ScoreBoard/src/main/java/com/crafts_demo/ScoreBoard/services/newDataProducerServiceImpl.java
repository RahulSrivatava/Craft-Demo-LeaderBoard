package com.crafts_demo.ScoreBoard.services;

import com.crafts_demo.ScoreBoard.entity.playerScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class newDataProducerServiceImpl implements  newDataProduceService<playerScore>{
    @Autowired
    private KafkaTemplate<String,playerScore> kafkaTemplate;

    public void addtoqueue(playerScore newdata) {
        kafkaTemplate.send("leaderboard", newdata);

    }
}
