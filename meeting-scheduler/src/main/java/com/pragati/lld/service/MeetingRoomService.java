package com.pragati.lld.service;

import com.pragati.lld.model.Calendar;
import com.pragati.lld.model.MeetingRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomService {

    private Map<Long, MeetingRoom> meetingRooms;

    public MeetingRoomService()
    {
        meetingRooms = new HashMap<>();
    }

    public MeetingRoom addMeetingRoom(Long meetingRoomId, Calendar calendar)
    {
        MeetingRoom meetingRoom = new MeetingRoom(meetingRoomId, calendar);
        meetingRooms.put(meetingRoomId, meetingRoom);
        return meetingRoom;
    }

    //removeMeetingRoom

    public List<MeetingRoom> getMeetingRooms()
    {
        return new ArrayList<>(meetingRooms.values());
    }
}
