package com.example.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            calculateTip()
        }
        binding.totalBillEditText.setOnKeyListener {
            view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
    }

    private fun calculateTip() {
        val strTotalBill = binding.totalBillEditText.text.toString()
        val dblTotalBill = strTotalBill.toDoubleOrNull()

        val dblPercent = when (binding.tipOptions.checkedRadioButtonId){
            R.id.thirtyPercent -> 0.30
            R.id.twentyFivePercent -> 0.25
            R.id.twentyPercent -> 0.20
            R.id.eighteenPercent -> 0.18
            else -> 0.15
        }

        if (dblTotalBill == null){
            binding.tipResult.text = ""
            return
        }

        var dblTip = dblPercent * dblTotalBill

        if (binding.roundUp.isChecked){
            dblTip = ceil(dblTip)
        }

        val dblFormattedTip = NumberFormat.getCurrencyInstance().format(dblTip)
        binding.tipResult.text = getString(R.string.tipResult, dblFormattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER){
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}