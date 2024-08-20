package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;

import java.util.List;

public interface leaderBoardService{
    public void createBoard();
    public void saveData(playerGoal newGoal);
    public List<playerGoal> getTopNPlayer();

}
