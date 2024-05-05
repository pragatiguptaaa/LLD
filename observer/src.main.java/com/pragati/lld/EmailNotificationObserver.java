package com.pragati.lld;

public class EmailNotificationObserver implements  Observer{

    Observable observable;
    int customerId;
    String email;

    public EmailNotificationObserver(Observable observable, int customerId, String email)
    {
        this.observable = observable;
        this.customerId = customerId;
        this.email = email;
    }
    @Override
    public int getObserverId() {
        return this.customerId;
    }

    @Override
    public void update() {
        System.out.println("Sending email to "+customerId+" on email : "+email);
        //send email to customer
    }
}
