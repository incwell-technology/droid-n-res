package com.incwelltechnology.nres.services

import com.incwelltechnology.nres.models.Category
import retrofit2.Call
import retrofit2.http.GET


interface ServiceApi {
    @GET("categories")
    fun getCategory(): Call<Category>

    @GET
    fun getFood(): Call<Category>

}