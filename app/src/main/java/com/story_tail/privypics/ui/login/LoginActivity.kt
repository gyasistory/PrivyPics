package com.story_tail.privypics.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.crashlytics.android.Crashlytics
import com.story_tail.privypics.R
import com.story_tail.privypics.base.ui.BaseActivity
import io.fabric.sdk.android.Fabric


class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        Fabric.with(this, Crashlytics())
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)


    }
}


