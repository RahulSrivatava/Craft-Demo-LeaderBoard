package com.crafts_demo.LeaderBoard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class leaderBoardController {
    @GetMapping("/hello")
    public String hello(){
       return "Brijesh is a dick";
    }
}
