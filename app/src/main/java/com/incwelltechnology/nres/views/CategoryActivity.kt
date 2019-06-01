package com.incwelltechnology.nres.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_category.*


class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.incwelltechnology.nres.R.layout.activity_category)

        val intent = intent
        val str = intent.getStringExtra("data")
        Log.d("str",""+str)

        output.setText(str)


//        val service = ServiceBuilder.buildService(ServiceApi::class.java)
//        service.getCategory().enqueue(object : Callback<CategoryActivity> {
//            override fun onFailure(call: Call<CategoryActivity>, t: Throwable) {
//
//            }
//
//            override fun onResponse(call: Call<CategoryActivity>, response: Response<CategoryActivity>) {
//                Log.d("TEST",""+response)
//            }
//        })
    }
}
