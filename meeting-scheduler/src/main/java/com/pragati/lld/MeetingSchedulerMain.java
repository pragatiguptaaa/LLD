package com.pragati.lld;

import com.pragati.lld.model.Calendar;
import com.pragati.lld.model.MeetingRoom;
import com.pragati.lld.model.User;
import com.pragati.lld.service.MeetingRoomBookingStrategy;
import com.pragati.lld.service.MeetingRoomService;
import com.pragati.lld.service.MeetingSchedulerService;
import com.pragati.lld.service.RandomMeetingRoomBookingStrategy;

public class MeetingSchedulerMain {

    public static void main(String[] args) {
        MeetingRoomService meetingRoomService= new MeetingRoomService();
        MeetingRoomBookingStrategy meetingRoomBookingStrategy = new RandomMeetingRoomBookingStrategy();
        MeetingSchedulerService meetingSchedulerService = new MeetingSchedulerService(meetingRoomService, meetingRoomBookingStrategy);

        Calendar calendar1= new Calendar();
        calendar1.addSlot(1, 2);
        calendar1.addSlot(3, 4);
        Calendar calendar2= new Calendar();
        calendar2.addSlot(4, 5);
        calendar2.addSlot(5, 6);
        meetingRoomService.addMeetingRoom(1000L, calendar1);
        meetingRoomService.addMeetingRoom(2000L, calendar2);


        User user1= new User(1, "Pragati", "abc@gmail.com" , 987654321);
        User user2= new User(1, "sanu", "abc@gmail.com" , 987654321);
        meetingSchedulerService.scheduleMeeting(1, 2, user1, null);
        meetingSchedulerService.scheduleMeeting(1, 2, user1, null);
        meetingSchedulerService.scheduleMeeting(1, 2, user2, null);
        meetingSchedulerService.scheduleMeeting(4, 5, user2, null);

    }


}
