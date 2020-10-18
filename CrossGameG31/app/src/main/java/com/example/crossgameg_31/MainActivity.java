package com.example.crossgameg_31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean redIsShown = true;
    //  0 - red, 1 - yellow , 2 - empty
    int activePlayer = 0;
    int[] gameState = {
            2,2,2,
            2,2,2,
            2,2,2
    };

    int[][] winningPositions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {2,4,6},
            {0,4,8}
    };

    boolean gameIsActive = true;
//    public void onImageClick(View view) {
//        ImageView clickedImage = (ImageView) view;
//        ImageView toShowImage;
//
//        if( redIsShown ) {
//            toShowImage = findViewById(R.id.yellow);
//            redIsShown = false;
//        }
//        else {
//            toShowImage = findViewById(R.id.red);
//            redIsShown = true;
//        }
//
//        clickedImage.animate().translationY(-2000).rotationY(-1800).alpha(0).setDuration(300);
//        toShowImage.animate().translationY(0).rotationY(-1800).alpha(1).setDuration(300);
//    }

    public void onPlayGame(View view){
        ImageView clickedImage = (ImageView) view;

        int tagIndex = Integer.parseInt(clickedImage.getTag().toString());

        if( gameState[tagIndex] == 2 && gameIsActive) {
            gameState[tagIndex] = activePlayer;
            clickedImage.setTranslationY(-2000);
            clickedImage.setAlpha(0f);
            if( activePlayer == 0 ) {
                clickedImage.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            }
            else{
                clickedImage.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            clickedImage.animate().translationY(0).alpha(1).setDuration(300);

            for(int[] positions: winningPositions){
                if( gameState[positions[0]] != 2 && gameState[positions[0]] == gameState[positions[1]] && gameState[positions[1]] == gameState[positions[2]]) {
                    String message = "";
                    if( activePlayer == 0 ) {
                        message = "Red";
                    }
                    else {
                        message = "Yellow";
                    }
                    gameIsActive = false;

                    Toast.makeText(this, "Winner is " + message, Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}