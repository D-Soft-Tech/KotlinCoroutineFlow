package com.example.kotlinflow

sealed class RemoteApiCallStates {
    data class Success<out T>(val data: T) : RemoteApiCallStates()
    data class Error(val data: String) : RemoteApiCallStates()
    object Loading : RemoteApiCallStates()
    object DoingNothingAtTheMoment : RemoteApiCallStates()
}
