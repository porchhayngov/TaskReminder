package com.chhay.taskreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private FloatActionButton mAddReminderButton;
    private Toolbar mToolbar;
    AlarmCursorAdapter mCursorAdapter;
    ListView reminderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("TaskReminder");

        reminderListView = (ListView) findViewById(R.id.list);
        View emptyView = findViewById(R.id.empty_view);
        reminderListView.setEmptyView(emptyView);

        mCursorAdapter = new AlarmCursorAdapter(this, null);
        reminderListView.setAdapter(mCursorAdapter);
    }


}
