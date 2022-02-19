package com.example.treenity_practice.repository

import com.example.treenity_practice.api.ApiService
import javax.inject.Inject

class MyTreeRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getMyTrees() = apiService.getMyTrees()
}