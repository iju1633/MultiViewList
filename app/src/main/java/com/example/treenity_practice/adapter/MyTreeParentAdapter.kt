package com.example.treenity_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.treenity_practice.R
import com.example.treenity_practice.databinding.ItemMyitemBinding
import com.example.treenity_practice.model.Item
import com.example.treenity_practice.model.MyTreeItem

class MyTreeParentAdapter : RecyclerView.Adapter<MyTreeParentAdapter.MyViewHolder>() {

    var myItemList: List<MyTreeItem> = ArrayList()
    lateinit var binding: ItemMyitemBinding

    private var itemList: List<Item>? = null


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(result: MyTreeItem) {

            val layoutManager = LinearLayoutManager(
                binding.itemRecycler
                    .context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            val myTreeAdapter = MyTreeAdapter(listOf(result.item))

            binding.itemRecycler.layoutManager = layoutManager
            binding.itemRecycler.adapter = myTreeAdapter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_myitem, parent,
            false
        )
    )

    override fun getItemCount(): Int = myItemList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myItemList[position])
    }
}