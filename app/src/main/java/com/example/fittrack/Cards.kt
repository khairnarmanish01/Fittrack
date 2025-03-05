package com.example.fittrack

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Cards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)


        var bmi= findViewById<ImageView>(R.id.imageView1)
        var pedo= findViewById<ImageView>(R.id.imageView2)
        var work= findViewById<ImageView>(R.id.imageView3)
        var diet= findViewById<ImageView>(R.id.imageView4)
        var water= findViewById<ImageView>(R.id.imageView5)

        var txtBmi= findViewById<TextView>(R.id.textBMI)
        var txtPedo= findViewById<TextView>(R.id.textPedo)
        var txtWork= findViewById<TextView>(R.id.textWork)
        var txtDiet= findViewById<TextView>(R.id.textDiet)
        var txtWater= findViewById<TextView>(R.id.textWater)

        bmi.setOnClickListener {
            val bmi= Intent(this,BMIactivity::class.java)
            startActivity(bmi)
        }

        pedo.setOnClickListener {
            val pedo= Intent(this, PedoSense::class.java)
            startActivity(pedo)
        }

        work.setOnClickListener {
            val work= Intent(this, workout::class.java)
            startActivity(work)
        }

        diet.setOnClickListener {
            val diet= Intent(this, Diet::class.java)
            startActivity(diet)
        }

        water.setOnClickListener {
            val water= Intent(this, waterIntake::class.java)
            startActivity(water)
        }

        txtBmi.setOnClickListener {
            val bmi= Intent(this,BMIactivity::class.java)
            startActivity(bmi)
        }

        txtPedo.setOnClickListener {
            val pedo= Intent(this, PedoSense::class.java)
            startActivity(pedo)
        }

        txtWork.setOnClickListener {
            val work= Intent(this, workout::class.java)
            startActivity(work)
        }

        txtDiet.setOnClickListener {
            val diet= Intent(this, Diet::class.java)
            startActivity(diet)
        }

        txtWater.setOnClickListener {
            val water= Intent(this, waterIntake::class.java)
            startActivity(water)
        }



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                startActivity(Intent(this@Cards, LoginActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}