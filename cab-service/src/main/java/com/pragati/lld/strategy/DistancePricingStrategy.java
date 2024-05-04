package com.pragati.lld.strategy;

import com.pragati.lld.model.Cab;
import com.pragati.lld.model.Rider;
import org.springframework.stereotype.Component;

@Component
public class DistancePricingStrategy implements PricingStrategy{

    public double getPrice(Cab cab, Rider rider, int srcx, int srcy, int destx, int desty)
    {
        double price = Math.pow((srcx-destx)*(srcx-destx)+(srcy-desty)*(srcy-desty), 0.5);
        return price;
    }
}
