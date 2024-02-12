package com.example.firebase


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.recyclerview.MyAdapter


class Welcome : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(this)
         val items=fetchData()
        val adapter=MyAdapter(items)
        recyclerView.adapter=adapter

    }


      override fun onCreateOptionsMenu(menu: Menu?): Boolean {

            menuInflater.inflate(R.menu.items,menu)
            return super.onCreateOptionsMenu(menu)
        }

       override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.item1 -> Toast.makeText(this,"Name",Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(this,"Age",Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this,"City",Toast.LENGTH_SHORT).show()
            }
            return true
    }

    private fun fetchData():ArrayList<String>{
        val list= ArrayList<String>()
        for(i in 0 until 20){
            list.add("Item $i")
        }
        return list
    }

}