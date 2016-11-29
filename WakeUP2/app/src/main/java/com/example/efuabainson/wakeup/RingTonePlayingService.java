package com.example.efuabainson.wakeup;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by efuabainson on 11/25/16.
 */

public class RingTonePlayingService extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    boolean isRunning;
    int startId;

    public IBinder onBind(Intent intent)
    {
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.e("in the service","Start the command");

        String state=intent.getExtras().getString("extra");
        Log.e("ringtone state extra: ",state);

//        NotificationManager notify_manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//        Intent intent_main_activity=new Intent(this.getApplicationContext(),MainActivity.class);
//        PendingIntent pending_intent_main_activity= PendingIntent.getActivity(this,0,intent_main_activity,0);
//
//        Notification notification_popup=new Notification.Builder(this)
//                .setContentTitle("An alarm is going off")
//                .setContentText("Click me!")
//                .setContentIntent(pending_intent_main_activity)
//                .setAutoCancel(true)
//                .build();
//
//        notify_manager.notify(0,notification_popup );

        assert state!=null;
        switch (state){
            case "alarm on": startId=0;
                break;
            case "alarm off": startId=1;
                break;
            default: startId=1;
                break;
        }

        if(!this.isRunning && startId==0){
            mediaPlayer=MediaPlayer.create(this, R.raw.alarm);
            mediaPlayer.start();
            Log.e("is ringing",""+ startId);
            this.isRunning=true;
            this.startId=0;

        }else if(this.isRunning && startId==0){

            this.isRunning=false;
            this.startId=1;
        }
        else if(this.isRunning && startId==1){
            mediaPlayer.stop();
            mediaPlayer.reset();
            this.isRunning=true;
            this.startId=0;
        }
        else{

        }
        return START_NOT_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        this.isRunning=false;

    }
}
