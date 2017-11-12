package com.uprzejmy.lab2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SwitchableFragmentSecond extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_switchable_second, container, false);

        readPreferences(view);

        return view;
    }

    @Override
    public void onPause()
    {
        super.onPause();

        savePreferences();
    }

    private void readPreferences(View view)
    {
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        EditText form = view.findViewById(R.id.form_surname);

        form.setText(preferences.getString("surname", "Surname"));
    }

    private void savePreferences()
    {
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        EditText form = getActivity().findViewById(R.id.form_surname);

        editor.putString("surname", form.getText().toString());
        editor.commit();
    }

}
