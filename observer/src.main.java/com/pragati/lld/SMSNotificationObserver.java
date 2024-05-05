package com.pragati.lld;

public class SMSNotificationObserver implements  Observer{

    Observable observable;
    int customerId;
    Integer phoneNo;

    public SMSNotificationObserver(Observable observable, int customerId,  Integer phoneNo)
    {
        this.observable = observable;
        this.customerId = customerId;
        this.phoneNo = phoneNo;
    }
    @Override
    public int getObserverId() {
        return this.customerId;
    }

    @Override
    public void update() {
        System.out.println("Sending SMS to "+customerId+" on phone No : "+phoneNo);
        //send email to customer
    }
}
