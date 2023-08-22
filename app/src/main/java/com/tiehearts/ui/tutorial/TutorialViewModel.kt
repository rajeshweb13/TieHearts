package com.tiehearts.ui.tutorial

import androidx.lifecycle.ViewModel
import com.tiehearts.utils.SharedPrefrence
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialViewModel @Inject constructor(
    val sharedPrefrence: SharedPrefrence
) :ViewModel() {
}