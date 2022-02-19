package com.example.treenity_practice.viemodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.treenity_practice.model.User
import com.example.treenity_practice.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel
@Inject
constructor(private val repository: UserRepository): ViewModel(){

    var userData: MutableLiveData<User> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<User> {
        return userData
    }

    fun loadListOfData() {
        repository.makeAPICall(userData)
    }
}