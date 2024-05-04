package com.pragati.lld.model;

public class RateLimiterConfig
{
    static int maxLimit=2;
    static long windowInMillis = 60000;

    public static int getMaxLimit()
    {
        return maxLimit;
    }

    public static long getWindowInMillis() {
        return windowInMillis;
    }
}
