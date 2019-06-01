package com.incwelltechnology.nres.services

import com.incwelltechnology.nres.models.Category
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface RestService {
    @GET("categories")
    fun getCategoryAsync(): Deferred<List<Category>>

    @GET
    fun getFood(): Deferred<Category>

}