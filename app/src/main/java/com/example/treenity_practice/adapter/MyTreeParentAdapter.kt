package com.example.treenity_practice.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.treenity_practice.R
import com.example.treenity_practice.databinding.ItemMyitemBinding
import com.example.treenity_practice.model.Item


class MyTreeParentAdapter(context: Context, treeLists: ArrayList<List<Item>>) : RecyclerView.Adapter<MyTreeParentAdapter.ParentViewHolder>() {

    private var items: ArrayList<List<Item>> = ArrayList()
    private var context: Context


    init {
        this.items = treeLists
        this.context = context
    }


    // 리스트의 한 셀에 보여질 뷰를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ParentViewHolder {
        return ParentViewHolder(
            ItemMyitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // 데이터 개수 반환
    override fun getItemCount(): Int = items.size

    // ViewHolder 에서 설정한 view 안에 있는 위젯들의 데이터를 세팅한다
    // 뷰홀더가 재활용될 때 실행되는 메서드
    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
//        items[position].let {
//            holder.bind(it)
//        }

        val adapter = MyTreeAdapter(items[position])
        holder.itemView.findViewById<RecyclerView>(R.id.item_recycler).setHasFixedSize(true)
        holder.itemView.findViewById<RecyclerView>(R.id.item_recycler).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        holder.itemView.findViewById<RecyclerView>(R.id.item_recycler).adapter = adapter
    }

    // 셀 하나하나를 다뤄주는 뷰 객체를 만든다
    inner class ParentViewHolder(private val binding: ItemMyitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var recyclerView: RecyclerView

        fun bind(item: List<Item>) {

            binding.itemRecycler.setHasFixedSize(true)
            binding.itemRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.itemRecycler.adapter = MyTreeAdapter(items[bindingAdapterPosition])

            this.recyclerView = binding.itemRecycler

        }
    }


}