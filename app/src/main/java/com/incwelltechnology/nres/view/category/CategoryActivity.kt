package com.incwelltechnology.nres.view.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.incwelltechnology.nres.R
import com.incwelltechnology.nres.services.RestService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import retrofit2.HttpException

class CategoryActivity : AppCompatActivity() {
    private val service: RestService by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        CoroutineScope(Dispatchers.IO).launch {
            val categories = service.getCategoryAsync()
            withContext(Dispatchers.Main) {
                try {
                    var result = categories.await()
                    Log.d("CategoryActivity", "" + result)
                } catch (e: HttpException) {
                    Toast.makeText(
                        this@CategoryActivity,
                        "" + e.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                } catch (e: Throwable) {
                    Toast.makeText(
                        this@CategoryActivity,
                        "" + e.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

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
