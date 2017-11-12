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
        switch(intent.getAction())
        {
            case "android.intent.action.ACTION_POWER_CONNECTED":
                Toast.makeText(context, context.getString(R.string.power_connected), Toast.LENGTH_LONG).show();
                break;
            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                Toast.makeText(context, context.getString(R.string.power_disconnected), Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
