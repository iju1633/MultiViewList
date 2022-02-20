package com.example.treenity_practice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.treenity_practice.databinding.TestBinding
import com.example.treenity_practice.model.Item
import com.example.treenity_practice.model.MyTreeItem
import com.example.treenity_practice.repository.MyTreeRepository
import com.example.treenity_practice.viemodel.MyTreeViewModel

class MyTreeAdapter(items: List<Item>) : RecyclerView.Adapter<MyTreeAdapter.MyViewHolder>() { // 지금부터 시작!!


    private val items: List<Item>

    init {
        this.items = items
    }


    inner class MyViewHolder
    internal constructor(
        val binding: TestBinding
    ): RecyclerView.ViewHolder(binding.root) {
        val card: CardView = binding.card
        val treeImage: ImageView = binding.treeImage
        val treeName: TextView = binding.treeName
    }


    private val diffCallback = object : DiffUtil.ItemCallback<MyTreeItem>() {
        override fun areItemsTheSame(oldItem: MyTreeItem, newItem: MyTreeItem): Boolean {
            return oldItem.treeId == newItem.treeId
        }

        override fun areContentsTheSame(oldItem: MyTreeItem, newItem: MyTreeItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var trees: List<MyTreeItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TestBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tree = trees[position]

        holder.binding.apply {
            treeName.text = tree.item.name

            treeImage.load(tree.item.imagePath) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = trees.size

}