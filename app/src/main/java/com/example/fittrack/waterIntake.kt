package com.example.fittrack

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import java.util.Calendar

class waterIntake : AppCompatActivity() {

    lateinit var PB: ProgressBar
    lateinit var ad50: LinearLayout
    lateinit var ad100: LinearLayout
    lateinit var ad150: LinearLayout
    lateinit var ad200: LinearLayout
    lateinit var ad250: LinearLayout
    lateinit var ad300: LinearLayout
    lateinit var TI: TextView
    lateinit var btn: Button
    lateinit var TR: EditText
    lateinit var PR: TextView

    private lateinit var sharedPreferences: SharedPreferences
    private val progressKey = "water_progress"
    private var dailyResetTime = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_intake)

        PB = findViewById(R.id.intakeProgress)
        ad50 = findViewById(R.id.op50ml)
        ad100 = findViewById(R.id.op100ml)
        ad150 = findViewById(R.id.op150ml)
        ad200 = findViewById(R.id.op200ml)
        ad250 = findViewById(R.id.op250ml)
        ad300 = findViewById(R.id.opCustom)
        PR = findViewById(R.id.tvIntook)
        btn = findViewById(R.id.buttonSet)
        TR = findViewById(R.id.trText)
        TI = findViewById(R.id.tvTotalIntake)
        val wr=findViewById<TextView>(R.id.warn)

        btn.setOnClickListener {
            val s = TR.text.toString()

            if(s.isEmpty()){
               wr.text = "Please enter your target"
                return@setOnClickListener
            }


            var st= s.toInt()
            PB.max=st
            TI.text="/$st ml"

        }

        sharedPreferences = getSharedPreferences("water_intake_prefs", Context.MODE_PRIVATE)

        // Reset progress daily
        resetProgressIfNecessary()

        // Restore progress
        val savedProgress = sharedPreferences.getInt(progressKey, 0)
        PB.progress = savedProgress
        PR.text = "$savedProgress ml"

        ad50.setOnClickListener {
            updateProgress(50)
        }
        ad100.setOnClickListener {
            updateProgress(100)
        }
        ad150.setOnClickListener {
            updateProgress(150)
        }
        ad200.setOnClickListener {
            updateProgress(200)
        }
        ad250.setOnClickListener {
            updateProgress(250)
        }
        ad300.setOnClickListener {
            updateProgress(300)
        }
    }

    private fun updateProgress(amount: Int) {
        val currentProgress = PB.progress
        val newProgress = currentProgress + amount
        PB.progress = newProgress
        PR.text = "$newProgress ml"
        saveProgress(newProgress)
    }

    private fun saveProgress(progress: Int) {
        sharedPreferences.edit().putInt(progressKey, progress).apply()
    }

    private fun resetProgressIfNecessary() {
        val currentTime = Calendar.getInstance()
        if (currentTime.timeInMillis - dailyResetTime.timeInMillis >= 24 * 60 * 60 * 1000) {
            // Reset steps if a new day has started
            sharedPreferences.edit().remove(progressKey).apply()
            dailyResetTime = currentTime
        }
    }
}
