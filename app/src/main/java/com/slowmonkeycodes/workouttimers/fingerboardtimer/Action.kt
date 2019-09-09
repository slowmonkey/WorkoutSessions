package com.slowmonkeycodes.workouttimers.fingerboardtimer

open class Action constructor(
    val actionType: ActionType,
    private val timeInSeconds: Int,
    private val itemNumber: Int,
    private val totalReps: Int,
    private val totalSets: Int) {

    fun getStatusString() : String {
        return when(actionType) {
            ActionType.Hang -> "Hang #$itemNumber"
            ActionType.Rest -> "Rest #$itemNumber (Rep)"
            ActionType.EndOfSetRest -> "Rest #$itemNumber (Set)"
        }
    }

    fun getTimeInSeconds() : Int {
        return timeInSeconds
    }
}