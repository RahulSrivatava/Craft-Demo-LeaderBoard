package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;

public interface goalsAggregatorToStorage {
    public void saveToStore(playerGoal newGoal);

}
