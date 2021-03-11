package com.example.employeebiodataapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeebiodataapplication.databinding.ActivityRegisterBinding;
import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding activityRegisterBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);





        activityRegisterBinding.registerNewEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPageInt = new Intent(RegisterActivity.this, registerPage.class);
                startActivity(registerPageInt);
            }
        });

        activityRegisterBinding.viewAllEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAllIntent = new Intent(RegisterActivity.this, databaseActivity.class);
                startActivity(viewAllIntent);
            }
        });



    }
}









