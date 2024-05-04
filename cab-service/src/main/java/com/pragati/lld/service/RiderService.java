package com.pragati.lld.service;

import com.pragati.lld.model.Rider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RiderService {

    Map<Long, Rider> riders;

    public RiderService()
    {
        this.riders = new HashMap<>();
    }

    public Rider registerRider(String name)
    {
      long id= riders.size()+1;
      Rider rider = new Rider(id, name);
      riders.put(id, rider);
      return rider;
    }

    public Rider getRider(long riderId)
    {
        return riders.get(riderId);  //TODO: add valid checks
    }
}
