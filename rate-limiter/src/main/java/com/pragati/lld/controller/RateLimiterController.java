package com.pragati.lld.controller;

import com.pragati.lld.service.RateLimiterService;
import org.springframework.stereotype.Controller;

@Controller
public class RateLimiterController {

    RateLimiterService rateLimiterService;
    public RateLimiterController(RateLimiterService rateLimiterService) {
        this.rateLimiterService= rateLimiterService;
    }

    public void canServeUser(int userId, int requestId) {
        boolean canServe = rateLimiterService.canServeUser(userId);

        if (canServe)
            System.out.println("Response code: 200. Request with request Id : " + requestId+" can be served");
        else
            System.out.println(" Response code: 429. Too many requests.");
    }
}
