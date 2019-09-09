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
            for (rep in numberOfReps downTo 1) {
                actions.add(
                    Action(
                        ActionType.Hang,
                        hangTime,
                        rep,
                        numberOfReps,
                        numberOfSets
                    )
                )

                if (rep != 1) {
                    actions.add(
                        Action(
                            ActionType.Rest,
                            repsRestTime,
                            rep - 1,
                            numberOfReps,
                            numberOfSets
                        )
                    )
                }
            }

            actions.add(
                Action(
                    ActionType.EndOfSetRest,
                    restTimeBetweenSets,
                    set,
                    numberOfReps,
                    numberOfSets
                )
            )
        }
    }
}