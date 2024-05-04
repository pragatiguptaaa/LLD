package com.pragati.lld.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Meeting {

    private long meetingId;
    private int from;
    private int to;
    private MeetingStatus meetingStatus;
    private User organizedBy;
    private List<User> invitees;
    private MeetingRoom meetingRoom;

    public Meeting(long meetingId,
             int from,
             int to,
             User organizedBy,
             List<User> invitees,
             MeetingRoom meetingRoom)
    {
        this.meetingId = meetingId;
        this.from = from;
        this.to = to;
        this.organizedBy= organizedBy;
        this.invitees= invitees;
        this.meetingRoom = meetingRoom;
        this.meetingStatus = MeetingStatus.BOOKED;
    }

    public void setOrganizedBy(User organizedBy) {
        this.organizedBy = organizedBy;
    }

    public void setInvitees(List<User> invitees) {
        this.invitees = invitees;
    }

     //add invitees
    //change organizer
}
