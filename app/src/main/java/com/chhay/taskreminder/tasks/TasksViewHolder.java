package com.chhay.taskreminder.tasks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chhay.taskreminder.R;
import com.facebook.drawee.view.SimpleDraweeView;


public class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView txtTitle;
    private TextView txtDate;

    TasksAdapter.onTasksListener onTasksListener;
//    private TextView txtBody;
//    private SimpleDraweeView imgSender;

    public TasksViewHolder(@NonNull View itemView, TasksAdapter.onTasksListener onTasksListener) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txt_title);
        txtDate = itemView.findViewById(R.id.txt_date);
        this.onTasksListener = onTasksListener;
        itemView.setOnClickListener(this);
//        txtBody = itemView.findViewById(R.id.txt_body);
//        imgSender = itemView.findViewById(R.id.img_sender);
    }

    public void bind(Tasks tasks){
        txtTitle.setText(tasks.getTitle());
        txtDate.setText(tasks.getDate());
//        txtSender.setText(email.getBody());
//        imgSender.setImageURI(email.getSenderProfile());
    }

    @Override
    public void onClick(View v) {
        onTasksListener.onTasksClick(getAdapterPosition());
    }

}
