package com.example.activity_and_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public final static String RESULT_MESSAGE = "com.example.activity_and_intents.RESULT_MESSAGE";
    public final static String RESULT = "com.example.activity_and_intents.RESULT";

    Integer num_1;
    Integer num_2;

    public void onGoBack(View view){

        Intent returnIntent = new Intent();
        returnIntent.putExtra(RESULT_MESSAGE, "Second Activity Finished...");
        returnIntent.putExtra(RESULT, num_1 + num_2);

        setResult(RESULT_OK, returnIntent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.onGoBackBtn);

        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();

//        String textViewValue = receivedIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        String buttonTextValue = receivedIntent.getStringExtra(MainActivity.EXTRA_BTN_TEXT);
//        Integer num_1 = receivedIntent.getIntExtra(MainActivity.EXTRA_NUM_1, 0);
//        Integer num_2 = receivedIntent.getIntExtra(MainActivity.EXTRA_NUM_2, 0);

        String textViewValue = receivedBundle.getString(MainActivity.EXTRA_MESSAGE);
        String buttonTextValue = receivedBundle.getString(MainActivity.EXTRA_BTN_TEXT);

        num_1 = receivedBundle.getInt(MainActivity.EXTRA_NUM_1, 0);
        num_2 = receivedBundle.getInt(MainActivity.EXTRA_NUM_2, 0);

        textView.setText(textViewValue);
        button.setText(buttonTextValue);

//        Toast.makeText(this, "SUM is - " + (num_1 + num_2), Toast.LENGTH_SHORT).show();

    }
}