package com.example.efuabainson.wakeup;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarm_manager;
    TimePicker alarm_time;
    Context context;
    Button setalarm;
    Button turnoff;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context=this;

        alarm_manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarm_time=(TimePicker)findViewById(R.id.clock);
        setalarm=(Button)findViewById(R.id.setalarm);
        turnoff=(Button)findViewById(R.id.turnoff);
        final Calendar calendar=Calendar.getInstance();

        final Intent nextpage=new Intent(this.context,AlarmReceiver.class);

        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String minute_time;
                calendar.set(Calendar.HOUR_OF_DAY,alarm_time.getHour());
                calendar.set(Calendar.HOUR_OF_DAY,alarm_time.getMinute());

                int hour=alarm_time.getHour();
                int minute=alarm_time.getMinute();

                String hour_time=String.valueOf(hour);
                if(minute<10){
                    minute_time="0"+String.valueOf(minute);
                }

                set_alarm_text("Alarm set to "+hour_time+":"+minute_time);
                pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,nextpage,PendingIntent.FLAG_UPDATE_CURRENT );
                alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
            }
        });

        turnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_text("Alarm off");
            }
        });




    }

    public void set_alarm_text(String s){
        Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT ).show();
    }
}
