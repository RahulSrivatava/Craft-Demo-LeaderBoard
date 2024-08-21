package com.crafts_demo.LeaderBoard.services.client;


import com.crafts_demo.LeaderBoard.exceptions.QueueFailureException;

public interface newDataProducerService<T> {
 public void addToQueue(T newdata ) throws QueueFailureException;;
}
