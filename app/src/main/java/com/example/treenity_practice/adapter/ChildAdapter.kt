//package com.example.treenity_practice.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import coil.load
//import com.example.treenity_practice.R
//import com.example.treenity_practice.databinding.ItemMyitemRowBinding
//import com.example.treenity_practice.model.ChildModel
//
//open class ChildAdapter(var myItems: List<ChildModel>) : //////////////////
//    RecyclerView.Adapter<ChildAdapter.DataViewHolder>() {
//
//    lateinit var binding: ItemMyitemRowBinding
//
//    private var myItemsList: List<ChildModel> = ArrayList()
//
//    init {
//        this.myItemsList = myItems
//    }
//
////    var onItemClick: ((String) -> Unit)? = null
//
//    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////        init {
////            itemView.setOnClickListener {
////                onItemClick?.invoke(myItemsList[absoluteAdapterPosition].name)
////            }
////        }
//
//        fun bind(result: ChildModel) {
//            binding.description.text = result.name
//
//            binding.usertree.load(result.imagePath) {
//                crossfade(true)
//                crossfade(1000)
//            }
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
//        LayoutInflater.from(parent.context).inflate(
//            R.layout.item_myitem_row, parent,
//            false
//        )
//    )
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(myItemsList[position])
//    }
//
//    override fun getItemCount(): Int = myItemsList.size
//
//
//}