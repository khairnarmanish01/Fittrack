package com.example.fittrack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class BMIactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiactivity)

        val height= findViewById<EditText>(R.id.etHeight)
        val weight= findViewById<EditText>(R.id.etWeight)
        val btnCalc= findViewById<TextView>(R.id.btnBMI)
        val resultText= findViewById<TextView>(R.id.tVResult)
        val rate = findViewById<TextView>(R.id.tvRate)

        btnCalc.setOnClickListener {
            val heightText = height.text.toString()
            val weightText = weight.text.toString()

            if (heightText.isEmpty() || weightText.isEmpty()) {
                // Display a message to the user indicating that fields are empty
                resultText.text = "Please enter both height and weight"
                rate.text = ""
                return@setOnClickListener
            }

            val h = heightText.toFloat() / 100
            val w = weightText.toFloat()

            val r = w / (h * h)
            val r1 = "%.2f".format(r)
            resultText.text = "Your BMI is $r1"

            // Set the BMI rate based on the calculated BMI value
            if (r < 18.5) {
                rate.text = "Underweight"
                rate.setTextColor(Color.YELLOW)
            } else if (r >= 18.5 && r <= 24.9) {
                rate.text = "Normal Weight"
                rate.setTextColor(Color.GREEN)
            } else if (r >= 25 && r <= 29.9) {
                rate.text = "Overweight"
                rate.setTextColor(Color.RED)
            } else {
                rate.text = "Obesity"
                rate.setTextColor(Color.RED)
            }
        }

    }
}