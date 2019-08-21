package com.slowmonkeycodes.workouttimers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import com.slowmonkeycodes.workouttimers.fingerboardtimer.Action
import com.slowmonkeycodes.workouttimers.fingerboardtimer.Workout

class FingerboardTimerActivity : AppCompatActivity() {
    private var hangTime: Int = 0
    private var repsRestTime: Int = 0
    private var numberOfReps: Int = 0
    private var numberOfSets: Int = 0
    private var restBetweenSets: Int = 0

    private lateinit var countDownTimer: CountDownTimer
    private lateinit var countDownTimerTextView: TextView
    private lateinit var currentStatusTextView: TextView
    private lateinit var currentActionTextView: TextView
    private lateinit var startWorkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerboard_timer)

        hangTime = intent.getIntExtra("hangTime", 60)
        repsRestTime = intent.getIntExtra("repsRestTime", 60)
        numberOfReps = intent.getIntExtra("numberOfReps", 60)
        numberOfSets = intent.getIntExtra("numberOfSets", 60)
        restBetweenSets = intent.getIntExtra("restBetweenSets", 60)

        val fingerboardWorkout =
            Workout(
                numberOfReps,
                numberOfSets,
                hangTime,
                repsRestTime,
                restBetweenSets
            )

        startWorkoutButton = findViewById(R.id.start_workout_button)

        startWorkoutButton.setOnClickListener {
            for (actions: Action in fingerboardWorkout.actions) {

            }
        }
    }
}
