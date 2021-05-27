package com.example.employeebiodataapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeebiodataapplication.databinding.RecyclerRowBinding;
import com.example.employeebiodataapplication.db.DataConverter;
import com.example.employeebiodataapplication.db.User;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.myViewHolder> {
    RecyclerRowBinding recyclerRowBinding;


    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public UserListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recyclerRowBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recycler_row, parent, false);



        return new myViewHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.myViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.tvImage.setImageBitmap(DataConverter.convertByteArray(user.getImage()));
        holder.tvFirstName.setText("First Name: " + user.getFirstName());
        holder.tvEmailAddress.setText("Email Address: " + user.getEmailAddress());
        holder.tvDateOfBirth.setText("Date of Birth: " + user.getDate());
        holder.tvDepartment.setText("Department: " + user.getDepartment());
        holder.tvRole.setText("Role: " + user.getRole());
        holder.tvState.setText("State: " + user.getState());
        holder.tvNationality.setText("Country: " + user.getNationality());


    }

    @Override
    public int getItemCount() { return this.userList.size(); }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView tvImage;
        MaterialTextView tvFirstName;
        MaterialTextView tvEmailAddress;
        MaterialTextView tvDateOfBirth;
        MaterialTextView tvDepartment;
        MaterialTextView tvRole;
        MaterialTextView tvState;
        MaterialTextView tvNationality;


        public  myViewHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            tvImage = recyclerRowBinding.tvImage;
            tvFirstName = recyclerRowBinding.tvFirstName;
            tvEmailAddress = recyclerRowBinding.tvEmailAddress;
            tvDateOfBirth = recyclerRowBinding.tvDateOfBirth;
            tvDepartment = recyclerRowBinding.tvDepartment;
            tvRole = recyclerRowBinding.tvRole;
            tvState = recyclerRowBinding.tvState;
            tvNationality = recyclerRowBinding.tvNationality;
    }



    }
}
