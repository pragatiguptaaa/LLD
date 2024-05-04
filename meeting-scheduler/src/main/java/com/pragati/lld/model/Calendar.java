package com.pragati.lld.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Calendar {

    List<Slot> slots;
    List<Meeting> meetings;

    public Calendar()
    {
        this.slots = new ArrayList<>();
        this.meetings = new ArrayList<>();
    }

    //add slot
    public void addSlot(int from, int to)
    {
        Slot slot = new Slot(from, to);
        slots.add(slot);
    }

    //book slot
    public Slot getFreeSlot(int from, int to)
    {
        for(Slot slot: slots)
        {
           if(slot.getFrom()==from &&  slot.getTo()== slot.getTo() &&  slot.isFree())
           {
               return slot;
           }
        }
        return null;
    }


    public void addMeeting(Meeting meeting)
    {
        for(Slot slot: slots)
        {
            if(slot.getFrom()== meeting.getFrom() &&  slot.getTo()== meeting.getTo() &&  slot.isFree())
            {
                slot.setFree(false);
                meetings.add(meeting);
            }
        }
    }
}
