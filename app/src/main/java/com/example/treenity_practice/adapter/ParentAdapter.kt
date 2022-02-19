package com.example.treenity_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.treenity_practice.R
import com.example.treenity_practice.databinding.ItemMyitemBinding
import com.example.treenity_practice.model.Item


open class ParentAdapter :
    RecyclerView.Adapter<ParentAdapter.DataViewHolder>() {

    var myItemList: List<Item> = ArrayList()

    lateinit var binding: ItemMyitemBinding

//    var onItemClick: ((MyTree) -> Unit)? = null

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener {
//                onItemClick?.invoke(myItemList[absoluteAdapterPosition])
//
//            }
//
//
//        }

        fun bind(result: Item) {
            val childMembersAdapter = MyTreeAdapter(listOf(result))
            binding.itemRecycler.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            binding.itemRecycler.adapter = childMembersAdapter

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_myitem, parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(myItemList[position])
    }

    override fun getItemCount(): Int = myItemList.size


    fun addData(list: List<Item>) {
        myItemList = list
        notifyDataSetChanged()
    }


}