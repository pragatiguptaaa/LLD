package com.pragati.lld.model;

import lombok.Getter;

@Getter
public class MeetingRoom {

    private Long id;
    private Calendar calendar;

    public MeetingRoom(Long id, Calendar calendar)
    {
        this.id = id;
        this.calendar= calendar;
    }
}
