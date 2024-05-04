package com.pragati.lld.strategy;

import com.pragati.lld.model.Cab;
import com.pragati.lld.model.Rider;

public interface PricingStrategy {

    double getPrice(Cab cab, Rider rider, int srcx, int srcy, int destx, int desty);
}
