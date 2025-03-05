package com.example.fittrack

import android.content.Context
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class PedoSense : AppCompatActivity(), SensorEventListener {

    private lateinit var tv: TextView
    private lateinit var pb: ProgressBar

    private var sensorManager: SensorManager? = null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private lateinit var sharedPreferences: SharedPreferences
    private val stepsKey = "total_steps"
    private val maxStepsKey = "max_steps"
    private var dailyResetTime = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedo_sense)

        tv = findViewById(R.id.tv_stepsTaken)
        pb = findViewById(R.id.progress_circular)
        sharedPreferences = getSharedPreferences("pedometer_prefs", Context.MODE_PRIVATE)

        loadSavedData()
        resetStepsIfNecessary()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        resetStepsIfNecessary()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            Toast.makeText(this, "No sensor found", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for step counter sensor
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running) {
            totalSteps = event!!.values[0]
            val currentSteps: Int = (totalSteps - previousTotalSteps).toInt()
            tv.text = currentSteps.toString()

            pb.apply {
                progress = currentSteps
            }

            // Code for setting target and updating UI
            val trg = findViewById<EditText>(R.id.targs)
            val arr = findViewById<ImageView>(R.id.arr)
            val target = findViewById<TextView>(R.id.textViewTR)
            val wr = findViewById<TextView>(R.id.warn)

            arr.setOnClickListener {
                val targ = trg.text.toString()

                if (targ.isEmpty()) {
                    wr.text = "Please enter your target"
                    return@setOnClickListener
                }

                val d = targ.toInt()
                pb.max = d
                pb.apply {
                    progress = currentSteps.toFloat().toInt()
                }
                target.text = "/$d"

            }
        }
    }

    private fun resetStepsIfNecessary() {
        val currentTime = Calendar.getInstance()
        if (currentTime.timeInMillis - dailyResetTime.timeInMillis >= 24 * 60 * 60 * 1000) {
            // Reset steps if a new day has started
            resetSteps()
            sharedPreferences.edit().remove(stepsKey).apply()
            sharedPreferences.edit().remove(maxStepsKey).apply()
            dailyResetTime = currentTime
        }
    }

    private fun loadSavedData() {
        val savedSteps = sharedPreferences.getFloat(stepsKey, 0f)
        previousTotalSteps = savedSteps
        val savedMaxSteps = sharedPreferences.getInt(maxStepsKey, 2500)
        pb.max = savedMaxSteps
        findViewById<EditText>(R.id.targs).setText(savedMaxSteps.toString())
        findViewById<TextView>(R.id.textViewTR).text = "/$savedMaxSteps"
    }

    private fun saveData() {
        sharedPreferences.edit().putFloat(stepsKey, previousTotalSteps).apply()
        val maxSteps = findViewById<EditText>(R.id.targs).text.toString().toIntOrNull() ?: 2500
        sharedPreferences.edit().putInt(maxStepsKey, maxSteps).apply()
        pb.max = maxSteps
        findViewById<TextView>(R.id.textViewTR).text = "/$maxSteps"
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun resetSteps() {
        tv.setOnClickListener {
            Toast.makeText(this, "No sensor detected", Toast.LENGTH_SHORT).show()
        }
        tv.setOnLongClickListener {
            previousTotalSteps = totalSteps
            tv.text = "0"
            saveData()
            true
        }
    }
}
