package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    enum class TimerState {
        Stopped, Paused, Running
    }

    private lateinit var sessionButton: Button
    private lateinit var sessionTimer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resetWorkout()

        sessionButton.setOnClickListener {
            view ->
            startSessionTimer()
        }
    }

    private fun resetWorkout() {
        sessionTimer = object: Timer() {
            over
        }
    }

    private fun startSessionTimer() {

    }
}
