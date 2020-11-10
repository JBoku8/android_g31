package com.example.activity_and_hooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    public void onSecondPage(View view){
//        Intent secondPageIntent = new Intent(this, SecondActivity.class);
//
//        startActivity(secondPageIntent);


    Intent sendIntent = new Intent();

    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(SecondActivity.EXTRA_MESSAGE, "Common Message");
    sendIntent.setType("text/plain");

    Intent windowChooser = Intent.createChooser(sendIntent, "Choose Application");

    if( sendIntent.resolveActivity(getPackageManager()) != null ){
        startActivity(windowChooser);
    }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = (Button)findViewById(R.id.secondPageButton);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onSecondPage(v);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("LIFECYCLE", "MainActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE", "MainActivity.onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE", "MainActivity.onRestart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE", "MainActivity.onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE", "MainActivity.onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE", "MainActivity.onPause");

    }
}