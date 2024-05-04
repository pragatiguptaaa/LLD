package com.pragati.lld.controller;

import com.pragati.lld.model.Cab;
import com.pragati.lld.model.Rider;
import com.pragati.lld.model.Trip;
import com.pragati.lld.service.CabService;
import com.pragati.lld.service.RiderService;
import com.pragati.lld.service.TripService;
import org.springframework.stereotype.Controller;


@Controller
public class CabController {

    private final CabService cabService;
    private final TripService tripService;

    public CabController(CabService cabService, TripService tripService)
    {
        this.cabService = cabService;
        this.tripService = tripService;
    }


    public Cab registerCab(String name, int x, int y)
    {
        return cabService.registerCab(name, x, y);
    }

    public void updateCurrentTrip(Long cabId, Trip trip)
    {
        cabService.updateCurrentTrip(cabId, trip);
    }

    public void endCurrentTrip(Long cabId)
    {
        tripService.endCurrentTrip(cabId);
    }

    public void updateCabLocation(Long cabId, int srcX, int srcY)
    {
        cabService.updateCabLocation(cabId, srcX,  srcY);
    }

    public void updateCabAvailability(Long cabId, boolean isAvailable)
    {
        cabService.updateCabAvailability(cabId, isAvailable);
    }


}
