package com.example.fittrack

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.VideoView

class workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        var ch= findViewById<TextView>(R.id.tvChest)
        var tr= findViewById<TextView>(R.id.tvTricep)
        var sh= findViewById<TextView>(R.id.tvShoulders)
        var bac= findViewById<TextView>(R.id.tvBack)
        var bic= findViewById<TextView>(R.id.tvBiceps)
        var lg= findViewById<TextView>(R.id.tvLegs)
        var wst= findViewById<TextView>(R.id.tvWaist)
        var frm= findViewById<TextView>(R.id.tvForearms)

        ch.setOnClickListener{
            var ch= Intent(this, Chest::class.java)
            startActivity(ch)
        }

        tr.setOnClickListener{
            var tr= Intent(this, Triceps::class.java)
            startActivity(tr)
        }

        sh.setOnClickListener{
            var sh= Intent(this, Shoulders::class.java)
            startActivity(sh)
        }

        bac.setOnClickListener{
            var bac= Intent(this, Back::class.java)
            startActivity(bac)
        }

        bic.setOnClickListener{
            var bic= Intent(this, Biceps::class.java)
            startActivity(bic)
        }

        lg.setOnClickListener{
            var lg= Intent(this, Legs::class.java)
            startActivity(lg)
        }

        wst.setOnClickListener{
            var wst= Intent(this, Waist::class.java)
            startActivity(wst)
        }

        frm.setOnClickListener{
            var frm= Intent(this, Forearms::class.java)
            startActivity(frm)
        }



    }
}