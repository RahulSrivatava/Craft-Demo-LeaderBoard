package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.exceptions.CacheInitializationException;
import com.crafts_demo.LeaderBoard.exceptions.CacheUpdateFailureException;

import java.util.List;

public interface cacheService<T> {
    public void intializeCache(int topN, List<T> goals) throws CacheInitializationException;;
    public void saveDataToCache(T data) throws CacheUpdateFailureException;;
    public List<T> getTopNPlayer();
}
