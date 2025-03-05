package com.example.fittrack

import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Legs : AppCompatActivity() {
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var videoFrame: View
    private lateinit var videoView: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legs)

        img1 = findViewById(R.id.lp)
        img2 = findViewById(R.id.bbsq)
        img3 = findViewById(R.id.lc)
        img4 = findViewById(R.id.cr)
        videoFrame = findViewById(R.id.videoFrame)
        videoView = findViewById(R.id.videoView)

        img1.setOnClickListener{
            showVideoFrame1()
        }
        img2.setOnClickListener{
            showVideoFrame2()
        }
        img3.setOnClickListener{
            showVideoFrame3()
        }
        img4.setOnClickListener{
            showVideoFrame4()
        }

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
        }

    }

    private fun showVideoFrame1() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.leg_press
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame2() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.bb_squats
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame3() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.leg_curls
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame4() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.calf_raises
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN && videoFrame.visibility == View.VISIBLE){
            videoFrame.visibility = View.GONE
            val videoView: VideoView = findViewById(R.id.videoView)
            videoView.stopPlayback()
            return true
        }


        return super.onTouchEvent(event)
    }

}