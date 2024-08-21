package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.DatabaseStorageException;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardUpdateFailureException;

public interface goalsAggregratorService {
    public void storeData(playerGoal goals) throws LeaderboardUpdateFailureException, DatabaseStorageException;
}
