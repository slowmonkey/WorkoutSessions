package com.slowmonkeycodes.workoutsessions

import android.os.SystemClock
import android.widget.Chronometer

open class StopWatch constructor(chronometer: Chronometer) {
    enum class TimerState {
        Stopped, Paused, Running
    }

    private val stopwatch: Chronometer = chronometer
    private var timeWhenStopped: Long = 0
    private var stopwatchState: TimerState = TimerState.Stopped

    fun start() {
        if (stopwatchState == TimerState.Running) {
            return
        }

        if (stopwatchState == TimerState.Paused) {
            this.resume()
            return
        }

        stopwatch.start()
        stopwatchState = TimerState.Running
    }

    fun stop() {
        if (stopwatchState != TimerState.Running) {
            return
        }
        
        this.timeWhenStopped = stopwatch.base - SystemClock.elapsedRealtime()
        stopwatchState = TimerState.Paused
        stopwatch.stop()
    }

    fun reset() {
        stopwatch.base = SystemClock.elapsedRealtime()
        this.timeWhenStopped = 0
        stopwatchState = TimerState.Stopped
        stopwatch.stop()
    }

    private fun resume() {
        stopwatch.base = SystemClock.elapsedRealtime() + this.timeWhenStopped
        stopwatch.start()
        stopwatchState = TimerState.Running
    }
}