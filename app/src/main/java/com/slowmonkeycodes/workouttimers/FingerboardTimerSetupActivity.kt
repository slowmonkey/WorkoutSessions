package com.slowmonkeycodes.workouttimers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FingerboardTimerSetupActivity : AppCompatActivity() {

    private lateinit var hangTime : TextView
    private lateinit var repsRestTime: TextView
    private lateinit var numberOfReps: TextView
    private lateinit var numberOfSets: TextView
    private lateinit var restBetweenSets: TextView

    private lateinit var startWorkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerboard_timer_setup)

        hangTime = findViewById(R.id.hang_time_text_view)
        repsRestTime = findViewById(R.id.reps_rest_time_text_view)
        numberOfReps = findViewById(R.id.number_of_reps_label)
        numberOfSets = findViewById(R.id.number_of_sets_text_view)
        restBetweenSets = findViewById(R.id.rest_time_between_sets_text_view)

        startWorkoutButton = findViewById(R.id.start_workout_button)

        startWorkoutButton.setOnClickListener {

            // TODO: Validation of the component's values

            val intent = Intent(this, CountOnElapsedTimeTimerActivity::class.java).apply {
            }
            intent.putExtra("hangTime", Integer.parseInt(hangTime.text.toString()))
            intent.putExtra("repsRestTime", Integer.parseInt(repsRestTime.text.toString()))
            intent.putExtra("numberOfReps", Integer.parseInt(numberOfReps.text.toString()))
            intent.putExtra("numberOfSets", Integer.parseInt(numberOfSets.text.toString()))
            intent.putExtra("restBetweenSets", Integer.parseInt(restBetweenSets.text.toString()))
            startActivity(intent)
        }

    }
}
