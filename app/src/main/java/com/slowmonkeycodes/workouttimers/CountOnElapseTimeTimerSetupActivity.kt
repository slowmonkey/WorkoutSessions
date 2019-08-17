package com.slowmonkeycodes.workouttimers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CountOnElapseTimeTimerSetupActivity : AppCompatActivity() {

    private lateinit var countOnEveryElapsedTime: EditText
    private lateinit var startWorkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_on_elasped_time_timer_setup)

        countOnEveryElapsedTime = findViewById(R.id.count_on_every_elapsed_time)
        startWorkoutButton = findViewById(R.id.start_workout_button)

        startWorkoutButton.setOnClickListener {

            // TODO: validation of county every value

            val intent = Intent(this, CountOnElapsedTimeTimerActivity::class.java).apply {
            }
            intent.putExtra("countOnEveryElapsedTime", Integer.parseInt(countOnEveryElapsedTime.text.toString()))
            startActivity(intent)
        }
    }
}
