package com.example.email_password_firebase_g31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var signOutButton: Button
    private lateinit var displayName: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signOutButton = findViewById(R.id.signOutButton)
        displayName = findViewById(R.id.displayName)
        auth = FirebaseAuth.getInstance()


        signOutButton.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        if( auth.currentUser != null ) {
            displayName.text = auth.currentUser?.displayName
        }

    }
}