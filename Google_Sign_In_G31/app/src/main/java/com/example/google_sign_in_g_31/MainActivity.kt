package com.example.google_sign_in_g_31

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Note(
    val status: String = "",
    val title: String = ""
)

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var fireStore: FirebaseFirestore
    private lateinit var rcNotesView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        fireStore = Firebase.firestore
        rcNotesView = findViewById(R.id.rcNotesView)

        val notesCollectionQuery = fireStore.collection("notes")


        val options = FirestoreRecyclerOptions.Builder<Note>().setQuery(notesCollectionQuery, Note::class.java)
            .setLifecycleOwner(this).build()

        val adapter = object: FirestoreRecyclerAdapter<Note, NoteViewHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
                val view = LayoutInflater.from(this@MainActivity).inflate(android.R.layout.simple_list_item_2, parent, false)
                return NoteViewHolder(view)
            }

            override fun onBindViewHolder(holder: NoteViewHolder, position: Int, model: Note) {
                val tvTitle: TextView = holder.itemView.findViewById(android.R.id.text1)
                val tvStatus: TextView = holder.itemView.findViewById(android.R.id.text2)

                tvTitle.text = model.title
                tvStatus.text = model.status


                holder.itemView.setOnClickListener {
                    Log.i("MainActivity", "CLICKED ${model.title}")
                }
            }
        }

        rcNotesView.adapter = adapter;
        rcNotesView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if( item.itemId == R.id.mLogOut ) {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        else if ( item.itemId == R.id.mNewNote ) {
                showActionDialog()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showActionDialog() {
        val editText = EditText(this)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Create a Note")
            .setView(editText)
            .setNegativeButton("Cancel", null)
            .setPositiveButton("OK", null)
            .show()


        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
            Log.i("MAIN_ACTIVITY", "Clicked on positive button!")

            val titleText = editText.text.toString()
            if (titleText.isBlank()) {
                Toast.makeText(this, "Cannot submit empty text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val currentUser = auth.currentUser
            if (currentUser == null) {
                Toast.makeText(this, "No signed in user", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, titleText.toString(), Toast.LENGTH_SHORT).show()
//            fireStore.collection("notes").add()
            dialog.dismiss()
        }
    }
}