package com.example.efuabainson.wakeup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Anne Gitau on 11/25/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("We are in the receiver","Yay!");

        Intent intent_service = new Intent(context,RingtonePlayingService.class);
        context.startService(intent_service);
    }
}
