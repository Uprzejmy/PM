package com.uprzejmy.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* //oprogramowanie funkcjonalnosci onClick przycisku z poziomu klasy Activity
        Button switchButton = (Button) findViewById(R.id.switchButton);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentsListActivity(view);
            }
        });
        */
    }

    public void StudentsListActivity(View view)
    {
        Intent intent = new Intent(this, StudentsList.class);
        startActivity(intent);

    }





}
