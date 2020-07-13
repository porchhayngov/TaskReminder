package com.chhay.taskreminder.tasks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chhay.taskreminder.R;

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {
    //Dataset
    private Tasks[] tasks;
    private onTasksListener onTasksListener;

    public TasksAdapter(Tasks[] tasks, onTasksListener onTaskListener) {
        this.tasks = tasks;
        this.onTasksListener = onTaskListener;
    }


    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_tasks, parent, false);

        return new TasksViewHolder(itemView, onTasksListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Tasks task = tasks[position];
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return tasks.length;
    }

    public interface onTasksListener{
        void onTasksClick(int position);
    }
}
