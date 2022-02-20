package net.simplifiedcoding.multiviewlist.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.simplifiedcoding.multiviewlist.R
import net.simplifiedcoding.multiviewlist.databinding.ItemMyitemBinding
import net.simplifiedcoding.multiviewlist.model.Item


class MyTreeParentAdapter(private val context: Context, private val treeLists: List<List<Item>>) : RecyclerView.Adapter<MyTreeParentAdapter.ParentViewHolder>() { // 지금부터 시작

    private var items: List<List<Item>> = ArrayList()
    private var contexts: Context


    init {
        this.items = treeLists
        this.contexts = context
    }


    // 리스트의 한 셀에 보여질 뷰를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ParentViewHolder { // 이제 시작!
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
        // holder.bind(items[position])

        var item =  items[position]
        holder.itemView.findViewById<RecyclerView>(R.id.item_recycler).layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    // 셀 하나하나를 다뤄주는 뷰 객체를 만든다
    inner class ParentViewHolder(private val binding: ItemMyitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: List<Item>) {

            items = listOf(item)

            val adapter = MyTreeAdapter(treeLists[absoluteAdapterPosition])
            binding.itemRecycler.adapter = adapter

            binding.itemRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.itemRecycler.setHasFixedSize(true)

        }
    }


}

//class MyTreeParentAdapter(
//    items: List<MyTreeSection> = emptyList(),
//) : BaseAdapter<MyTreeSection>(
//    R.layout.item_myitem,
//    items,
//) {
//    private val scrollStates: MutableMap<String, Parcelable?> = mutableMapOf()
//
//    private val viewPool = RecyclerView.RecycledViewPool()
//
//    private fun getSectionID(position: Int): String {
//        return items[position].userId.toString()
//    }
//
//    override fun onViewRecycled(holder: BaseViewHolder<MyTreeSection>) {
//        super.onViewRecycled(holder)
//
//        //save horizontal scroll state
//        val key = getSectionID(holder.layoutPosition)
////        scrollStates[key] =
////            holder.itemView.findViewById<RecyclerView>(R.id.titledSectionRecycler).layoutManager?.onSaveInstanceState()
//    }
//
//    override fun bind(
//        itemView: View,
//        item: MyTreeSection,
//        position: Int,
//        viewHolder: BaseViewHolderImp
//    ) {
//        //itemView.findViewById<TextView>(R.id.sectionTitleTextView)?.text = item.title
//        val layoutManager =
//            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
//
//        layoutManager.initialPrefetchItemCount = 4
//
//        val items = ArrayList<Item>()
//        for(i: Int in item.trees.indices) { // 모든 Tree 라는 클래스가 갖고 있는 Item 을 리스트로 저장
//            items.add(item.trees[i].item)
//        }
//
//        val titledSectionRecycler = itemView.findViewById<RecyclerView>(R.id.item_recycler)
//        titledSectionRecycler?.run {
//            this.setRecycledViewPool(viewPool)
//            this.layoutManager = layoutManager
//            this.adapter = MyTreeAdapter(items)
//        }
//
//        //restore horizontal scroll state
//        val key = getSectionID(viewHolder.layoutPosition)
//        val state = scrollStates[key]
//        if (state != null) {
//            titledSectionRecycler.layoutManager?.onRestoreInstanceState(state)
//        } else {
//            titledSectionRecycler.layoutManager?.scrollToPosition(0)
//        }
//    }
//}
