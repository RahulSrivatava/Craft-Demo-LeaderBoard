package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.DatabaseStorageException;

public interface goalsAggregatorToStorage {
    public void saveToStore(playerGoal newGoal)throws DatabaseStorageException;

}
