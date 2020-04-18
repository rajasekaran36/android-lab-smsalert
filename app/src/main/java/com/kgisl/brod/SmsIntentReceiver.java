package com.kgisl.brod;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.util.Log;
import android.widget.Toast;

import java.util.Observer;

public class SmsIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()=="android.provider.Telephony.SMS_RECEIVED") {
            Toast.makeText(context, "GOT NEW SMS", Toast.LENGTH_LONG).show();
            BroadcastObserver broadcastObserver=BroadcastObserver.getInstance();
            broadcastObserver.triggerObservers();
            Log.d("ob", "Observer Triggered");
        }

    }
}
