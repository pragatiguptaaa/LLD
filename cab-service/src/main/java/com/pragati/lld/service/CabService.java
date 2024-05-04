package com.pragati.lld.service;

import com.pragati.lld.model.Cab;
import com.pragati.lld.model.Location;
import com.pragati.lld.model.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabService {

    Map<Long, Cab> cabs;

    public CabService ()
    {
        this.cabs = new HashMap<>();
    }

    public Cab registerCab(String driverName, int x, int y)
    {
        long id= cabs.size()+1;
        Cab cab = new Cab(id, driverName, new Location(x, y));
        cabs.put(id, cab);
        return cab;
    }

    public Cab getCab(long id)
    {
        return cabs.get(id);
    }
    public List<Cab> getCabs(int srcX, int srcY)
    {
        return new ArrayList<>(cabs.values()); //return within certain radius
    }

    public void updateCurrentTrip(Long cabId, Trip trip)
    {
        Cab cab = cabs.get(cabId);
        cab.setCurrentTrip(trip);
    }

    public void updateCabLocation(Long cabId, int srcX, int srcY)
    {
        Cab cab = cabs.get(cabId);
        cab.setCurrentLocation(new Location(srcX, srcY));
    }

    public void updateCabAvailability(Long cabId, boolean isAvailable)
    {
        Cab cab = cabs.get(cabId);
        cab.setAvailable(isAvailable);
    }

}
