package com.chhay.taskreminder.email;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chhay.taskreminder.R;

public class EmailsAdapter extends RecyclerView.Adapter<EmailViewHolder> {
    //Dataset
    private Email[] emails;

    public EmailsAdapter(Email[] emails) {
        this.emails = emails;
    }


    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_email, parent, false);

        return new EmailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails[position];
        holder.bind(email);
    }

    @Override
    public int getItemCount() {
        return emails.length;
    }
}
