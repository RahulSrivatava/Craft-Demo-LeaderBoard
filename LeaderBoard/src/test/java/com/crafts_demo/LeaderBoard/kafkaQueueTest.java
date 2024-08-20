package com.crafts_demo.LeaderBoard;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.services.client.newDataProducerService;
import com.crafts_demo.LeaderBoard.services.leaderBoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.fail;


@SpringBootTest(classes = LeaderBoardApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)

public class kafkaQueueTest {
    @Autowired
    newDataProducerService <playerGoal>producer;

    @Autowired
    leaderBoardService leaderBoard;
    @Test
    public void kafkaTest() {
        try {
            producer.addToQueue(new playerGoal("GB", 100));
            Thread.sleep(5000);
            System.out.println(leaderBoard.getTopNPlayer());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
