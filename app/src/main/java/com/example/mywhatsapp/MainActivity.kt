package com.example.mywhatsapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import java.util.ArrayList

public class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)

        setContentView(R.layout.activity_main)

        val recyclerViewMessages = findViewById<RecyclerView>(R.id.recyclerViewMessage)

        val adapter = MessageAdapter(ArrayList())
        recyclerViewMessages.adapter = adapter
        viewModel.messages.observe(this, Observer {
            adapter.messages = it as ArrayList<Message>
            adapter.notifyDataSetChanged()
        })
    }
}