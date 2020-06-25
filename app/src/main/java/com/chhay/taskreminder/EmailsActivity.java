package com.chhay.taskreminder;

import android.os.Bundle;
import android.os.PersistableBundle;
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
import com.google.gson.Gson;


public class EmailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_emails);

        //Make a reference to the RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        //Create and set a layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       loadEmails();

    }

    private void loadEmails(){
        //Load email from the server using Volley library
        String url = "http://10.0.2.2/mails.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //convert json string to array of Email using Gson
                Gson gson = new Gson();
                Email[] emails = gson.fromJson(response, Email[].class);
                //create and set an adapter
                EmailsAdapter adapter = new EmailsAdapter(emails);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EmailsActivity.this, "something error while loading data from the server", Toast.LENGTH_LONG).show();
                Log.d("chhayManager", "load data error" + error.getMessage());
            }
        });

        //add the request to the Queue
        Volley.newRequestQueue(this).add(request);
    }
}
