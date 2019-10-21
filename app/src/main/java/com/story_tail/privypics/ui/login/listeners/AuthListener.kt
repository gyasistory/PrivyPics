package com.story_tail.privypics.ui.login.listeners

interface AuthListener {
    fun onSuccess()
    fun onFail()
    fun onError(error: String)
}