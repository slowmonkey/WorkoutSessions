package com.slowmonkeycodes.workouttimers

open class FingerboardWorkout constructor(
    numberOfReps: Int,
    numberOfSets: Int,
    hangTime: Int,
    repsRestTime: Int,
    restTimeBetweenSets: Int
) {

    val actions: MutableList<FingerboardAction> = emptyList<FingerboardAction>().toMutableList()

    init {
        for (set in numberOfSets downTo 1) {
            for (rep in numberOfReps downTo 1) {
                actions.add(FingerboardAction(FingerboardActionType.Hang, hangTime, rep))
                actions.add(FingerboardAction(FingerboardActionType.Rest, repsRestTime, rep))
            }

            actions.add(
                FingerboardAction(
                    FingerboardActionType.EndOfSetRest,
                    restTimeBetweenSets,
                    set
                )
            )
        }
    }
}