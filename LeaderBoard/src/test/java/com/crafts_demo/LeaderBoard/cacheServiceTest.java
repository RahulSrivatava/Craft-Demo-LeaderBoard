package com.crafts_demo.LeaderBoard;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.exceptions.CacheInitializationException;
import com.crafts_demo.LeaderBoard.exceptions.CacheUpdateFailureException;
import com.crafts_demo.LeaderBoard.services.cacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LeaderBoardApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class cacheServiceTest {
    @Autowired
    cacheService cache;
    @Test
    public void test() {
        playerGoal p1 = new playerGoal("Shril", 1);
        playerGoal p2 = new playerGoal("Mohit", 2);
        playerGoal p3 = new playerGoal("Shivam", 3);
        playerGoal p4 = new playerGoal("Rohit", 7);
        List<playerGoal> inputList = new ArrayList<playerGoal>();
        inputList.add(p1);
        inputList.add(p2);
        inputList.add(p3);
        inputList.add(p4);
        List<playerGoal> outputList = new ArrayList<playerGoal>();
        outputList.add(p4);
        outputList.add(p3);
        outputList.add(p2);

        try {
            cache.intializeCache(3, inputList);
        } catch (CacheInitializationException e) {
            fail(e.getMessage());
        }
        System.out.println(cache.getTopNPlayer());
        assertEquals(outputList, cache.getTopNPlayer());
        playerGoal p5 = new playerGoal("Rahul", 9);
        try {
            cache.saveDataToCache(p5);
        } catch (CacheUpdateFailureException e) {
            fail(e.getMessage());
        }
        outputList = new ArrayList<playerGoal>();
        outputList.add(p5);
        outputList.add(p4);
        outputList.add(p3);
        assertEquals(outputList, cache.getTopNPlayer());
    }

}
