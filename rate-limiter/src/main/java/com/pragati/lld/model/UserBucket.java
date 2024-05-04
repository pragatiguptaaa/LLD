package com.pragati.lld.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

public class UserBucket
{
    private int userId;
    private Queue<Long> timeStamps;

    public UserBucket(int userId)
    {
        this.userId = userId;
        this.timeStamps = new LinkedList<>();
    }

    public int getUserId() {
        return userId;
    }

    public Long getOldestTimestamp()
    {
        return !this.timeStamps.isEmpty() ? timeStamps.peek(): null;
    }

    public void removeOldestTimestamp()
    {
        if(!this.timeStamps.isEmpty())
        this.timeStamps.poll();
    }

    public void addNewTimeStamp(Long timeStamp) {
        this.timeStamps.offer(timeStamp);
    }

    public int getBucketSize()
    {
        return this.timeStamps.size();
    }

}
