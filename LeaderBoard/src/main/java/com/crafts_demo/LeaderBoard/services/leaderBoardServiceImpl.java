package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.CacheInitializationException;
import com.crafts_demo.LeaderBoard.exceptions.CacheUpdateFailureException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardNotInitializedException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardUpdateFailureException;
import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crafts_demo.LeaderBoard.contants.constants.DEFAULT_LEADERBOARD_SIZE;

@Service
public class leaderBoardServiceImpl implements  leaderBoardService{

    boolean leaderBoardInitialized;

    @Autowired
    cacheService<playerGoal> cache;
    @Autowired
    playerGoalRepository repository;
    @Autowired
    goalsAggregratorToScoreBoard goalsAgggrator;

    @PostConstruct
    public void createBoard()throws LeaderboardNotInitializedException {
        intializeLeaderBoard(DEFAULT_LEADERBOARD_SIZE);
    }
    private void intializeLeaderBoard(int topN)throws LeaderboardNotInitializedException {
       try{
           List<playerGoal> allGoals = repository.findAll();
           cache.intializeCache(topN, allGoals);
           goalsAgggrator.registerLeaderBoard(this);
           leaderBoardInitialized = true;
       }
       catch (CacheInitializationException e){
           throw new LeaderboardNotInitializedException(e.getMessage());
       }

    }

    public void createBoard(int topN)throws LeaderboardNotInitializedException {
        intializeLeaderBoard(topN);
    }

    public void saveData(playerGoal newGoal) throws LeaderboardUpdateFailureException {
        try{
            cache.saveDataToCache(newGoal);
        }catch (CacheUpdateFailureException e ){
            throw new LeaderboardUpdateFailureException(e.getMessage());
        }

    }

    public List<playerGoal> getTopNPlayer() throws LeaderboardNotInitializedException {
        if (!leaderBoardInitialized) {
            throw new LeaderboardNotInitializedException("LeaderBoard not yet initialized");
        }
        return cache.getTopNPlayer();
    }
}
