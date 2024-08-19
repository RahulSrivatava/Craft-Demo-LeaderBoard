package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.crafts_demo.LeaderBoard.contants.constants.KAFKA_GROUP_ID;
import static com.crafts_demo.LeaderBoard.contants.constants.KAFKA_TOPIC;

@Service
public class dataConsumeServiceImpl implements dataConsumeService<playerGoal> {
    @Autowired
    goalsAggregratorService goalsAggregrator;
    @KafkaListener(topics = KAFKA_TOPIC, groupId = KAFKA_GROUP_ID)
    public void consumeData(playerGoal data) {
        System.out.println("Data is Comming " + data);
        goalsAggregrator.storeData(data);
    }


}

