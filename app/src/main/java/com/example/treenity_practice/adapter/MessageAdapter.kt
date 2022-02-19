package com.example.treenity_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treenity_practice.databinding.ItemMessageBinding
import com.example.treenity_practice.model.Message

class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    var messages = Message("")

    class MessageViewHolder(private val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            // 확장성을 위한 코드
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MessageViewHolder {
        return MessageViewHolder(
            ItemMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        // 확장성을 위한 코드
    }


}