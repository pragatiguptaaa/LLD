package com.pragati.lld.service;

import com.pragati.lld.model.MeetingRoom;
import com.pragati.lld.model.Slot;

import java.util.List;

public class RandomMeetingRoomBookingStrategy implements  MeetingRoomBookingStrategy{
    @Override
    public MeetingRoom getMeetingRoom(List<MeetingRoom> meetingRooms, int from, int to) {
        for(MeetingRoom meetingRoom: meetingRooms)
        {
            Slot slot = meetingRoom.getCalendar().getFreeSlot(from, to);
            if(slot != null)
                return meetingRoom;
        }
        return null;
    }
}
