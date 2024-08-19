package com.crafts_demo.LeaderBoard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class playerGoals {
    @Id
    String playerID;
    Long goals;

    public playerGoals() {

    }
    @Override
    public String toString() {
        return "{" + playerID + " " + goals + "}";
    }
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    public playerGoals(String playerID, Long goals) {
        this.playerID = playerID;
        this.goals = goals;
    }

}
