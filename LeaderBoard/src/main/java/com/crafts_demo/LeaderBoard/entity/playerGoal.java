package com.crafts_demo.LeaderBoard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class playerGoal implements Comparable<playerGoal> {
    @Id
    private String playerId;
    private Integer goal;

    public playerGoal() {
    }

    public playerGoal(String playerId, Integer goal) {
        this.playerId = playerId;
        this.goal = goal;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goals) {
        this.goal = goals;
    }

    @Override
    public int compareTo(playerGoal p) {
        int goalComparison = Long.compare(this.goal, p.getGoal());
        if (goalComparison == 0) {
            return this.playerId.compareTo(p.getPlayerId());
        }
        return goalComparison;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        playerGoal that = (playerGoal) o;
        return playerId.equals(that.playerId) && goal.equals(that.goal);
    }

    @Override
    public String toString() {
        return "{" + playerId + " " + goal + "}";
    }
}
