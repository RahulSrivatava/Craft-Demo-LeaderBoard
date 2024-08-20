package com.crafts_demo.LeaderBoard;

import com.crafts_demo.LeaderBoard.repository.playerGoalRepository;
import com.crafts_demo.LeaderBoard.services.cacheService;
import com.crafts_demo.LeaderBoard.services.goalsAggregratorToScoreBoard;
import com.crafts_demo.LeaderBoard.services.leaderBoardService;
import com.crafts_demo.LeaderBoard.entity.playerGoal;
import com.crafts_demo.LeaderBoard.services.client.newDataProducerService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SpringBootTest(classes = LeaderBoardApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LeaderBoardApplicationTests {

	@Autowired
	private leaderBoardService leaderBoard;

	@Autowired
	newDataProducerService<playerGoal> producer;

	@Test
    public void testServiceComponents() throws InterruptedException  {

		try {
			leaderBoard.createBoard();
		} catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			producer.addToQueue(new playerGoal("Rahul", 7));
		} catch (Exception e) {
			fail(e.getMessage());
		}
		System.out.println("Before");

		Thread.sleep(5000);
		System.out.println("After");

		try {
			playerGoal[] outputList = {
					new playerGoal("Rahul", 7),
					new playerGoal("Brijesh", 6),
					new playerGoal("Rohit", 3),
					new playerGoal("Nishchhal", 2),
					new playerGoal("Shivam", 1)
			};

			int i = 0;
			for (playerGoal p : leaderBoard.getTopNPlayer()) {
				assertEquals(outputList[i++], p);
			}

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
