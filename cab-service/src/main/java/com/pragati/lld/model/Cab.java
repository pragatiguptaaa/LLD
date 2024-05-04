package com.pragati.lld.model;

import lombok.Getter;

@Getter
public class Cab {

    long id;
    String driverName;
    Trip currentTrip;
    Location currentLocation;
    boolean isAvailable;

    public Cab(long id, String driverName, Location currentLocation) {
        this.id = id;
        this.driverName = driverName;
        this.currentTrip = null;
        this.currentLocation = currentLocation;
        this.isAvailable = true;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
