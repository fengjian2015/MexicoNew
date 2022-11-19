package com.fly.ayudaconfiable.observer;

import android.content.Intent;

import com.fly.ayudaconfiable.utils.LogUtils;

import java.util.concurrent.CopyOnWriteArrayList;

public class ObserverManager implements ObserverSubject {

    private static ObserverManager manager;
    private static final CopyOnWriteArrayList<ItemObserver> observerList;

    static {
        observerList = new CopyOnWriteArrayList<>();
        observerList.clear();
    }

    private ObserverManager() {
    }

    public synchronized static ObserverManager getManager() {
        if (null == manager) {
            manager = new ObserverManager();
        }
        return manager;
    }

    @Override
    public void registerObserver(ItemObserver observer) {
        LogUtils.i("注册当前ItemObserver");
        if (null != observer) {
            if (null != observerList) {
                if (!observerList.contains(observer)) {
                    observerList.add(observer);
                }
            }
        }
    }

    @Override
    public void sendNotify(Intent observerIntent) {
        LogUtils.i("发送当前ItemObserver");
        if (null != observerList && observerList.size() > 0) {
            for (ItemObserver itemObserver : observerList) {
                itemObserver.receiveNotify(observerIntent);
            }
        }
    }

    @Override
    public void unRegisterObserver(ItemObserver observer) {
        LogUtils.i("释放当前ItemObserver");
        if (null != observer) {
            if (null != observerList && observerList.size() > 0) {
                if (observerList.indexOf(observer) >= 0) {
                    observerList.remove(observer);
                }
            }
        }
    }
}
