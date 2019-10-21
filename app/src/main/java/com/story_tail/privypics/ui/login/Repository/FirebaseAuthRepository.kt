package com.story_tail.privypics.ui.login.Repository

import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import com.story_tail.privypics.ui.login.listeners.AuthListener

class FirebaseAuthRepository(private val firebaseAuthListener: AuthListener) {
    private val firbaseAuth by lazy { FirebaseAuth.getInstance() }

    fun logInUser(username: String, password: String) {
        firbaseAuth.signInWithEmailAndPassword(username, password)
            .addOnSuccessListener { firebaseAuthListener.onSuccess() }
            .addOnFailureListener {
                firebaseAuthListener.onFail()
                firebaseAuthListener.onError(it.localizedMessage ?: "")
            }
    }

    fun createUser(username: String, password: String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            firebaseAuthListener.onError("Not a valid Email")
            return
        }

        firbaseAuth.createUserWithEmailAndPassword(username, password)
            .addOnFailureListener {
                firebaseAuthListener.onError(it.localizedMessage ?: "")
                firebaseAuthListener.onFail()
            }
            .addOnSuccessListener { firebaseAuthListener.onSuccess() }
    }
}
