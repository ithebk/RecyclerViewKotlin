package com.ithebk.recyclerviewkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        viewAdapter = RecyclerViewCustomAdapter(getDataSets(), object : ClickCallback {
            override fun onClick(position: Int, text: String) {
                Toast.makeText(baseContext, "Clicked $text\n Position : $position", Toast.LENGTH_LONG).show();
            }
        });

        viewManager = LinearLayoutManager(this);
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager;
            adapter = viewAdapter;
        }
    }

    private fun getDataSets(): Array<String> {
        return arrayOf("Hello", "World", "Learning", "Kotlin");
    }
}
