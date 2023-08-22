package com.tiehearts.ui.splash

import androidx.lifecycle.ViewModel
import com.tiehearts.utils.SharedPrefrence
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val sharedPrefrence: SharedPrefrence
) :ViewModel() {
    val loggedIn =  false
}