package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;

import java.util.List;

public interface leaderBoardService <T>{
    public void createBoard();
    public void saveData(T newGoal);
    public List<T> getTopNPlayer();

}
