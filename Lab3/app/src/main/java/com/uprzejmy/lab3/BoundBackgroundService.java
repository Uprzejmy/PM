package com.uprzejmy.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class BoundBackgroundService extends Service
{
    public static int timeIndicator = 0;

    private Timer timer;
    private TimerTask task;
    private Handler handler;
    private IBinder binder = new BoundBackgroundServiceBinder();

    public class BoundBackgroundServiceBinder extends Binder
    {
        BoundBackgroundService getService()
        {
            return BoundBackgroundService.this;
        }
    }

    public void onCreate()
    {
        super.onCreate();

        timer = new Timer();
        handler = new Handler();
        task = new BoundBackgroundServiceNotification(handler, getApplicationContext());
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        Toast.makeText(this, "bound background service has been started", Toast.LENGTH_LONG).show();

        timeIndicator = 0;
        timer.scheduleAtFixedRate(task, 13 * 1000, 13 * 1000);
        Toast.makeText(getApplicationContext(), "Your bound service has been started", Toast.LENGTH_SHORT).show();

        return binder;

    }
}
