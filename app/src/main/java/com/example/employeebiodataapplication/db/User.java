package com.example.employeebiodataapplication.db;

import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "Image")
    public int image;

    @ColumnInfo(name = "First Name")
    public String firstName;

    @ColumnInfo(name = "Last Name")
    public String lastName;

    @ColumnInfo(name = "Phone Number")
    public int phoneNumber;

    @ColumnInfo(name = "Email")
    public String emailAddress;

    @ColumnInfo(name = "Date of Birth")
    public int dateOfBirth;

    @ColumnInfo(name = "Department")
    public String department;

    @ColumnInfo(name = "Role")
    public String role;

    @ColumnInfo(name = "Home Address")
    public String homeAddress;

    @ColumnInfo(name = "State")
    public String state;

    @ColumnInfo(name = "Nationality")
    public String nationality;
}
