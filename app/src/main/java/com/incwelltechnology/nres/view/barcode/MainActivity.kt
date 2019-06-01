package com.incwelltechnology.nres.view.barcode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.vision.barcode.Barcode
import com.incwelltechnology.nres.R
import com.incwelltechnology.nres.view.category.CategoryActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val RC_BARCODE_CAPTURE = 9001
    private val TAG = "BarcodeMain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read_barcode.setOnClickListener {
            val intent = Intent(this, BarcodeCaptureActivity::class.java)
            intent.putExtra(BarcodeCaptureActivity.AutoFocus, auto_focus.isChecked)
            intent.putExtra(BarcodeCaptureActivity.UseFlash, use_flash.isChecked)
            startActivityForResult(intent, RC_BARCODE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val barcode = data.getParcelableExtra<Barcode>(BarcodeCaptureActivity.BarcodeObject)
                    status_message!!.setText(R.string.barcode_success)
                    barcode_value!!.text = barcode.displayValue
                    Log.d(TAG, "Barcode read: " + barcode.displayValue)

                    CategoryActivity.start(this, barcode.displayValue)

                } else {
                    status_message!!.setText(R.string.barcode_failure)
                    Log.d(TAG, "No barcode captured, intent data is null")
                }
            } else {
                status_message!!.text = String.format(
                    getString(R.string.barcode_error),
                    CommonStatusCodes.getStatusCodeString(resultCode)
                )
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
