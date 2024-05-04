package com.pragati.lld;

import com.pragati.lld.controller.CabController;
import com.pragati.lld.controller.RiderController;
import com.pragati.lld.model.Rider;
import com.pragati.lld.model.Trip;
import com.pragati.lld.service.CabService;
import com.pragati.lld.service.RiderService;
import com.pragati.lld.service.TripService;
import com.pragati.lld.strategy.CabMatchingStrategy;
import com.pragati.lld.strategy.DistancePricingStrategy;
import com.pragati.lld.strategy.PricingStrategy;
import com.pragati.lld.strategy.RandomCabMatchingStrategy;

public class CabServiceMain {
    public static void main(String[] args) {
        CabService cabService= new CabService();
        RiderService riderService = new RiderService();
        CabMatchingStrategy cabMatchingStrategy = new RandomCabMatchingStrategy();
        PricingStrategy pricingStrategy = new DistancePricingStrategy();
        TripService tripService = new TripService(cabService, riderService, cabMatchingStrategy, pricingStrategy);

        CabController cabController = new CabController(cabService, tripService);
        RiderController riderController = new RiderController(riderService, tripService);

        cabController.registerCab("Driver1", 1, 1);
        cabController.registerCab("Driver2", 2, 1);
        cabController.registerCab("Driver3", 10, 10);
        cabController.registerCab("Driver4", 50, 15);
        cabController.registerCab("Driver5", 100, 100);
        cabController.registerCab("Driver6", 11, 10);

        Rider rider1 = riderController.registerRider("Pragati");
        Rider rider2 = riderController.registerRider("Riya");

        Trip trip1 = riderController.bookTrip(rider1.getId(), 5,5, 100, 100);
        System.out.println("Booked trip for rider: "+trip1.getRider().getName()+" cab: "+trip1.getCab().getId()
                +  "Driver name: " +trip1.getCab().getDriverName());
        Trip trip2 = riderController.bookTrip(rider2.getId(), 5,5, 100, 100);
        System.out.println("Booked trip for rider: "+trip2.getRider().getName()+" cab: "+trip2.getCab().getId()
                +  "Driver name: " +trip2.getCab().getDriverName());
    }



}
