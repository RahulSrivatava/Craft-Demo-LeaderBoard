package com.crafts_demo.LeaderBoard.controller;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.services.client.newDataProducerServiceImpl;
import com.crafts_demo.LeaderBoard.services.leaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class leaderBoardController {

    @Autowired
    leaderBoardService leaderBoard;

//    public String getReponse(){
//        return "HI";
//    }
    @GetMapping ("/getTopNPlayer")
    public List<playerGoal> getTopNPlayer() {
//        System.out.println(msg);
//        producer.addtoqueue(msg);
        return leaderBoard.getTopNPlayer();
    }
}
