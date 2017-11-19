package com.uprzejmy.lab3;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.TimerTask;

/**
 * Created by Uprzejmy on 18.11.2017.
 */

public class BoundBackgroundServiceNotification extends TimerTask
{
    private Context context;
    private Handler handler;

    public BoundBackgroundServiceNotification(Handler handler, Context context)
    {
        this.handler = handler;
        this.context = context;
    }

    @Override
    public void run()
    {
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(context, "bound background service is still working", Toast.LENGTH_LONG).show();
                BoundBackgroundService.timeIndicator += 13;
            }
        });
    }
}
