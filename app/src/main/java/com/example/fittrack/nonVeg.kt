package com.example.fittrack

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class nonVeg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_veg)

        var m= findViewById<TextView>(R.id.mbd)
        var f= findViewById<TextView>(R.id.fld)
        var l= findViewById<TextView>(R.id.lmd)

        m.setOnClickListener {
            val veg= Intent(this,nonMuscle::class.java)
            startActivity(veg)
        }

        f.setOnClickListener {
            val nVeg= Intent(this, nonFat::class.java)
            startActivity(nVeg)
        }

        l.setOnClickListener {
            val nVeg= Intent(this, nonLean::class.java)
            startActivity(nVeg)
        }

    }
}