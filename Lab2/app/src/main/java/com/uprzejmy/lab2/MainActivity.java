package com.uprzejmy.lab2;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        switch(getResources().getConfiguration().orientation)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main_portrait);
                break;
            default:
                setContentView(R.layout.activity_main_portrait);
                break;
        }
    }

    public void switchFragmentToFirst(View view)
    {
        Fragment fragment = new SwitchableFragmentFirst();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }

    public void switchFragmentToSecond(View view)
    {
        Fragment fragment = new SwitchableFragmentSecond();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }
}
