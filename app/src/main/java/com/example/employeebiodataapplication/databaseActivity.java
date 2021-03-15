package com.example.employeebiodataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.employeebiodataapplication.databinding.ActivityDatabaseBinding;
import com.example.employeebiodataapplication.db.AppDatabase;
import com.example.employeebiodataapplication.db.User;

import java.util.List;

public class databaseActivity extends AppCompatActivity {
    ActivityDatabaseBinding activityDatabaseBinding;

    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDatabaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_database);

        initRecyclerView();

        loadUserList();

    }

    private void initRecyclerView(){
        activityDatabaseBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        activityDatabaseBinding.recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);

        activityDatabaseBinding.recyclerView.setAdapter(userListAdapter);
    }
    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}