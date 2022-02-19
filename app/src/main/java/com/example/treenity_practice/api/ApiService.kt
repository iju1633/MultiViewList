package com.example.treenity_practice.api

import com.example.treenity_practice.model.MyTreeResponse
import com.example.treenity_practice.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // User 부분
    @GET("users/1/my-page")
    fun getUser(): Call<User>

    // My Item 부분
    @GET("users/1/trees")
    suspend fun getMyTrees(): Response<MyTreeResponse>
}