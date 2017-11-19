package com.uprzejmy.lab3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    BoundBackgroundService boundService;
    Intent boundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, BackgroundService.class));

        boundServiceIntent = new Intent(this, BoundBackgroundService.class);
        bindService(boundServiceIntent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service)
        {
            BoundBackgroundService.BoundBackgroundServiceBinder binder = (BoundBackgroundService.BoundBackgroundServiceBinder) service;
            boundService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0)
        {
            //empty??
        }
    };

    public void switchActivityAction(View view)
    {
        stopService(boundServiceIntent);
        unbindService(connection);

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void showCounterAction(View view)
    {
        Toast.makeText(this, "" + boundService.getTimeIndicator(), Toast.LENGTH_LONG).show();
    }
}
