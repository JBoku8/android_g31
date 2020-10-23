package com.example.guessgameg_31;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int MAX_TRY = 5;
    int tries;


    int DEFAULT_LIMIT = 20;
    int limit = 20;
    int randomNumber;

    MediaPlayer mediaPlayer;

    private void generateNumber(){
        EditText numberLimitEditText = (EditText) findViewById(R.id.numberLimit);


        if( !numberLimitEditText.getText().toString().isEmpty() ) {
            limit = Integer.parseInt(numberLimitEditText.getText().toString());
        }
        else {
            limit = DEFAULT_LIMIT;
            numberLimitEditText.setText(""+limit);
        }

        tries = MAX_TRY;
        updateTextTries();

        Random rand = new Random();
        randomNumber = rand.nextInt(limit) + 1;
    }


    private void updateTextTries(){
        TextView textViewTries = (TextView) findViewById(R.id.textViewTries);
        textViewTries.setText("Tries - " + tries);
    }

    public void restartGame(View view){
        generateNumber();
        Button button = (Button) view;
        button.setVisibility(View.INVISIBLE);
    }

    public void onPlayGame(View view) {
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);

        Button restartGameBtn = (Button) findViewById(R.id.restartGameBtn);
        restartGameBtn.setTranslationX(2000);

//        Button playButton = (Button) view;

        Log.i("User_NUMBER", editTextNumber.getText().toString());

        String message;

        if( editTextNumber.getText().toString().isEmpty() ) {
            message = "Please enter the number";
        }
        else {
            tries--;

            if( tries >= 0 ) {
                updateTextTries();
                int userNumber = Integer.parseInt(editTextNumber.getText().toString());
                if( userNumber < randomNumber ) {
                    message = "Try Higher";
                }
                else if (userNumber > randomNumber) {
                    message = "Try Lower";
                }
                else {
                    if( tries == 0 ) {
                        message = "You Won!. Your Point is - 5";
                    }
                    else {
                        message = "You Won!. Your Point is - " + tries * 10;
                    }
                    restartGameBtn.animate().translationX(0).setDuration(300);
                    restartGameBtn.setVisibility(View.VISIBLE);
                    editTextNumber.setText("");
                }
            }
            else {
                message = "Try again.";
                restartGameBtn.animate().translationX(0).rotation(3600).setDuration(300);
                restartGameBtn.setVisibility(View.VISIBLE);
                editTextNumber.setText("");
            }

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();

        mediaPlayer = MediaPlayer.create(this, R.raw.heavy_rain_daniel_simon);
//        mediaPlayer.setLooping(true);

    }
}