package com.example.activity_and_hooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.activity_and_hooks.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String message = intent.getStringExtra(EXTRA_MESSAGE);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE", "SecondActivity.onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE", "SecondActivity.onStart");
    }
}