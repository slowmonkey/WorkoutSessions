package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkoutTimersListActivity : AppCompatActivity() {

    private lateinit var cancelAddWorkoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_timers_list)

        cancelAddWorkoutButton = findViewById(R.id.cancel_add_workout_button)

        cancelAddWorkoutButton.setOnClickListener {
            finish()
        }
    }
}
