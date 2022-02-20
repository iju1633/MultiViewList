package net.simplifiedcoding.multiviewlist.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import net.simplifiedcoding.multiviewlist.databinding.TestBinding
import net.simplifiedcoding.multiviewlist.model.Item
import net.simplifiedcoding.multiviewlist.model.MyTreeItem


class MyTreeAdapter(items: List<Item>) : RecyclerView.Adapter<MyTreeAdapter.MyViewHolder>() { // 지금부터 시작!!


    private val items: List<Item>

    init {
        this.items = items
    }


    inner class MyViewHolder
    internal constructor(
        val binding: TestBinding
    ): RecyclerView.ViewHolder(binding.root)


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

//class MyTreeAdapter(
//    items: List<Item> = emptyList(),
//) : BaseAdapter<Item>(
//    R.layout.test,
//    items,
//) {
//    override fun bind(itemView: View, item: Item, position: Int, viewHolder: BaseViewHolderImp) {
//        itemView.run {
//            findViewById<TextView>(R.id.treeName)?.text = item.name
//            findViewById<ImageView>(R.id.treeImage)?.load(item.imagePath)
//        }
//    }
//}
