package com.example.efuabainson.wakeup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by efuabainson on 11/25/16.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("We have received","yaay");
        String get_string=intent.getExtras().getString("extra");
        Log.e("What is your key?",get_string);

        Intent service_intent=new Intent(context,RingTonePlayingService.class);
        
        service_intent.putExtra("extra",get_string);
        context.startService(service_intent);
    }
}
