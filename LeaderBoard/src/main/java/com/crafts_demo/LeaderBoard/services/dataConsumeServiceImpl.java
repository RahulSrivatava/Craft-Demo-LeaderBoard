package com.crafts_demo.LeaderBoard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class dataConsumeServiceImpl implements dataConsumeService<com.crafts_demo.LeaderBoard.entity.playerGoals> {
    @Autowired
    goalsAggregratorService goalsAggregrator;
    @KafkaListener(topics = "scoreboard", groupId = "abc")
    public void consumeData(com.crafts_demo.LeaderBoard.entity.playerGoals data) {
        System.out.println("Data is Comming " + data);
        goalsAggregrator.storeData(data);
    }


}

