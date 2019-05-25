package com.story_tail.privypics.ui.login

import android.os.Bundle
import android.widget.Toast
import com.story_tail.privypics.base.ui.BaseActivity
import com.story_tail.privypics.databinding.ActivityLoginBinding
import com.story_tail.privypics.ui.login.viewmodel.LogInListener
import com.story_tail.privypics.ui.login.viewmodel.LogInViewModel


class LoginActivity : BaseActivity(), LogInListener {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.viewModel = LogInViewModel(this)
        setContentView(binding.root)
    }

    override fun onLogInClick(email: String?, password: String?) {
        Toast.makeText(
            this,
            String.format("Email => %s \n Password => %s", email, password),
            Toast.LENGTH_LONG
        ).show()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


