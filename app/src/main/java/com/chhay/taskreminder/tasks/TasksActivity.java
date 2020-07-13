package com.chhay.taskreminder.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chhay.taskreminder.R;
import com.google.gson.Gson;


public class TasksActivity extends AppCompatActivity implements TasksAdapter.onTasksListener {

    private RecyclerView recyclerView;
    Tasks[] tasks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tasks);

        //Make a reference to the RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       loadTasks(this);

    }

    private void loadTasks(final TasksAdapter.onTasksListener onTaskListener){
        //Load com.chhay.taskreminder.email from the server using Volley library
        String url = "http://10.0.2.2/tasks.json";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //convert json string to array of Email using Gson
                Gson gson = new Gson();
                tasks = gson.fromJson(response, Tasks[].class);
                //create and set an adapter
                TasksAdapter adapter = new TasksAdapter(tasks, onTaskListener);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TasksActivity.this, "something error while loading data from the server", Toast.LENGTH_LONG).show();
                Log.d("chhayManager", "load data error" + error.getMessage());
            }
        });

        //add the request to the Queue
        Volley.newRequestQueue(this).add(request);
    }

    @Override
    public void onTasksClick(int position) {
        Log.d("click","position: " + position);
        Intent intent = new Intent(this, DetailTasksActivity.class);
        intent.putExtra("title",tasks[position].getTitle());
        intent.putExtra("date",tasks[position].getDate());
        startActivity(intent);
    }
}
