package com.pragati.lld.strategy;

import com.pragati.lld.model.Cab;

import java.util.List;

public interface CabMatchingStrategy {

    Cab getCab(List<Cab> cabs, int srcx, int srcy, int destx, int desty);
}
