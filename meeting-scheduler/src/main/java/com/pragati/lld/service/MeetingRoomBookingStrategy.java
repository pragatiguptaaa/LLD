package com.pragati.lld.service;

import com.pragati.lld.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomBookingStrategy {

    MeetingRoom getMeetingRoom(List<MeetingRoom> meetingRooms, int from, int to);
}
