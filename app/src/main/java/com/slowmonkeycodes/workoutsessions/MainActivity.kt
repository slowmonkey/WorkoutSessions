package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var sessionPlayButton: ImageButton
    private lateinit var sessionStopButton: ImageButton
    private lateinit var sessionResetButton: ImageButton
    private lateinit var sessionTimer: StopWatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionTimer = object: StopWatch(findViewById(R.id.session_timer)) {

        }

        sessionPlayButton = findViewById(R.id.session_play_button)
        sessionStopButton = findViewById(R.id.session_stop_button)
        sessionResetButton = findViewById(R.id.session_reset_button)

        sessionPlayButton.setOnClickListener {
            view ->
            startSessionTimer()
        }

        sessionStopButton.setOnClickListener {
            view ->
            sessionTimer.stop()
        }

        sessionResetButton.setOnClickListener {
            view ->
            sessionTimer.reset()
        }
    }

    private fun startSessionTimer() {
        sessionTimer.start()
    }
}
