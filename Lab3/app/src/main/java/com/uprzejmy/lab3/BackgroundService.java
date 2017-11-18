package com.uprzejmy.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Uprzejmy on 13.11.2017.
 */

public class BackgroundService extends Service
{
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;

    public void onCreate()
    {
        super.onCreate();

        timer = new Timer();
        handler = new Handler();
        timerTask = new BackgroundServiceNotification(handler, getApplicationContext());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "background service has been started", Toast.LENGTH_LONG).show();

        timer.scheduleAtFixedRate(timerTask, 3 * 1000, 8 * 1000);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "background service has been stopped", Toast.LENGTH_LONG).show();

        if(timerTask != null)
        {
            timerTask.cancel();
            timer.purge();
        }

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
