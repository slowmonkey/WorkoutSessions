package com.slowmonkeycodes.workouttimers

import android.os.SystemClock
import android.widget.Chronometer

// cite: https://stackoverflow.com/questions/5594877/android-chronometer-pause
// Obtained answer from: https://stackoverflow.com/users/686720/henriks

open class StopWatch constructor(chronometer: Chronometer) {
    enum class TimerState {
        NotStarted, Stopped, Paused, Running
    }

    enum class PauseResumePostAction {
        SetToPause, SetToResume, DoNothing
    }

    private val stopwatch: Chronometer = chronometer
    private var timeWhenStopped: Long = 0
    private var stopwatchState: TimerState = TimerState.NotStarted

    fun start() {
        if (stopwatchState != TimerState.NotStarted) {
            return
        }

        stopwatchState = TimerState.Running
        stopwatch.base = SystemClock.elapsedRealtime()
        stopwatch.start()
    }

    fun getStopWatchState() : TimerState {
        return stopwatchState
    }

    fun pauseOrResume(): PauseResumePostAction {
        return when(stopwatchState) {
            TimerState.Running -> {
                pause()
                PauseResumePostAction.SetToPause
            }
            TimerState.Paused -> {
                resume()
                PauseResumePostAction.SetToResume
            }
            else -> {
                PauseResumePostAction.DoNothing
            }
        }
    }

    private fun pause() {
        if (stopwatchState != TimerState.Running || stopwatchState == TimerState.Stopped) {
            return
        }

        this.timeWhenStopped = stopwatch.base - SystemClock.elapsedRealtime()
        stopwatchState = TimerState.Paused
        stopwatch.stop()
    }

    private fun resume() {
        if (stopwatchState != TimerState.Paused || stopwatchState == TimerState.Stopped) {
            return
        }

        stopwatch.base = SystemClock.elapsedRealtime() + this.timeWhenStopped
        stopwatch.start()
        stopwatchState = TimerState.Running
    }

    fun stop() {
        if (stopwatchState == TimerState.NotStarted) {
            return
        }

        if (stopwatchState != TimerState.Running && stopwatchState != TimerState.Paused) {
            return
        }

        stopwatchState = TimerState.Stopped
        stopwatch.stop()
    }

    fun reset() {
        stopwatch.base = SystemClock.elapsedRealtime()
        this.timeWhenStopped = 0
        stopwatchState = TimerState.NotStarted
        stopwatch.stop()
    }

    fun onChronometerTickListener(chronometerTickListener : Chronometer.OnChronometerTickListener) {
        stopwatch.onChronometerTickListener = chronometerTickListener
    }
}