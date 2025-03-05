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

class Forearms : AppCompatActivity() {

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var videoFrame: View
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forearms)

        img1 = findViewById(R.id.wc)
        img2 = findViewById(R.id.rbc)
        videoFrame = findViewById(R.id.videoFrame)
        videoView = findViewById(R.id.videoView)

        img1.setOnClickListener{
            showVideoFrame1()
        }
        img2.setOnClickListener{
            showVideoFrame2()
        }



        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
        }

    }

    private fun showVideoFrame1() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.wrist_curls
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame2() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.reverse_bb_curl
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