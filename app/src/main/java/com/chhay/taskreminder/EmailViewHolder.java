package com.chhay.taskreminder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


public class EmailViewHolder extends RecyclerView.ViewHolder {

    private TextView txtSender;
    private TextView txtSubject;
    private TextView txtBody;
    private SimpleDraweeView imgSender;

    public EmailViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSender = itemView.findViewById(R.id.txt_sender);
        txtSubject = itemView.findViewById(R.id.txt_subject);
        txtBody = itemView.findViewById(R.id.txt_body);
        imgSender = itemView.findViewById(R.id.img_sender);
    }

    public void bind(Email email){
        txtSender.setText(email.getSender());
        txtSender.setText(email.getSubject());
        txtSender.setText(email.getBody());
        imgSender.setImageURI(email.getSenderProfile());
    }

}
