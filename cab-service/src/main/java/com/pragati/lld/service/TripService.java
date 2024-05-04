package com.pragati.lld.service;

import com.pragati.lld.model.*;
import com.pragati.lld.strategy.CabMatchingStrategy;
import com.pragati.lld.strategy.PricingStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TripService {

    private final Map<Long, Trip> trips;
    private final CabService cabService;
    private final RiderService riderService;
    private final CabMatchingStrategy cabMatchingStrategy;

    private final PricingStrategy pricingStrategy;

    public TripService(CabService cabService, RiderService riderService, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
        trips = new HashMap<>();
        this.cabService = cabService;
        this.riderService = riderService;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Trip bookTrip(long riderId, int srcX, int srcY, int destX, int destY) {
        List<Cab> cabs = cabService.getCabs(srcX, srcY);
        Rider rider = riderService.getRider(riderId);
        Cab matchedCab = cabMatchingStrategy.getCab(cabs, srcX, srcY, destX, destY);
        double price = pricingStrategy.getPrice(matchedCab, rider, srcX, srcY, destX, destY);

        Trip trip = new Trip(trips.size() + 1, new Location(srcX, srcY), new Location(destX, destY),
                rider, matchedCab, TripStatus.INPROGRESS, price);
        trips.put(trip.getId(), trip);
        cabService.updateCurrentTrip(matchedCab.getId(), trip);
        return trip;
    }

       public void endCurrentTrip(Long cabId) {
        Trip trip = cabService.getCab(cabId).getCurrentTrip();
        trip.setTripStatus(TripStatus.COMPLETED);
        cabService.updateCurrentTrip(cabId, null);
    }
}
