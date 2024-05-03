package com.pragati.lld;

import com.pragati.lld.controller.RateLimiterController;
import com.pragati.lld.service.RateLimiterService;
import com.pragati.lld.strategy.SlidingWindowStrategy;

public class Main {

    public static void main(String[] args) {

        SlidingWindowStrategy slidingWindowStrategy = new SlidingWindowStrategy();
        RateLimiterService rateLimiterService = new RateLimiterService(slidingWindowStrategy);
        RateLimiterController rateLimiterController = new RateLimiterController(rateLimiterService);

        rateLimiterController.canServeUser(1,1);
        rateLimiterController.canServeUser(1,2);
        rateLimiterController.canServeUser(2,3);
        rateLimiterController.canServeUser(1,4);
        rateLimiterController.canServeUser(1,5);
        rateLimiterController.canServeUser(2,6);
    }
}
