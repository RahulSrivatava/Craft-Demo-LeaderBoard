package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class goalsAggregratorServiceImpl implements goalsAggregratorService , goalsAggregatorToStorage , goalsAggregratorToScoreBoard {

   @Autowired
   playerGoalRepository goalRepository;

   leaderBoardService leaderBoard;

    public void saveToScoreBoard(playerGoal newGoal) {
            leaderBoard.saveData(newGoal);
    }
    public void registerLeaderBoard(leaderBoardService defaultBoard) {
        leaderBoard=defaultBoard;
    }
    public void saveToStore(playerGoal newGoal) {
        try {
            Optional<playerGoal> playerPresent = goalRepository.findById(newGoal.getPlayerId());
            if (playerPresent.isPresent() && playerPresent.get().getGoal() >= newGoal.getGoal()) {
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
