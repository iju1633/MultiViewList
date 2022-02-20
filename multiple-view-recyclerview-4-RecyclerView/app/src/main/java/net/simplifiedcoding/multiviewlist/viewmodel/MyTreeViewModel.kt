package net.simplifiedcoding.multiviewlist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.multiviewlist.data.repository.MyTreeRepository
import net.simplifiedcoding.multiviewlist.model.MyTreeItem
import javax.inject.Inject

@HiltViewModel
class MyTreeViewModel
@Inject
constructor(private val repository: MyTreeRepository) : ViewModel() {

    private val _response = MutableLiveData<List<MyTreeItem>>()
    val responseMyTree: LiveData<List<MyTreeItem>>
        get() = _response

    init {
        getAllTrees()
    }

    private fun getAllTrees() = viewModelScope.launch {
        repository.getMyTrees().let {response ->

            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("tag", "getAllTrees Error: ${response.code()}")
            }
        }
    }



}