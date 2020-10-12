package com.example.guessgameg_31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    private void generateNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void onPlayGame(View view) {
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);

        Log.i("User_NUMBER", editTextNumber.getText().toString());

        String message;

        if( editTextNumber.getText().toString().isEmpty() ) {
            message = "Please enter the number";
        }
        else {
            int userNumber = Integer.parseInt(editTextNumber.getText().toString());
            if( userNumber < randomNumber ) {
                message = "Try Higher";
            }
            else if (userNumber > randomNumber) {
                message = "Try Lower";
            }
            else {
                message = "You Won!.";
                generateNumber();
            }
        }


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }
}