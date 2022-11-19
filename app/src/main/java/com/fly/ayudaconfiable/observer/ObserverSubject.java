package com.fly.ayudaconfiable.observer;

import android.content.Intent;

public interface ObserverSubject {

    void registerObserver(ItemObserver observer);

    void sendNotify(Intent observerIntent);

    void unRegisterObserver(ItemObserver observer);
}
