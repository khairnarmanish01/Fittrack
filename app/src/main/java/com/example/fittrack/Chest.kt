package com.example.fittrack

import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class Chest : AppCompatActivity() {

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var videoFrame: View
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chest)

        img1 = findViewById(R.id.imgBP)
        img2 = findViewById(R.id.imgIBP)
        img3 = findViewById(R.id.imgCfly)
        img4 = findViewById(R.id.imgPDfly)
        img5 = findViewById(R.id.imgChDip)
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
        img5.setOnClickListener{
            showVideoFrame5()
        }

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
        }

    }

    private fun showVideoFrame1() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.bench_press
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame2() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.inc_bp
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame3() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.cable_fly
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame4() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.peckdeck_fly
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()
    }
    private fun showVideoFrame5() {
        videoFrame.visibility = View.VISIBLE
        val videoPath = "android.resource://" + packageName + "/" + R.raw.chest_dip
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