package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Chronometer

class CountOnElapsedTimeTimerActivity : AppCompatActivity() {

    private lateinit var workoutTimer : StopWatch
    private lateinit var startPauseResumeWorkoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_on_elapsed_time_timer)

        workoutTimer = object : StopWatch(findViewById(R.id.count_on_every_elapsed_time_timer)) {
        }
        startPauseResumeWorkoutButton = findViewById(R.id.start_pause_resume_workout_button)

        startPauseResumeWorkoutButton.setOnClickListener {
            when (workoutTimer.getStopWatchState()) {
                StopWatch.TimerState.NotStarted -> {
                    workoutTimer.start()
                    startPauseResumeWorkoutButton.text = getString(R.string.pause_workout_button)
                }
                StopWatch.TimerState.Running -> {
                    workoutTimer.pauseOrResume()
                    startPauseResumeWorkoutButton.text = getString(R.string.resume_workout_button)
                }
                StopWatch.TimerState.Paused -> {
                    workoutTimer.pauseOrResume()
                    startPauseResumeWorkoutButton.text = getString(R.string.pause_workout_button)
                }
                StopWatch.TimerState.Stopped -> {
                    // Do nothing
                }
            }
        }
    }
}
