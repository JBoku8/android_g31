package com.example.java_and_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var userNameTextView: TextView
    lateinit var myUser: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameTextView = findViewById(R.id.userNameTextView)
        myUser = Person("John Smith", 45)
        userNameTextView.text = myUser.getInfo()

        // actionBar?.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
        // return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if( item.itemId == R.id.mProfile ) {
//            Toast.makeText(this, "Profile Clicked", Toast.LENGTH_LONG).show()
            val profileIntent = Intent(this, ProfileActivity::class.java);
            startActivity(profileIntent)
        }
        else if ( item.itemId == R.id.mLogOut ) {
            // Toast.makeText(this, "LogOut Clicked", Toast.LENGTH_LONG).show()

            val loginIntent = Intent(this, LoginActivity::class.java);
            startActivity(loginIntent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    fun onUpdateUserInfo(v: View){
        userNameTextView.text = myUser.getInfo()
    }
}