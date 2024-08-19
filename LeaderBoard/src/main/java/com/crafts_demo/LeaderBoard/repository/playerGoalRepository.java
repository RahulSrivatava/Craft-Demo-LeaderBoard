package com.crafts_demo.LeaderBoard.repository;

import com.crafts_demo.LeaderBoard.entity.playerGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface playerGoalRepository extends JpaRepository<playerGoals,String> {
}
