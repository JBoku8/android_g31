package com.example.listviewdemo_g31

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val mContext: Context, private val dataSource: List<User>) : BaseAdapter(){
    override fun getCount(): Int {
        return  dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater = LayoutInflater.from(mContext)
        val layout = layoutInflater.inflate(R.layout.main_listview_layout, parent, false)



        layout.setBackgroundColor(Color.parseColor("#34495e"))

        val nameTextView = layout.findViewById<TextView>(R.id.listViewNameView);
        val positionView = layout.findViewById<TextView>(R.id.listViewPositionView)

        val currentUser: User = dataSource[position];

        nameTextView.text = "${currentUser.name} ${currentUser.lastName}"
        positionView.text = "Age: ${currentUser.age}"

        return  layout
//        val textView = TextView(mContext);
//
//        textView.text = dataSource[position]
//
//
//        textView.setPadding(20);
//        textView.setTextColor(Color.BLACK)
//
//        return  textView
    }
}