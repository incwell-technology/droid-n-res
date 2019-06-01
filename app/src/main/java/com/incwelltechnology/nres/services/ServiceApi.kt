package com.incwelltechnology.nres.services

import com.incwelltechnology.nres.views.CategoryActivity
import retrofit2.Call
import retrofit2.http.GET


interface ServiceApi {
    @GET("categories")
    fun getCategory() : Call<CategoryActivity>

    @GET
    fun getFood(): Call<CategoryActivity>

}