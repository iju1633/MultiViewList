package net.simplifiedcoding.multiviewlist.data.repository


import net.simplifiedcoding.multiviewlist.data.api.ApiService
import javax.inject.Inject

class MyTreeRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getMyTrees() = apiService.getMyTrees()
}