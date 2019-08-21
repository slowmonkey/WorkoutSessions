package com.slowmonkeycodes.workouttimers

open class FingerboardAction constructor(
    private val actionType: FingerboardActionType,
    private val timeInSeconds: Int,
    private val itemNumber: Int) {

    fun getFingerboardActionCategoryType() : FingerboardActionCategoryType {
        if (actionType == FingerboardActionType.EndOfSetRest) {
            return FingerboardActionCategoryType.Set
        }

        return FingerboardActionCategoryType.Rep
    }
}