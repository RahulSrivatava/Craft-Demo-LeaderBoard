package com.crafts_demo.LeaderBoard.repository;

import com.crafts_demo.LeaderBoard.entity.playerGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface playerGoalRepository extends JpaRepository<playerGoal,String> {
}
