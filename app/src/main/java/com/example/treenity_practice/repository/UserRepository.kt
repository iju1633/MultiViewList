package com.example.treenity_practice.repository

import androidx.lifecycle.MutableLiveData
import com.example.treenity_practice.api.ApiService
import com.example.treenity_practice.di.AppModule
import com.example.treenity_practice.model.User
import com.example.treenity_practice.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository
@Inject
constructor(val apiService: ApiService) {

    fun makeAPICall(liveData: MutableLiveData<User>) {
        val retroInstance = AppModule.provideRetrofitInstance()
        val call  = retroInstance.getUser()

        call.enqueue(object: Callback<User> { // 비동기 처리
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                liveData.postValue(null)
            }
        })

    }
}