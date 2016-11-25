package com.example.efuabainson.wakeup;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Anne Gitau on 11/25/2016.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this,"on destroy called",Toast.LENGTH_SHORT).show();
    }
}
