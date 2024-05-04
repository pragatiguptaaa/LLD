package com.pragati.lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trip {

    long id;
    Location src;
    Location dest;
    Rider rider;
    Cab cab;
    TripStatus tripStatus;
    double price;

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
}
