package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.TextView

class CountOnElapsedTimeTimerActivity : AppCompatActivity() {

    private lateinit var workoutTimer: StopWatch
    private lateinit var startPauseResumeWorkoutButton: Button
    private lateinit var counterTextView: TextView
    private var countOnElapsedTime: Int = 60
    private var repCount: Int = 0
    private var firstTick: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_on_elapsed_time_timer)

        repCount = 0
        firstTick = true

        countOnElapsedTime = intent.getIntExtra("countOnEveryElapsedTime", 60)
        counterTextView = findViewById(R.id.counter_text_view)
        counterTextView.text = repCount.toString()

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

        workoutTimer.stopwatch.onChronometerTickListener =
            OnChronometerTickListener { chronometer ->
                val elapsedSeconds = (SystemClock.elapsedRealtime() - chronometer.base) / 1000

                if (elapsedSeconds.rem(countOnElapsedTime).toInt() == 0) {
                    incrementRepCount()
                }
            }
    }

    private fun incrementRepCount() {
        // There is some weird bug which calls the listener twice when the elapsedSeconds is 0.
        // This also causes some discernible lag from the 0 to 1 second tick.
        // TODO: Fix discernible lag from the 0 to 1 second tick.

        if (firstTick) {
            firstTick = false
            return
        }
        repCount += 1
        counterTextView.text = repCount.toString()
    }
}
