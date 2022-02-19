package com.example.treenity_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.treenity_practice.databinding.ItemUserBinding
import com.example.treenity_practice.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var binding : ItemUserBinding

    var items = User(0,0,0,"")

    fun setUserData(data: User) {
        this.items = data
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        binding = ItemUserBinding.inflate(inflater) // xml 에 씌여져 있는 view 의 정의를 실제 view 객체로 만듦
        return UserViewHolder( // ViewBinding 을 이용하기 위해 view 가 들어가지 않고 view 객체를 넣음
            binding
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(items)

    override fun getItemCount() = 1


    class UserViewHolder(view : ItemUserBinding): RecyclerView.ViewHolder(view.root){

        var userName = view.username
        var point = view.point
        var bucket = view.bucket
        var totalWalks = view.totalWalk

        fun bind(data: User) {
            userName.text = data.username
            point.text = data.point.toString()
            bucket.text = data.buckets.toString()
            totalWalks.text = data.totalWalks.toString()
        }
    }
}