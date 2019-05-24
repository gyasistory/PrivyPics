package com.story_tail.privypics.ui.login.viewmodel;

import androidx.lifecycle.ViewModel;

public class LogInViewModel extends ViewModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void onSignInClick() {

    }
}
