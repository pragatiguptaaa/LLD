package com.pragati.lld.model;

import lombok.Getter;

@Getter
public class Slot {

    private int from;
    private int to;
    private boolean isFree;

    public Slot(int from, int to)
    {
        this.from= from;
        this.to= to;
        this.isFree= true;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
