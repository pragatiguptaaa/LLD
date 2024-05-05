package com.pragati.lld;

public class Main {

    public static void main(String[] args) {
        Observable iphoneStockObservable= new IphoneStockObservable();
        Observer iphoneEmailNotificationObserver1 = new EmailNotificationObserver(iphoneStockObservable, 1, "1.gmail.com");
        Observer iphoneEmailNotificationObserver2 = new EmailNotificationObserver(iphoneStockObservable, 2, "2.gmail.com");
        Observer iphoneSMSNotificationObserver3 = new SMSNotificationObserver(iphoneStockObservable, 3, 123456789);
        iphoneStockObservable.addObserver(iphoneEmailNotificationObserver1);
        iphoneStockObservable.addObserver(iphoneEmailNotificationObserver2);
        iphoneStockObservable.addObserver(iphoneSMSNotificationObserver3);
        iphoneStockObservable.setData(5);
        iphoneStockObservable.setData(50);

        Observable androidStockObservable= new AndroidStockObservable();
        Observer androidEmailNotificationObserver4 = new EmailNotificationObserver(iphoneStockObservable, 4, "4.gmail.com");
        Observer androidSMSNotificationObserver5 = new SMSNotificationObserver(iphoneStockObservable, 5, 111111111);
        androidStockObservable.addObserver(androidEmailNotificationObserver4);
        androidStockObservable.addObserver(androidSMSNotificationObserver5);
        androidStockObservable.setData(10);
        androidStockObservable.setData(0);
        androidStockObservable.setData(100);
    }
}
