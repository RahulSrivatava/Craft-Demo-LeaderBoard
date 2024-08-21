package com.crafts_demo.LeaderBoard.controller;

import com.crafts_demo.LeaderBoard.entity.board;
import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.LeaderboardNotInitializedException;
import com.crafts_demo.LeaderBoard.services.leaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class leaderBoardController {

    @Autowired
    leaderBoardService leaderBoard;

    @GetMapping ("/getTopNPlayer")
    public List<playerGoal> getTopNPlayer() {
        try {
            return leaderBoard.getTopNPlayer();
        }catch (LeaderboardNotInitializedException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Please register/create LeaderBoard first");
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @PostMapping("/createBoard")
    public void createBoard(@RequestBody board input) {
        try {
            leaderBoard.createBoard(input.getLeaderBoardSize());
        } catch (Exception e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Please register/create LeaderBoard first");
        }
    }

}
