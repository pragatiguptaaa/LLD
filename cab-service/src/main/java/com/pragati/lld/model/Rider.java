package com.pragati.lld.model;

import lombok.Getter;

@Getter
public class Rider {

    long id;
    String name;

    public Rider(long id, String name)
    {
        this.name = name;
        this.id = id;
    }
}
