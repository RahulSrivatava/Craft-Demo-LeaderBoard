package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardUpdateFailureException;

public interface goalsAggregratorToScoreBoard {
    public void registerLeaderBoard(leaderBoardService Board);
    public void saveToScoreBoard(playerGoal newGoal) throws LeaderboardUpdateFailureException;

}
