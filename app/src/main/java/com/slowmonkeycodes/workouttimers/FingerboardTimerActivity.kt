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
    private var timerIndex: Int = 0

    private val countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerboard_timer)

        countDownTimerTextView = findViewById(R.id.count_down_timer_text_view)
        currentStatusTextView = findViewById(R.id.workout_status_text_view)
        currentActionTextView = findViewById(R.id.current_action_text_view)


        hangTime = intent.getIntExtra("hangTime", 5)
        repsRestTime = intent.getIntExtra("repsRestTime", 3)
        numberOfReps = intent.getIntExtra("numberOfReps", 2)
        numberOfSets = intent.getIntExtra("numberOfSets", 3)
        restBetweenSets = intent.getIntExtra("restBetweenSets", 10)

        val fingerboardWorkout =
            Workout(
                numberOfReps,
                numberOfSets,
                hangTime,
                repsRestTime,
                restBetweenSets
            )

        createCountDownTimer(fingerboardWorkout, timerIndex)

        startWorkoutButton = findViewById(R.id.start_workout_button)

        startWorkoutButton.setOnClickListener {
            currentStatusTextView.text = fingerboardWorkout.actions[timerIndex].getActionTypeAsString()
            // Count down to start.
            countDownTimer.start()
        }
    }

    fun createCountDownTimer(workout: Workout, timerIndex: Int) {
        val countDownTime: Int = workout.actions[timerIndex].getTimeInSeconds()
        countDownTimerTextView.text = countDownTime.toString()
        currentStatusTextView.text = workout.actions[timerIndex].getActionTypeAsString()
        countDownTimer = object: CountDownTimer((countDownTime * 1000).toLong(), countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
//                timeLeftOnTimer = millisUntilFinished
                val timeLeft = millisUntilFinished / 1000
                countDownTimerTextView.text = timeLeft.toString()
            }

            override fun onFinish() {
                this@FingerboardTimerActivity.timerIndex += 1
                if (workout.actions.size <= this@FingerboardTimerActivity.timerIndex) {
                    return
                }
                createCountDownTimer(workout, this@FingerboardTimerActivity.timerIndex)
                countDownTimer.start()
            }
        }
    }
}
