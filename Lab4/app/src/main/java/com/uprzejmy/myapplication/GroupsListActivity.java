package com.uprzejmy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.uprzejmy.myapplication.Model.Database.DataManager;
import com.uprzejmy.myapplication.Model.Database.IDataManager;
import com.uprzejmy.myapplication.Model.Entity.Group;

import java.util.List;

public class GroupsListActivity extends AppCompatActivity
{
    List<Group> groups;
    ArrayAdapter groupsListAdapter;
    ArrayAdapter groupsStudentsListAdapter;
    ListView groupsListView;
    ListView groupsStudentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);

        IDataManager dataManager = DataManager.getDataManager(this);

        groups = dataManager.getAllGroups();
        groupsListView = findViewById(R.id.groupsListView);

        groupsListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groups);
        groupsListView.setAdapter(groupsListAdapter);

        configureListeners();
    }

    private void deleteGroup(int position)
    {
        IDataManager dataManager = DataManager.getDataManager(this);

        dataManager.removeGroup(groups.get(position));
        groups.remove(position);

        groupsListAdapter.notifyDataSetChanged();
    }


    private void showGroupsStudents(int position)
    {
        IDataManager dataManager = DataManager.getDataManager(this);

        Group group = dataManager.getGroupWithStudents(groups.get(position));

        groupsStudentsListView = findViewById(R.id.groupsListView);

        groupsStudentsListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, group.getStudents());
        groupsStudentsListView.setAdapter(groupsStudentsListAdapter);
    }


    private void configureListeners()
    {
        groupsListView.setOnItemLongClickListener(
                (arg0, arg1, position, arg3) ->
                {
                    deleteGroup(position);

                    return true;
                });


        groupsListView.setOnItemClickListener(
                (arg0, arg1, position, arg3) ->
                {
                    showGroupsStudents(position);
                });

    }
}
