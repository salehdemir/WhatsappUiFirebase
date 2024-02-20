package com.example.mywhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class MessageAdapter (var messages: ArrayList<Message>):
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messages[position]
        holder.imageViewProfile.setImageResource(currentMessage.image)
        holder.textViewName.text = currentMessage.name
        holder.textViewLastMessage.text = currentMessage.lastMessage
        holder.textViewTime.text = currentMessage.time
        holder.imageViewSeen.visibility = View.VISIBLE

    }

    override fun getItemCount(): Int {
        return messages.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageViewProfile: CircleImageView = itemView.findViewById(R.id.imageViewProfile)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewLastMessage: TextView = itemView.findViewById(R.id.textViewLastMessage)
        val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)
        val imageViewSeen: ImageView = itemView.findViewById(R.id.imageViewSeen)

    }
}