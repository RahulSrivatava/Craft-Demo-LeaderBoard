package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoals;

public interface goalsAggregatorToStorage {
    public void saveToStore(playerGoals newGoal);

}
