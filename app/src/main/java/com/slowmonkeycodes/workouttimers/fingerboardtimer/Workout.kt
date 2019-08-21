package com.slowmonkeycodes.workouttimers.fingerboardtimer

open class Workout constructor(
    numberOfReps: Int,
    numberOfSets: Int,
    hangTime: Int,
    repsRestTime: Int,
    restTimeBetweenSets: Int
) {

    val actions: MutableList<Action> = emptyList<Action>().toMutableList()

    init {
        for (set in numberOfSets downTo 1) {
            for (rep in numberOfReps downTo 1) {
                actions.add(
                    Action(
                        ActionType.Hang,
                        hangTime,
                        rep
                    )
                )
                actions.add(
                    Action(
                        ActionType.Rest,
                        repsRestTime,
                        rep
                    )
                )
            }

            actions.add(
                Action(
                    ActionType.EndOfSetRest,
                    restTimeBetweenSets,
                    set
                )
            )
        }
    }
}