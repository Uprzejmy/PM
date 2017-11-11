package com.uprzejmy.lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by Uprzejmy on 04.11.2017.
 */

public class PowerConnectionReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        int current = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int max = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float level = (float)current / (float)max;

        Toast.makeText(context, "current: " + current + "max: " + max , Toast.LENGTH_LONG).show();
    }
}
