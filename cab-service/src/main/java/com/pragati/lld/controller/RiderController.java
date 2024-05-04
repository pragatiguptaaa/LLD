package com.pragati.lld.controller;

import com.pragati.lld.model.Rider;
import com.pragati.lld.model.Trip;
import com.pragati.lld.service.RiderService;
import com.pragati.lld.service.TripService;
import org.springframework.stereotype.Controller;


@Controller
public class RiderController {

    private final RiderService riderService;
    private final TripService tripService;

    public RiderController(RiderService riderService, TripService tripService)
    {
        this.riderService = riderService;
        this.tripService = tripService;
    }


    public Rider registerRider(String name)
    {
        return riderService.registerRider(name);
    }

    public Trip bookTrip(long riderId, int srcX, int srcY, int destX, int destY)
    {
       return tripService.bookTrip(riderId, srcX,  srcY,  destX,  destY);
    }
}
