package com.crafts_demo.LeaderBoard.services;

import java.util.List;

public interface cacheService<T> {
    public void intializeCache(int topN, List<T> goals);
    public void saveDataToCache(T data);
    public List<T> getTopNPlayer();
}
