package com.slowmonkeycodes.workouttimers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var countOnElapsedTimeTimerButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countOnElapsedTimeTimerButton = findViewById(R.id.count_on_elapsed_time_timer_button)

        countOnElapsedTimeTimerButton.setOnClickListener {
            val intent = Intent(this, CountOnElapseTimeTimerSetupActivity::class.java).apply {
            }

            startActivity(intent)
        }
    }
}
