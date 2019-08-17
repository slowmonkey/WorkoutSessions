package com.slowmonkeycodes.workouttimers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var newWorkoutSessionButton : Button
    private lateinit var viewWorkoutSessionButton : Button

    private lateinit var runWorkoutTimer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newWorkoutSessionButton = findViewById(R.id.new_workout_session_button)
        viewWorkoutSessionButton = findViewById(R.id.view_workout_sessions_button)

        // Going to just run an individual timer for now.

        runWorkoutTimer = findViewById(R.id.run_workout_timer_button)

        newWorkoutSessionButton.setOnClickListener {
            val intent = Intent(this, WorkoutSessionActivity::class.java).apply {
            }
            startActivity(intent)
        }

        // TODO: Add functionality for this button. Disabled for now.

        viewWorkoutSessionButton.isEnabled = false

        runWorkoutTimer.setOnClickListener {
            val intent = Intent(this, CountOnElapseTimeTimerSetupActivity::class.java).apply {
            }

            startActivity(intent)
        }
    }
}
