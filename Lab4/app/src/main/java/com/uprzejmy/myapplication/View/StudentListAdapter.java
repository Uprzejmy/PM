package com.uprzejmy.myapplication.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.uprzejmy.myapplication.Model.Entity.Student;
import com.uprzejmy.myapplication.R;

import java.util.List;

/**
 * Created by Uprzejmy on 26.11.2017.
 */

public class StudentListAdapter extends BaseAdapter
{
    Context context;
    List<Student> data;
    private static LayoutInflater inflater = null;

    public StudentListAdapter(Context context, List<Student> data)
    {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        if(view == null)
        {
            view = inflater.inflate(R.layout.student_row, null);
        }

        TextView text = view.findViewById(R.id.student_text);
        text.setText(data.get(position).toString());

        return view;
    }
}
