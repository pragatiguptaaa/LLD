package com.pragati.lld.strategy;

import com.pragati.lld.model.UserBucket;

public interface RateLimitingStrategy {

    boolean canServe(UserBucket userBucket, Long currentTimeMillis) ;
}
