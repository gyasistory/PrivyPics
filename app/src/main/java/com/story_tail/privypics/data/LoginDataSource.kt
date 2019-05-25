package com.story_tail.privypics.data

import com.google.firebase.auth.FirebaseAuth
import com.story_tail.privypics.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val mAuth = FirebaseAuth.getInstance()
            mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mAuth.currentUser?.let { user ->
                        Result.Success(LoggedInUser(user.uid, user.displayName ?: ""))
                    }
                } else {
                    Result.Error(IOException("Error logging in"))
                }
            }
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

