package com.example.employeebiodataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.employeebiodataapplication.db.AppDatabase;
import com.example.employeebiodataapplication.db.DataConverter;
import com.example.employeebiodataapplication.db.User;
import com.example.employeebiodataapplication.db.UserDao;
import com.google.android.material.button.MaterialButton;

import java.util.Date;

public class registerPage extends AppCompatActivity {
    ImageView imageView;
    Bitmap bmpImage;
    UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        imageView = (ImageView) findViewById(R.id.centralImage);
        bmpImage = null;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(imageView);
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

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

                MaterialButton registerUser = findViewById(R.id.registerUserBtn);
                registerUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if (firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty() ||
                                emailAddress.getText().toString().isEmpty() || dateOfBirth.getText().toString().isEmpty() || department.getText().toString().isEmpty() ||
                                role.getText().toString().isEmpty() || homeAddress.getText().toString().isEmpty() || state.getText().toString().isEmpty() ||
                                nationality.getText().toString().isEmpty() || bmpImage == null) {
                            Toast.makeText(registerPage.this, "Kindly fill in all information", Toast.LENGTH_SHORT).show();
                        }else {
                        User user = new User();
                            user.setFirstName(firstName.getText().toString());
                            user.setLastName(lastName.getText().toString());
                            user.setPhoneNumber(phoneNumber.getText().toString());
                            user.setEmailAddress(emailAddress.getText().toString());
                        //    try {
                        //        user.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth.getText().toString()));
                        //    } catch (ParseException e) {
                        //        e.printStackTrace();
                        //    }
                            user.setDepartment(department.getText().toString());
                            user.setRole(role.getText().toString());
                            user.setHomeAddress(homeAddress.getText().toString());
                            user.setState(state.getText().toString());
                            user.setNationality(nationality.getText().toString());
                            user.setImage(DataConverter.convertImage(bmpImage));

                            db.userDao().InsertUser(user);
                        }



                        Intent registerUser = new Intent(registerPage.this, databaseActivity.class);
                        startActivity(registerUser);
                    }
                });
            }



         final int CAMERA_INTENT = 51;

            public void takePicture (View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_INTENT);
        }
         }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_INTENT:
              //  if (requestCode == Activity.RESULT_OK) {
                  bmpImage = (Bitmap ) data.getExtras().get("data");
                    if (bmpImage != null) {
                       imageView.setImageBitmap(bmpImage);
                    }

              //  } else {
              //      Toast.makeText(this, "Result not okay", Toast.LENGTH_SHORT).show();
             //   }
                break;
        }
    }

}


