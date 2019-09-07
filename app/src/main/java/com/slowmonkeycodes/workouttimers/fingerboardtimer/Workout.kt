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
        var setNumber = 1
        for (set in numberOfSets downTo 1) {
            var repNumber = 1
            for (rep in numberOfReps downTo 1) {
                actions.add(
                    Action(
                        ActionType.Hang,
                        hangTime,
                        repNumber,
                        numberOfReps,
                        numberOfSets
                    )
                )
                actions.add(
                    Action(
                        ActionType.Rest,
                        repsRestTime,
                        repNumber,
                        numberOfReps,
                        numberOfSets
                    )
                )

                repNumber += 1
            }

            actions.add(
                Action(
                    ActionType.EndOfSetRest,
                    restTimeBetweenSets,
                    setNumber,
                    numberOfReps,
                    numberOfSets
                )
            )
            setNumber += 1
        }
    }
}