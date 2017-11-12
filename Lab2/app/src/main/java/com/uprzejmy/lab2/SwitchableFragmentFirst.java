package com.uprzejmy.lab2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SwitchableFragmentFirst extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_switchable_first, container, false);

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
        EditText form = view.findViewById(R.id.form_name);

        form.setText(preferences.getString("name", form.getText().toString()));
    }

    private void savePreferences()
    {
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        EditText form = getActivity().findViewById(R.id.form_name);

        editor.putString("name", form.getText().toString());
        editor.commit();
    }
}
