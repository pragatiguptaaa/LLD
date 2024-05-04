package com.pragati.lld.strategy;

import com.pragati.lld.model.Cab;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomCabMatchingStrategy implements  CabMatchingStrategy{

    @Override
    public Cab getCab(List<Cab> cabs, int srcx, int srcy, int destx, int desty) {
        if(cabs ==null)
            return null;

        for(Cab cab: cabs)
        {
            if(cab.getCurrentTrip() == null)
                return cab;
        }

        return null;
    }
}
