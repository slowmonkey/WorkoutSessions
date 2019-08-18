package com.slowmonkeycodes.workouttimers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import android.widget.Chronometer.OnChronometerTickListener as OnChronometerTickListener1

class CountOnElapsedTimeTimerActivity : AppCompatActivity() {

    private lateinit var workoutTimer: StopWatch
    private lateinit var startPauseResumeWorkoutButton: Button
    private lateinit var counterTextView: TextView
    private var countOnElapsedTime: Int = 60
    private var repCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_on_elapsed_time_timer)

        repCount = 0

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
                    incrementRepCount()
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

        workoutTimer.onChronometerTickListener(OnChronometerTickListener1 { chronometer ->
            val elapsedSeconds = (SystemClock.elapsedRealtime() - chronometer.base) / 1000

            if (elapsedSeconds.rem(countOnElapsedTime).toInt() == 0 && elapsedSeconds.toInt() != 0) {
                incrementRepCount()
            }
        })
    }

    private fun incrementRepCount() {
        repCount += 1
        counterTextView.text = repCount.toString()
    }
}
