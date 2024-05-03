package com.pragati.lld.service;

import com.pragati.lld.model.UserBucket;
import com.pragati.lld.strategy.RateLimitingStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RateLimiterService {

    RateLimitingStrategy rateLimitingStrategy;
    Map<Integer, UserBucket> userBuckets;

    public RateLimiterService(RateLimitingStrategy rateLimitingStrategy)
    {
        this.rateLimitingStrategy = rateLimitingStrategy;
        userBuckets = new HashMap<>();
    }

    public boolean canServeUser(int userId)
    {
        Long currentTimeMillis = System.currentTimeMillis();
        if (!userBuckets.containsKey(userId)) {
            userBuckets.put(userId, new UserBucket(userId));
        }

        return rateLimitingStrategy.canServe(userBuckets.get(userId), currentTimeMillis);
    }
}
