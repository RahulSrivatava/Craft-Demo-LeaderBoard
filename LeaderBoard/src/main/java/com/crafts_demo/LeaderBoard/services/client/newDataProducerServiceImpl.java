package com.crafts_demo.LeaderBoard.services.client;

import com.crafts_demo.LeaderBoard.entity.playerGoals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class newDataProducerServiceImpl implements newDataProduceService<playerGoals> {
    @Autowired
    private KafkaTemplate<String, com.crafts_demo.LeaderBoard.entity.playerGoals> kafkaTemplate;

    public void addtoqueue(com.crafts_demo.LeaderBoard.entity.playerGoals newdata) {
        kafkaTemplate.send("scoreboard", newdata);

    }
}
