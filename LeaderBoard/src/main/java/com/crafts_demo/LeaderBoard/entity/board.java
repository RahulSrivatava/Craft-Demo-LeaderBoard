package com.crafts_demo.LeaderBoard.entity;

public class board {
    String boardId;
    Integer leaderBoardSize;

    public board() {
    }

    public board(String boardID, Integer scoreBoardSize) {
        this.boardId = boardID;
        this.leaderBoardSize = scoreBoardSize;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Integer getLeaderBoardSize() {
        return leaderBoardSize;
    }

    public void setLeaderBoardSize(Integer leaderBoardSize) {
        this.leaderBoardSize = leaderBoardSize;
    }
}
