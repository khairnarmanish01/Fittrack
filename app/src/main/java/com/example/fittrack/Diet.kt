package com.example.fittrack

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Diet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet)


            var veg= findViewById<ImageView>(R.id.imgVeg)
            var nVeg= findViewById<ImageView>(R.id.imgNveg)

            veg.setOnClickListener {
                val veg= Intent(this,Veg::class.java)
                startActivity(veg)
            }

            nVeg.setOnClickListener {
                val nVeg= Intent(this, nonVeg::class.java)
                startActivity(nVeg)
            }

    }
}