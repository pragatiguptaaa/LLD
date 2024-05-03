package com.pragati.lld.strategy;

import com.pragati.lld.model.RateLimiterConfig;
import com.pragati.lld.model.UserBucket;
import org.springframework.stereotype.Component;

@Component
public class SlidingWindowStrategy implements RateLimitingStrategy{

    @Override
    public boolean canServe(UserBucket userBucket, Long currentTimeMillis)
    {
        while(userBucket.getOldestTimestamp()!= null &&
                (currentTimeMillis- userBucket.getOldestTimestamp() > RateLimiterConfig.getWindowInMillis()))
        {
            userBucket.removeOldestTimestamp();
        }

        if(userBucket.getBucketSize()< RateLimiterConfig.getMaxLimit())
        {
            userBucket.addNewTimeStamp(currentTimeMillis);
            return true;
        }

        return false;
    }
}
