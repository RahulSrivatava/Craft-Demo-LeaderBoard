package com.crafts_demo.LeaderBoard.services;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class cacheServiceImpl implements cacheService<playerGoal> {
    int topN;
    PriorityQueue<playerGoal> minHeap;
    Map<String, playerGoal> playerToGoal;

    public void intializeCache(int topN, List<playerGoal> goals) {
        this.topN = topN;
        minHeap = new PriorityQueue<playerGoal>();
        playerToGoal = new HashMap<String, playerGoal>();
        for (playerGoal score : goals) {
             if (minHeap.size() < topN) {
                minHeap.add(score);
                playerToGoal.put(score.getPlayerId(), score);
            } else {
                if (score.getGoal() > minHeap.peek().getGoal()) {
                    playerGoal removedScore = minHeap.poll();
                    minHeap.add(score);
                    playerToGoal.remove(removedScore.getPlayerId());
                    playerToGoal.put(score.getPlayerId(), score);
                }
            }
        }
    }

    public void saveDataToCache(playerGoal newGoal) {
        try{
            if (playerToGoal.containsKey(newGoal.getPlayerId())) {
                playerGoal scoreToBeUpdated = playerToGoal.get(newGoal.getPlayerId());

                if (scoreToBeUpdated.getGoal() < newGoal.getGoal()) {
                    minHeap.remove(scoreToBeUpdated);
                    playerToGoal.put(newGoal.getPlayerId(), newGoal);
                    minHeap.add(newGoal);
                }
                return;
            }
            if (minHeap.size() < topN) {
                minHeap.add(newGoal);
                playerToGoal.put(newGoal.getPlayerId(), newGoal);
            } else {
                if (newGoal.getGoal() > minHeap.peek().getGoal()) {
                    playerGoal removedScore = minHeap.poll();
                    minHeap.add(newGoal);
                    playerToGoal.remove(removedScore.getPlayerId());
                    playerToGoal.put(newGoal.getPlayerId(), newGoal);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<playerGoal> getTopNPlayer() {
        List<playerGoal> res = new ArrayList<playerGoal>(minHeap);
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}
