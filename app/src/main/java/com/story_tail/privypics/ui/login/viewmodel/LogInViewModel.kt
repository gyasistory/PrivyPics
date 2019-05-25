package com.story_tail.privypics.ui.login.viewmodel

import androidx.lifecycle.ViewModel

class LogInViewModel(private val listener: LogInListener) : ViewModel() {
    var email: String? = null
    var password: String? = null

    fun onSignInClick() {
        listener.onLogInClick(email, password)
    }
}
