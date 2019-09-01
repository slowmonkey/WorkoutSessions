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

    fun getTimeInSeconds() : Int {
        return timeInSeconds
    }
}