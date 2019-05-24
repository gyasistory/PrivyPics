package com.story_tail.privypics.ui.login

import android.os.Bundle
import com.story_tail.privypics.base.ui.BaseActivity
import com.story_tail.privypics.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}


