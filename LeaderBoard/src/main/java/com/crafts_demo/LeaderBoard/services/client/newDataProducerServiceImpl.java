package com.crafts_demo.LeaderBoard.services.client;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.crafts_demo.LeaderBoard.contants.constants.KAFKA_TOPIC;

@Service
public class newDataProducerServiceImpl implements newDataProducerService<playerGoal> {
    @Autowired
    private KafkaTemplate<String, playerGoal> kafkaTemplate;

    public void addToQueue(playerGoal newdata) {
        kafkaTemplate.send(KAFKA_TOPIC, newdata);

    }
}
