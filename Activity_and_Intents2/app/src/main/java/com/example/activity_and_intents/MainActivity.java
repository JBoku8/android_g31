package com.example.activity_and_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.activity_and_intents.MESSAGE";
    public final static String EXTRA_BTN_TEXT = "com.example.activity_and_intents.BTN_TEXT";
    public final static String EXTRA_NUM_1 = "com.example.activity_and_intents.NUM_1";
    public final static String EXTRA_NUM_2 = "com.example.activity_and_intents.NUM_2";

    public final static int SUM_REQUEST = 0;
    public final static int MULTIPLY_REQUEST = 1;

    public void onNextPage(View view){
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
//        secondActivityIntent.setData(Uri.parse("http://"));
//        secondActivityIntent.putExtra(EXTRA_MESSAGE, "Hello Activity!...");
//        secondActivityIntent.putExtra(EXTRA_BTN_TEXT, "უკან დაბრუნება");
//        secondActivityIntent.putExtra(EXTRA_NUM_1, 30);
//        secondActivityIntent.putExtra(EXTRA_NUM_2, 70);

        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_NUM_1, 30);
        bundle.putInt(EXTRA_NUM_2, 100);
        bundle.putString(EXTRA_MESSAGE, "Hello Activity!...");
        bundle.putString(EXTRA_BTN_TEXT, "უკან დაბრუნება");

        secondActivityIntent.putExtras(bundle);

        startActivityForResult(secondActivityIntent, SUM_REQUEST);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HashMap<String, String> myMap = new HashMap<String, String>();
//
//        myMap.put("Georgia", "Tbilisi");
//        myMap.put("Spain", "Madrid");
//        myMap.put("France", "Paris");
//
//        for(String key: myMap.keySet()) {
//            Log.i("MAP_INFO", "KEY - " + key + ", " + myMap.get(key));
//        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if( requestCode == SUM_REQUEST ) {
                if( resultCode == RESULT_OK) {
                    int sum = data.getIntExtra(SecondActivity.RESULT, 0);
                    String message = data.getStringExtra(SecondActivity.RESULT_MESSAGE);

                    TextView textView = (TextView)findViewById(R.id.mainActivitiTextView);
                    textView.setText(message);

                    Toast.makeText(this, "Result is " + sum, Toast.LENGTH_SHORT).show();
                }

                if( resultCode == RESULT_CANCELED ) {
                    Toast.makeText(this, "SUM_REQUEST failed", Toast.LENGTH_SHORT).show();
                }
            }
            else if ( requestCode == MULTIPLY_REQUEST) {
                Toast.makeText(this, "MULTIPLY_REQUEST failed", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){

        }

    }

    //    STACK

//    A -> B -> C -> D
//    LIFO

/*
    D
    C
    B
    A
 */

}