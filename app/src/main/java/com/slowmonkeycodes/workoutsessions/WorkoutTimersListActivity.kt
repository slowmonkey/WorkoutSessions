package com.slowmonkeycodes.workoutsessions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class WorkoutTimersListActivity : AppCompatActivity() {

    private lateinit var cancelAddWorkoutButton : Button
    private lateinit var availableWorkoutsScrollView : ScrollView
    private lateinit var availableWorkoutsLinearLayout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_timers_list)

        availableWorkoutsLinearLayout = findViewById(R.id.available_workouts_linear_layout)
        addAvailableWorkoutItemsToScrollView(availableWorkoutsLinearLayout)

        cancelAddWorkoutButton = findViewById(R.id.cancel_add_workout_button)

        cancelAddWorkoutButton.setOnClickListener {
            finish()
        }
    }

    private fun addAvailableWorkoutItemsToScrollView(linearLayout: LinearLayout) {
        val availableWorkoutItems = arrayOf(
            "Fingerboard Hang Timer",
            "On Minute Timer"
        )

        for (textItem in availableWorkoutItems) {
            val textView = TextView(this)
            textView.text = textItem

            linearLayout.addView(textView)
        }
    }
}
