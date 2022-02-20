package com.example.treenity_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.treenity_practice.adapter.MessageAdapter
import com.example.treenity_practice.adapter.MyTreeAdapter
import com.example.treenity_practice.adapter.MyTreeParentAdapter
import com.example.treenity_practice.adapter.UserAdapter
import com.example.treenity_practice.databinding.*
import com.example.treenity_practice.model.Item
import com.example.treenity_practice.model.User
import com.example.treenity_practice.viemodel.MyTreeViewModel
import com.example.treenity_practice.viemodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Main
    private lateinit var binding: ActivityMainBinding

    // User
    private lateinit var binding1: ItemUserBinding

    // My Tree
    private lateinit var  binding3: ItemMyitemBinding
    private val myTreeViewModel: MyTreeViewModel by viewModels()

    // Message
    private lateinit var binding4: ItemMessageBinding


    lateinit var concatAdapter: ConcatAdapter
    lateinit var userAdapter: UserAdapter

    lateinit var myTreeAdapter: MyTreeAdapter
    lateinit var myTreeParentAdapter: MyTreeParentAdapter

    lateinit var messageAdapter: MessageAdapter

    private val allTreeLists: ArrayList<List<Item>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding1 = ItemUserBinding.inflate(layoutInflater)
        binding3 = ItemMyitemBinding.inflate(layoutInflater)
        binding4 = ItemMessageBinding.inflate(layoutInflater)

        setContentView(binding.root)


        // My Tree 데이터 로드
        getMyTreeData()

        // adapter initiate
        userAdapter = UserAdapter()
        messageAdapter = MessageAdapter()

        // 어댑터에 정보 주입
        initUserViewModel()

        // main recyclerview
        setRecyclerViews()
    }

    private fun getMyTreeData() {
        myTreeViewModel.responseMyTree.observe(this, { listMyTrees ->
            myTreeAdapter.trees = listMyTrees

            for(i: Int in listMyTrees.indices)
                allTreeLists.add(listOf(listMyTrees[i].item))
        })
    }


    private fun setRecyclerViews() {

        // init adapter
        var item = Item("", "")
        myTreeAdapter = MyTreeAdapter(listOf(item))
        myTreeParentAdapter = MyTreeParentAdapter(this, allTreeLists)
        myTreeParentAdapter.notifyDataSetChanged()

        val listOfAdapters = listOf(userAdapter, myTreeParentAdapter, messageAdapter)
        concatAdapter = ConcatAdapter(listOfAdapters)


        // inner rv 에 myTreeAdapter 붙이기
        binding3.itemRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding3.itemRecycler.adapter = myTreeAdapter


        // 메인 rv 에 concatAdapter 붙이기
        val layoutManagerForMainRecycler: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layoutManagerForMainRecycler
        binding.recyclerview.adapter = concatAdapter
    }

    private fun initUserViewModel() {

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.getLiveDataObserver().observe(this, Observer<User>{

            if(it != null) {
                userAdapter.setUserData(it)
                userAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@MainActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.loadListOfData()
    }
}