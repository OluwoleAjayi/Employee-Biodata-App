package com.example.employeebiodataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MaterialButton registerAllBtn = findViewById(R.id.registerNewEmployee);
        registerAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent registerPageInt = new Intent(RegisterActivity.this, registerPage.class);
               startActivity(registerPageInt);
            }
        });

        MaterialButton viewAllBtn = findViewById(R.id.viewAllEmployee);
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent viewAllIntent = new Intent(RegisterActivity.this, databaseActivity.class);
               startActivity(viewAllIntent);
            }
        });
    }
}









