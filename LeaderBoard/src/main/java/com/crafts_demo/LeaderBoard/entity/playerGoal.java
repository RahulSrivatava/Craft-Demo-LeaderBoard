package com.crafts_demo.LeaderBoard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class playerGoal implements Comparable<playerGoal> {
    @Id
    private String playerId;
    private Long goals;

    public playerGoal() {
    }

    public playerGoal(String playerId, Long goals) {
        this.playerId = playerId;
        this.goals = goals;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    @Override
    public int compareTo(playerGoal p) {
        int goalComparison = Long.compare(this.goals, p.getGoals());
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
        return playerId.equals(that.playerId) && goals.equals(that.goals);
    }

    @Override
    public int hashCode() {
        int result = playerId.hashCode();
        result = 31 * result + goals.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + playerId + " " + goals + "}";
    }
}
