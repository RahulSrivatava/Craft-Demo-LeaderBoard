package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.leaderBoard;
import com.crafts_demo.LeaderBoard.entity.playerGoal;
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

   @Autowired
   playerGoalRepository goalRepository;

//   @Autowired
   leaderBoardService leaderBoard;

    public void saveToScoreBoard(playerGoal newGoal) {
//        System.out.println(newGoal.getPlayerID()+newGoal.getGoals());
            leaderBoard.saveData(newGoal);
    }
    public void registerLeaderBoard(leaderBoardService deffaultBoard) {
        leaderBoard=deffaultBoard;
    }
    public void saveToStore(playerGoal newGoal) {
        try {
            Optional<playerGoal> playerPresent = goalRepository.findById(newGoal.getPlayerId());
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
    public void storeData( playerGoal newGoal) {
        saveToStore(newGoal);
        saveToScoreBoard(newGoal);
    }
}
