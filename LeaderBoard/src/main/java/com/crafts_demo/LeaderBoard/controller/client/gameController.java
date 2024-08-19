package com.crafts_demo.LeaderBoard.controller.client;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.services.goalsAggregratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gameController {


    @Autowired
    goalsAggregratorService goalsAggregrator;
    @PostMapping("/updateGoal")
    public void  updateGoal(@RequestBody playerGoal newGoal){
        goalsAggregrator.storeData(newGoal);
    }

}
