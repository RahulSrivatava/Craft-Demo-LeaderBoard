package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.contants.constants;
import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crafts_demo.LeaderBoard.contants.constants.DEFAULT_LEADERBOARD_SIZE;

@Service
public class leaderBoardServiceImpl implements  leaderBoardService<playerGoal>{
    boolean leaderBoardInitialized=false;
    
    @Autowired
    cacheService cache;
    @Autowired
    playerGoalRepository repository;
    @Autowired
    goalsAggregatorToScoreBoard goalsAgggrator;

    @PostConstruct
    public void createBoard() {
        intializeLeaderBoard();
    }
    private void intializeLeaderBoard() {
        List<playerGoal> allGoals = repository.findAll();
        cache.intializeCache(DEFAULT_LEADERBOARD_SIZE, allGoals);
        goalsAgggrator.registerLeaderBoard(this);
        leaderBoardInitialized = true;
    }

    public void saveData(playerGoal newGoal) {
        cache.saveDataToCache(newGoal);

    }

    public List<playerGoal> getTopNPlayer() {
        return cache.getTopNPlayer();
    }
}
