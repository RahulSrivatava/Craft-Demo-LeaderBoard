package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.leaderBoard;
import com.crafts_demo.LeaderBoard.entity.playerGoals;
import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class goalsAggregratorServiceImpl implements goalsAggregratorService , goalsAggregatorToStorage ,goalsAggregatorToScoreBoard {
    List<leaderBoard> scoreBoardList = new ArrayList<>();

   @Autowired
   playerGoalRepository goalRepository;

    public void saveToScoreBoard(playerGoals newGoal) {
        System.out.println(newGoal.getPlayerID()+newGoal.getGoals());
    }

    public void saveToStore(playerGoals newGoal) {
        try {
            Optional<playerGoals> playerPresent = goalRepository.findById(newGoal.getPlayerID());
            if (playerPresent.isPresent() && playerPresent.get().getGoals() >= newGoal.getGoals()) {
                return;
            }
            goalRepository.save(newGoal);
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void storeData( playerGoals newGoal) {
        saveToStore(newGoal);
        saveToScoreBoard(newGoal);
    }
}
