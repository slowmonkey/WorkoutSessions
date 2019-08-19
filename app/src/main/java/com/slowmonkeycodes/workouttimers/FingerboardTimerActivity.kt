package com.slowmonkeycodes.workouttimers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class FingerboardTimerActivity : AppCompatActivity() {

    private var setCount: Int = 0
    private var repCount: Int = 0
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var countDownTimerTextView: TextView
    private lateinit var currentStatusTextView: TextView
    private lateinit var currentActionTextView: TextView
    private lateinit var startWorkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerboard_timer)


    }
}
