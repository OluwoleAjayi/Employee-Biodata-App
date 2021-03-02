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
        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);
        holder.tvPhoneNumber.setText(this.userList.get(position).phoneNumber);
        holder.tvEmailAddress.setText(this.userList.get(position).emailAddress);
        holder.tvDateOfBirth.setText(this.userList.get(position).dateOfBirth);
        holder.tvDepartment.setText(this.userList.get(position).department);
        holder.tvRole.setText(this.userList.get(position).role);
        holder.tvHomeAddress.setText(this.userList.get(position).homeAddress);
        holder.tvState.setText(this.userList.get(position).state);
        holder.tvNationality.setText(userList.);


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

        public ImageView getTvImage() {
            return tvImage;
        }

        public void setTvImage(ImageView tvImage) {
            this.tvImage = tvImage;
        }

        public MaterialTextView getTvFirstName() {
            return tvFirstName;
        }

        public void setTvFirstName(MaterialTextView tvFirstName) {
            this.tvFirstName = tvFirstName;
        }

        public MaterialTextView getTvLastName() {
            return tvLastName;
        }

        public void setTvLastName(MaterialTextView tvLastName) {
            this.tvLastName = tvLastName;
        }

        public MaterialTextView getTvPhoneNumber() {
            return tvPhoneNumber;
        }

        public void setTvPhoneNumber(MaterialTextView tvPhoneNumber) {
            this.tvPhoneNumber = tvPhoneNumber;
        }

        public MaterialTextView getTvEmailAddress() {
            return tvEmailAddress;
        }

        public void setTvEmailAddress(MaterialTextView tvEmailAddress) {
            this.tvEmailAddress = tvEmailAddress;
        }

        public MaterialTextView getTvDateOfBirth() {
            return tvDateOfBirth;
        }

        public void setTvDateOfBirth(MaterialTextView tvDateOfBirth) {
            this.tvDateOfBirth = tvDateOfBirth;
        }

        public MaterialTextView getTvDepartment() {
            return tvDepartment;
        }

        public void setTvDepartment(MaterialTextView tvDepartment) {
            this.tvDepartment = tvDepartment;
        }

        public MaterialTextView getTvRole() {
            return tvRole;
        }

        public void setTvRole(MaterialTextView tvRole) {
            this.tvRole = tvRole;
        }

        public MaterialTextView getTvHomeAddress() {
            return tvHomeAddress;
        }

        public void setTvHomeAddress(MaterialTextView tvHomeAddress) {
            this.tvHomeAddress = tvHomeAddress;
        }

        public MaterialTextView getTvState() {
            return tvState;
        }

        public void setTvState(MaterialTextView tvState) {
            this.tvState = tvState;
        }

        public MaterialTextView getTvNationality() {
            return tvNationality;
        }

        public void setTvNationality(MaterialTextView tvNationality) {
            this.tvNationality = tvNationality;
        }

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
