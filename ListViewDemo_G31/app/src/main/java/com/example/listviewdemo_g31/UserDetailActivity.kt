package com.example.listviewdemo_g31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val userName = intent.getStringExtra(Constants.USER_DETAIL_NAME_KEY)
        val userNameTextView = findViewById<TextView>(R.id.userNameTextView)

        userNameTextView.text = userName;

    }
}