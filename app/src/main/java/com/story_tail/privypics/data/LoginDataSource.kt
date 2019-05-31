package com.story_tail.privypics.data

import com.google.firebase.auth.FirebaseAuth
import com.story_tail.privypics.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {
    val mAuth by lazy { FirebaseAuth.getInstance() }

    fun login(username: String, password: String): Result<LoggedInUser> {
        var result: Result<LoggedInUser>? = null
        val signInTask = mAuth.signInWithEmailAndPassword(username, password)
        if (signInTask.isSuccessful) {
            mAuth.currentUser?.let { user ->
                result = Result.Success(LoggedInUser(user.uid, user.displayName ?: ""))
            }
        } else {
            val task = mAuth.createUserWithEmailAndPassword(username, password)
            if (task.isSuccessful) {
                mAuth.currentUser?.let { user ->
                    result = Result.Success(LoggedInUser(user.uid, user.displayName ?: ""))
                }
            } else {

                result = Result.Error(IOException("Error logging in", task.exception))
            }
        }
        return result ?: Result.Error(IOException("Error logging in"))
    }

    fun logout() {
        mAuth.signOut()
    }
}

