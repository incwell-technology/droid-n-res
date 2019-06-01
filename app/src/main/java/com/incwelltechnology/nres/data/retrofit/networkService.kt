package com.incwelltechnology.nres.data.retrofit

import com.google.gson.Gson
import com.incwelltechnology.nres.data.converter.EnvelopeConverterFactory
import com.incwelltechnology.nres.services.RestService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }
    single { getService(get()) }
}

fun getRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("http://192.168.1.145:3000/")
        .client(client)
        .addConverterFactory(EnvelopeConverterFactory(Gson()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun getService(retrofit: Retrofit): RestService = retrofit.create(RestService::class.java)

fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(getLogger())
        .build()
}

fun getLogger(): HttpLoggingInterceptor {
    var interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
}