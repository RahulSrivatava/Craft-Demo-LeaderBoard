package com.crafts_demo.ScoreBoard.controller;

import com.crafts_demo.ScoreBoard.entity.playerScore;
import com.crafts_demo.ScoreBoard.services.newDataProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class scoreBoardController {
    @Autowired
    private newDataProducerServiceImpl producer;
    @GetMapping("/api")
    public String getReponse(){
        return "HI";
    }
    @PostMapping("/send")
    public void hello(@RequestBody playerScore msg) {
//        System.out.println(msg);
        producer.addtoqueue(msg);
        return ;
    }
}
