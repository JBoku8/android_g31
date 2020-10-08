package com.example.myfirstapplicationg_31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    public void onClickMeButton(View view){
//        Log.i("INFO", "onClickMeButton");
//
//        TextView textViewAppTitle = (TextView) findViewById(R.id.textViewAppTitle);
//        EditText editTextPersonName = (EditText) findViewById(R.id.editTextPersonName);
//
//        Log.i("USER_INPUT", editTextPersonName.getText().toString());
//
//        textViewAppTitle.setText(editTextPersonName.getText().toString());
//
//        Toast.makeText(this, "Hi, " + editTextPersonName.getText().toString(), Toast.LENGTH_SHORT).show();
//    }

    public void onSwitchCat(View view){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.cat_1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
