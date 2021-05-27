package com.example.employeebiodataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.employeebiodataapplication.databinding.ActivityRegisterPageBinding;
import com.example.employeebiodataapplication.db.AppDatabase;
import com.example.employeebiodataapplication.db.DataConverter;
import com.example.employeebiodataapplication.db.User;
import com.example.employeebiodataapplication.db.UserDao;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class registerPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Employee biodata;
    ActivityRegisterPageBinding activityRegisterPageBinding;
    EditText date;

    ImageView imageView;
    Bitmap bmpImage;
    UserDao userDao;
    DatePickerDialog datePickerDialog;
    private NotificationManager notificationManager;
    private int notificationID = 100;
    private int numMessages = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_page);

        activityRegisterPageBinding.setEmployee(    biodata);

        EditText dob = activityRegisterPageBinding.editDateOfBirth;
        dob.setOnClickListener(new View.OnClickListener() {
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
                                dob.setText(dayOfMonth + "/"
                                        + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        activityRegisterPageBinding.editNationality.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_dropdown_item);
        activityRegisterPageBinding.editNationality.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        activityRegisterPageBinding.editNationality.getSelectedItem().toString();

        imageView = (ImageView) activityRegisterPageBinding.centralImage;
        bmpImage = null;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(imageView);
            }
        });

        EditText firstName = activityRegisterPageBinding.editFirstName;
        EditText emailAddress = activityRegisterPageBinding.editEmailAddress;
        EditText dateOfBirth = activityRegisterPageBinding.editDateOfBirth;
        EditText department = activityRegisterPageBinding.editDepartment;
        EditText role = activityRegisterPageBinding.editRole;
        EditText state = activityRegisterPageBinding.editState;
        Spinner nationality = activityRegisterPageBinding.editNationality;

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

                activityRegisterPageBinding.registerUserBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent registerUser = new Intent(registerPage.this, databaseActivity.class);
                        startActivity(registerUser);
                        }
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


