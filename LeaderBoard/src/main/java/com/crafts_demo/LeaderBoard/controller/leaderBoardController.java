package com.crafts_demo.LeaderBoard.controller;

import com.crafts_demo.LeaderBoard.services.client.newDataProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class leaderBoardController {
    @Autowired
    private newDataProducerServiceImpl producer;
    @GetMapping("/api")
    public String getReponse(){
        return "HI";
    }
    @PostMapping("/send")
    public void hello(@RequestBody com.crafts_demo.LeaderBoard.entity.playerGoals msg) {
//        System.out.println(msg);
        producer.addtoqueue(msg);
        return ;
    }
}
