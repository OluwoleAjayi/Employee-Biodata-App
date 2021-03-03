package com.example.employeebiodataapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeebiodataapplication.db.User;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.myViewHolder> {
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
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.myViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.tvFirstName.setText(user.getFirstName());
        holder.tvLastName.setText(user.getLastName());
        holder.tvPhoneNumber.setText(user.getPhoneNumber());
        holder.tvEmailAddress.setText(user.getEmailAddress());
        holder.tvDateOfBirth.setText(user.getDateOfBirth());
        holder.tvDepartment.setText(user.getDepartment());
        holder.tvRole.setText(user.getRole());
        holder.tvHomeAddress.setText(user.getHomeAddress());
        holder.tvState.setText(user.getState());
        holder.tvNationality.setText(user.getNationality());


    }

    @Override
    public int getItemCount() { return this.userList.size(); }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView tvImage;
        MaterialTextView tvFirstName;
        MaterialTextView tvLastName;
        MaterialTextView tvPhoneNumber;
        MaterialTextView tvEmailAddress;
        MaterialTextView tvDateOfBirth;
        MaterialTextView tvDepartment;
        MaterialTextView tvRole;
        MaterialTextView tvHomeAddress;
        MaterialTextView tvState;
        MaterialTextView tvNationality;


        public  myViewHolder(View view) {
            super(view);
            tvImage = view.findViewById(R.id.tvImage);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);
            tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
            tvEmailAddress = view.findViewById(R.id.tvEmailAddress);
            tvDateOfBirth = view.findViewById(R.id.tvDateOfBirth);
            tvDepartment = view.findViewById(R.id.tvDepartment);
            tvRole = view.findViewById(R.id.tvRole);
            tvHomeAddress = view.findViewById(R.id.tvHomeAddress);
            tvState = view.findViewById(R.id.tvState);
            tvNationality = view.findViewById(R.id.tvNationality);
    }



    }
}
