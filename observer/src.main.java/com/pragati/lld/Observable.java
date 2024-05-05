package com.pragati.lld;

public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    int getData();
    void setData(int data);
    void notifyAllObservers();

}
