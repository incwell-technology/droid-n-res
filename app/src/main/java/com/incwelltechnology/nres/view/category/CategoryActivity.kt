package com.incwelltechnology.nres.view.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.incwelltechnology.nres.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

    }

    companion object {
        private const val ID = "id"
        fun start(context: Context, id: String) {
            var intent = Intent(context, CategoryActivity::class.java).apply {
                putExtra(ID, id)
            }
            context.startActivity(intent)
        }
    }
}
