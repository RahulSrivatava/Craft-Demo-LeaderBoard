package com.crafts_demo.ScoreBoard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class playerScore{
    @Id
    @Column(name="playerID")
    String playerID;
    Long goals;

    public playerScore() {

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

    public playerScore(String playerID, Long goals) {
        this.playerID = playerID;
        this.goals = goals;
    }

}
