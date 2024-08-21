package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.DatabaseStorageException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardUpdateFailureException;
import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class goalsAggregratorServiceImpl implements goalsAggregratorService , goalsAggregatorToStorage , goalsAggregratorToScoreBoard {

   @Autowired
   playerGoalRepository goalRepository;

    List<leaderBoardService> leaderBoards = new ArrayList<leaderBoardService>();

    public void saveToScoreBoard(playerGoal newGoal) throws LeaderboardUpdateFailureException {
        for (leaderBoardService leaderBoard : leaderBoards) {
            leaderBoard.saveData(newGoal);
        }
    }
    public void registerLeaderBoard(leaderBoardService defaultBoard) {
        leaderBoards.add(defaultBoard);
    }
    public void saveToStore(playerGoal newGoal) throws DatabaseStorageException{
        try {
            Optional<playerGoal> playerPresent = goalRepository.findById(newGoal.getPlayerId());
            if (playerPresent.isPresent() && playerPresent.get().getGoal() >= newGoal.getGoal()) {
                return;
            }
            goalRepository.save(newGoal);
        }
        catch (Exception e) {
            throw new DatabaseStorageException("Could not publish data to storage");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void storeData( playerGoal newGoal) throws LeaderboardUpdateFailureException, DatabaseStorageException {
        saveToStore(newGoal);
        saveToScoreBoard(newGoal);
    }
}
