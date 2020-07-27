package com.example.windowshopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import com.example.windowshopper.R.id.calculateBtn
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val viewModel = WindowShopperViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hourlyWageText = findViewById<TextInputLayout>(R.id.hourly_wage)
        val itemPriceText = findViewById<TextInputLayout>(R.id.item_price)
        val calculateButton = findViewById<Button>(R.id.calculateBtn)

        calculateButton.setOnClickListener {

            itemPriceText.editText?.onEditorAction(EditorInfo.IME_ACTION_DONE)

            val hourlywage = hourlyWageText.editText?.text?.toString()?.toDoubleOrNull() ?: 0.0
            val itemPrice = itemPriceText.editText?.text?.toString()?.toDoubleOrNull() ?: 0.0

            val hours = viewModel.calculateNumberOfHours(hourlywage,itemPrice)
            handleHours(hours)

        }
    }

    private fun handleHours(hours:Double) {

        val hoursText = findViewById<TextView>(R.id.hours_number)
        val hoursLabel = findViewById<TextView>(R.id.hours_label)
        val clearButton = findViewById<TextView>(R.id.clear_button)
        val  calculateButton = findViewById<Button>(R.id.calculateBtn)

           hoursText.text = hours?.toString()
        hoursText.visibility = View.VISIBLE
        hoursLabel.visibility = View.VISIBLE
        clearButton.visibility = View.VISIBLE
        clearButton.setOnClickListener {
            reset()
        }

        calculateButton.visibility = View.GONE

    }

    private fun reset(){

        val hoursText = findViewById<TextView>(R.id.hours_number)
        val hoursLabel = findViewById<TextView>(R.id.hours_label)
        val clearButton = findViewById<TextView>(R.id.clear_button)
        val  calculateButton = findViewById<Button>(R.id.calculateBtn)
        val hourlyWageText = findViewById<TextInputLayout>(R.id.hourly_wage)
        val itemPriceText = findViewById<TextInputLayout>(R.id.item_price)



       hoursText.visibility = View.GONE
        hoursLabel.visibility = View.GONE
        clearButton.visibility = View.GONE
        calculateButton.visibility = View.VISIBLE

        hourlyWageText.editText?.text = null
        itemPriceText.editText?.text = null


    }




}