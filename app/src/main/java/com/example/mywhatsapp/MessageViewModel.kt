package com.example.mywhatsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Character.getName

class MessageViewModel:ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages
    init {
        loadMessages()
    }
    private fun loadMessages() {

        val messageList = mutableListOf<Message>()
        repeat(50) { index ->
            messageList.add(
                Message(
                    image = getImageResource(index),
                    name = getName(index),
                    lastMessage = getLastMessage(index),
                    seen = index % 2 == 0,
                    time = getTime(index)
                )
            )
        }
        _messages.value = messageList
    }

    private fun getImageResource(index: Int): Int {
        return when (index % 6) {

            0 -> R.drawable.profile
            1 -> R.drawable.profile1
            2 -> R.drawable.profile2
            3 -> R.drawable.profile3
            4 -> R.drawable.profile5
            else -> R.drawable.profile4
        }
    }

    private fun getName(index: Int): String {
        val names = arrayOf("Ahmad", "Mahmood", "Saleh", "Mustafa", "Laila", "Sara")
        return names[index % names.size]
    }

    private fun getLastMessage(index: Int): String {
        val messages = arrayOf(
            "How are you?",
            "I'm fine, thank you.",
            "What's up?",
            "Nothing much, just chilling.",
            "Where are you?",
            "I'm at home."
        )
        return messages[index % messages.size]
    }

    private fun getTime(index: Int): String {
        return "12:${index.toString().padStart(2, '0')} PM"
    }
}