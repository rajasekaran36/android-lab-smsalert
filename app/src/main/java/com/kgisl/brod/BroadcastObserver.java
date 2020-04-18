package com.kgisl.brod;

import android.util.Log;

import java.io.BufferedReader;
import java.util.Observable;

public class BroadcastObserver extends Observable {
    public static BroadcastObserver broadcastObserver = new BroadcastObserver();

    public static BroadcastObserver getInstance(){
        return broadcastObserver;
    }
    public void triggerObservers() {
        setChanged();
        Log.d("ob", "setChanged");

        notifyObservers();
        Log.d("ob", "notifyObservers");
    }
}
