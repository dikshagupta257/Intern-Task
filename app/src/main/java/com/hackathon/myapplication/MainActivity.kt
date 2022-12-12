package com.hackathon.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = Adapter(list);
        val editText = findViewById<EditText>(R.id.etText);
        val btn = findViewById<Button>(R.id.btn);
        val rv = findViewById<RecyclerView>(R.id.rvList);

        rv.adapter = adapter;
        rv.layoutManager = LinearLayoutManager(this)
        btn.setOnClickListener {
            val word = editText.text.toString();
            if (word != null) {
                GlobalScope.launch(Dispatchers.Main) {
                    val response = withContext(Dispatchers.IO) {
                        Client.api.getWords(word)
                    }
                    if (response.isSuccessful) {
                        response.body()?.let {
                            list.addAll(it.definitions)
                        }
                    }
                }
            }
        }
    }
}