package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.board;
import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.CacheInitializationException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardNotInitializedException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardUpdateFailureException;

import java.util.List;

public interface leaderBoardService{
    public void createBoard(int topN)throws CacheInitializationException, LeaderboardNotInitializedException;
    public void saveData(playerGoal newGoal) throws LeaderboardUpdateFailureException;
    public List<playerGoal> getTopNPlayer() throws LeaderboardNotInitializedException;

}
