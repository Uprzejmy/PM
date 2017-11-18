package com.uprzejmy.lab3;

import android.content.Context;
import android.widget.Toast;

import java.util.TimerTask;
import android.os.Handler;

/**
 * Created by Uprzejmy on 18.11.2017.
 */

public class BackgroundServiceNotification extends TimerTask
{
    private Context context;
    private Handler handler;

    public BackgroundServiceNotification(Handler handler, Context context)
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
                Toast.makeText(context, "background service is still working", Toast.LENGTH_LONG).show();
            }
        });
    }
}
