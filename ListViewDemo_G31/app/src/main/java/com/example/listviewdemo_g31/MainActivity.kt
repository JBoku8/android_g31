package com.example.listviewdemo_g31

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var mainListView: ListView
    private val users = listOf<String>(
            "User 1",
            "User 2",
            "User 3",
            "User 4",

            "User 5",
            "User 6",
            "User 7",
            "User 8",

            "User 9",
            "User 10",
            "User 11",
            "User 12"
    )

    private val userList = listOf<User>(
        User("John", "Doe", 23),
        User("James", "Smith", 27),
        User("Anna", "Doe", 89),
        User("Alice", "Unknown", 34)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // supportActionBar?.hide()

        mainListView = findViewById(R.id.main_listView)

        // val bgColor = Color.parseColor("#111d5e");


        // mainListView.setBackgroundColor(bgColor)


        mainListView.adapter = MyAdapter(this, userList);

        mainListView.setOnItemClickListener { _, _, position, _ ->
            // Toast.makeText(this, users[position], Toast.LENGTH_SHORT).show()

            val detailIntent = Intent(this, UserDetailActivity::class.java)
            detailIntent.putExtra(Constants.USER_DETAIL_NAME_KEY, users[position])
            startActivity(detailIntent)
        }

    }
}



