package com.slowmonkeycodes.workouttimers.fingerboardtimer

open class Action constructor(
    private val actionType: ActionType,
    private val timeInSeconds: Int,
    private val itemNumber: Int,
    private val totalReps: Int,
    private val totalSets: Int) {

    fun getFingerboardActionCategoryType() : ActionTypeCategory {
        if (actionType == ActionType.EndOfSetRest) {
            return ActionTypeCategory.Set
        }

        return ActionTypeCategory.Rep
    }

    fun getStatusString() : String {
        return when(actionType) {
            ActionType.Hang -> "Hang $itemNumber of $totalReps"
            ActionType.Rest -> "Rest $itemNumber of $totalReps (Rep)"
            ActionType.EndOfSetRest -> "Rest $itemNumber of $totalSets (Set)"
        }
    }

    fun getTimeInSeconds() : Int {
        return timeInSeconds
    }
}