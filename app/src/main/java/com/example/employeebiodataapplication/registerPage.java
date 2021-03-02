package com.example.employeebiodataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.employeebiodataapplication.db.AppDatabase;
import com.example.employeebiodataapplication.db.User;
import com.google.android.material.button.MaterialButton;

import java.security.PublicKey;

public class registerPage extends AppCompatActivity {
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        imageView = (ImageView) findViewById(R.id.centralImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });


        final EditText firstName = findViewById(R.id.editFirstName);
        final EditText lastName = findViewById(R.id.editLastName);
        final EditText phoneNumber = findViewById(R.id.editPhoneNumber);
        final EditText emailAddress = findViewById(R.id.editEmailAddress);
        final EditText dateOfBirth = findViewById(R.id.editDateOfBirth);
        final EditText department = findViewById(R.id.editDepartment);
        final EditText role = findViewById(R.id.editRole);
        final EditText homeAddress = findViewById(R.id.editHomeAddress);
        final EditText state = findViewById(R.id.editState);
        final EditText nationality = findViewById(R.id.editNationality);

        MaterialButton registerUser = findViewById(R.id.registerUserBtn);
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(firstName.getText().toString(), lastName.getText().toString(), phoneNumber.getInputType(),
                        emailAddress.getText().toString(), dateOfBirth.getInputType(), department.getText().toString(),
                        role.getText().toString(), homeAddress.getText().toString(), state.getText().toString(), nationality.getText().toString());
            }
        });
    }
    private void registerUser(String firstName, String lastName, int phoneNumber, String emailAddress, int dateOfBirth, String department,
                              String role, String homeAddress, String state, String nationality) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.phoneNumber = phoneNumber;
        user.emailAddress = emailAddress;
        user.dateOfBirth = dateOfBirth;
        user.department = department;
        user.role = role;
        user.homeAddress = homeAddress;
        user.state = state;
        user.nationality =nationality;
        db.userDao().InsertUser(user);

        finish();
    }

    public void open() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

