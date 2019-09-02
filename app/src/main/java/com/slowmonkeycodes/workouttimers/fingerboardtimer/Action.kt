package com.slowmonkeycodes.workouttimers.fingerboardtimer

open class Action constructor(
    private val actionType: ActionType,
    private val timeInSeconds: Int,
    private val itemNumber: Int) {

    fun getFingerboardActionCategoryType() : ActionTypeCategory {
        if (actionType == ActionType.EndOfSetRest) {
            return ActionTypeCategory.Set
        }

        return ActionTypeCategory.Rep
    }

    fun getActionTypeAsString() : String {
        return when(actionType) {
            ActionType.Hang -> "Hang"
            ActionType.Rest -> "Rest (Rep)"
            ActionType.EndOfSetRest -> "Rest (Set)"
        }
    }

    fun getTimeInSeconds() : Int {
        return timeInSeconds
    }
}