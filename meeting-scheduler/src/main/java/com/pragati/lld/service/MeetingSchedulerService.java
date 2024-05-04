package com.pragati.lld.service;

import com.pragati.lld.model.*;

import java.util.ArrayList;
import java.util.List;

public class MeetingSchedulerService {

    private List<Meeting> meetings;
    private final MeetingRoomService meetingRoomService;
    private MeetingRoomBookingStrategy meetingRoomBookingStrategy;

    public MeetingSchedulerService(MeetingRoomService meetingRoomService,
                                   MeetingRoomBookingStrategy meetingRoomBookingStrategy)
    {
        meetings = new ArrayList<>();
        this.meetingRoomService = meetingRoomService;
        this.meetingRoomBookingStrategy = meetingRoomBookingStrategy;
    }

    public void scheduleMeeting(int from,
                           int to,
                           User organizedBy,
                           List<User> invitees)
    {
        MeetingRoom meetingRoom = meetingRoomBookingStrategy.getMeetingRoom(meetingRoomService.getMeetingRooms(), from, to);
        if(meetingRoom == null)
        {
            System.out.println("Cannot find any room for following request.Meeting from: "
                    + from+" to: "+to);
            return;
        }
        Meeting meeting = new Meeting(meetings.size()+1, from, to,
                organizedBy, invitees, meetingRoom);
        meetingRoom.getCalendar().addMeeting(meeting);
        meetings.add(meeting);
        System.out.println("Meeting from " + from+" to"+to+" is scheduled in meeting room: "+meetingRoom.getId());
    }

}
