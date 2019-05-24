package com.story_tail.privypics.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.crashlytics.android.Crashlytics
import com.story_tail.privypics.R
import com.story_tail.privypics.base.ui.BaseActivity
import com.story_tail.privypics.databinding.ActivityLoginBinding
import io.fabric.sdk.android.Fabric


class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}


