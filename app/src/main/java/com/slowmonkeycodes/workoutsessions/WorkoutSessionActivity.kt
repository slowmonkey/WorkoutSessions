package com.slowmonkeycodes.workoutsessions

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkoutSessionActivity : AppCompatActivity() {

    private lateinit var startNewSessionButton: Button
    private lateinit var finishSessionButton: Button
    private lateinit var pauseResumeSessionButton: Button
    private lateinit var restartSessionButton: Button

    private lateinit var addWorkoutButton: Button

    private lateinit var sessionTimer: StopWatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_session)


        sessionTimer = object : StopWatch(findViewById(R.id.session_timer)) {
        }

        startNewSessionButton = findViewById(R.id.start_session_button)
        finishSessionButton = findViewById(R.id.finish_session_button)
        pauseResumeSessionButton = findViewById(R.id.pause_resume_session_button)
        restartSessionButton = findViewById(R.id.restart_session_button)
        addWorkoutButton = findViewById(R.id.add_workout_button)

        startNewSessionButton.setOnClickListener {
            sessionTimer.start()
        }

        finishSessionButton.setOnClickListener {
            sessionTimer.stop()
        }

        pauseResumeSessionButton.setOnClickListener {
            when (sessionTimer.pauseOrResume()) {
                StopWatch.PauseResumePostAction.SetToPause -> {
                    pauseResumeSessionButton.text = getString(R.string.pause_resume_resume_button)
                }
                StopWatch.PauseResumePostAction.SetToResume -> {
                    pauseResumeSessionButton.text = getString(R.string.pause_resume_pause_button)
                }
                StopWatch.PauseResumePostAction.DoNothing -> {
                    // Do Nothing
                }
            }
        }

        restartSessionButton.setOnClickListener {
            sessionTimer.reset()
            pauseResumeSessionButton.text = getString(R.string.pause_resume_pause_button)
        }

        addWorkoutButton.setOnClickListener {
            val intent = Intent(this, WorkoutTimersListActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}
