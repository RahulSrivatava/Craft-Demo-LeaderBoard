package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;

public interface goalsAggregratorToScoreBoard {
    public void registerLeaderBoard(leaderBoardService deffaultBoard);
    public void saveToScoreBoard(playerGoal newGoal);

}
