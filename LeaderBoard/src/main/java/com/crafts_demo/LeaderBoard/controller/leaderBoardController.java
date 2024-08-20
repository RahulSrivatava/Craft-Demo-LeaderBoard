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

    @GetMapping ("/getTopNPlayer")
    public List<playerGoal> getTopNPlayer() {
        return leaderBoard.getTopNPlayer();
    }
}
