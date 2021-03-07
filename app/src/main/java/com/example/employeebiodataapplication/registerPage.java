package com.example.employeebiodataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.employeebiodataapplication.db.AppDatabase;
import com.example.employeebiodataapplication.db.DataConverter;
import com.example.employeebiodataapplication.db.User;
import com.example.employeebiodataapplication.db.UserDao;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class registerPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView imageView;
    Bitmap bmpImage;
    UserDao userDao;
    EditText date;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        date = (EditText) findViewById(R.id.editDateOfBirth);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(registerPage.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                date.setText(dayOfMonth + "/"
                                        + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });



        Spinner spinner = (Spinner) findViewById(R.id.editNationality);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        spinner.getSelectedItem().toString();



        imageView = (ImageView) findViewById(R.id.centralImage);
        bmpImage = null;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(imageView);
            }
        });

                final EditText firstName = findViewById(R.id.editFirstName);
                final EditText emailAddress = findViewById(R.id.editEmailAddress);
                final EditText dateOfBirth = findViewById(R.id.editDateOfBirth);
                final EditText department = findViewById(R.id.editDepartment);
                final EditText role = findViewById(R.id.editRole);
                final EditText state = findViewById(R.id.editState);
                final Spinner nationality = findViewById(R.id.editNationality);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

                MaterialButton registerUser = findViewById(R.id.registerUserBtn);
                registerUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if (firstName.getText().toString().isEmpty() || emailAddress.getText().toString().isEmpty() || dateOfBirth.getText().toString().isEmpty()
                            || department.getText().toString().isEmpty() || role.getText().toString().isEmpty()  || state.getText().toString().isEmpty() ||
                                nationality.getAdapter().isEmpty() || bmpImage == null) {
                            Toast.makeText(registerPage.this, "Kindly fill in all information", Toast.LENGTH_SHORT).show();
                        }else {
                        User user = new User();
                            user.setFirstName(firstName.getText().toString());
                            user.setEmailAddress(emailAddress.getText().toString());
                            user.setDate(dateOfBirth.getText().toString());
                            user.setDepartment(department.getText().toString());
                            user.setRole(role.getText().toString());
                            user.setState(state.getText().toString());
                            user.setNationality(nationality.getAdapter().toString());
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


