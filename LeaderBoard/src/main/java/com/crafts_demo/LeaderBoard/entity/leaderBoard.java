package com.crafts_demo.LeaderBoard.entity;

public class leaderBoard {
    String  boardID;
    Integer scoreBoardSize;

    public leaderBoard() {
    }

    public leaderBoard(String boardID, Integer scoreBoardSize) {
        this.boardID = boardID;
        this.scoreBoardSize = scoreBoardSize;
    }

    public String getBoardID() {
        return boardID;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }

    public Integer getScoreBoardSize() {
        return scoreBoardSize;
    }

    public void setScoreBoardSize(Integer scoreBoardSize) {
        this.scoreBoardSize = scoreBoardSize;
    }
}
