package com.pragati.lld;

import java.util.HashMap;
import java.util.Map;

public class IphoneStockObservable implements  Observable{

    int quantity;
    Map<Integer, Observer> iphoneObservers;

    public IphoneStockObservable()
    {
        quantity=0;
        iphoneObservers = new HashMap<>();
    }
    @Override
    public void addObserver(Observer observer) {
        iphoneObservers.put(observer.getObserverId(), observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        iphoneObservers.remove(observer.getObserverId());
    }

    @Override
    public int getData() {
        return this.quantity;
    }

    @Override
    public void setData(int data) {


        if(this.quantity==0) {
            System.out.println("Updating Iphone stock from 0 to " + data);
            notifyAllObservers();;
        }
        this.quantity = data;
    }

    @Override
    public void notifyAllObservers() {
        for(Map.Entry<Integer, Observer> observerEntry: iphoneObservers.entrySet())
        {
            observerEntry.getValue().update();
        }
    }
}
