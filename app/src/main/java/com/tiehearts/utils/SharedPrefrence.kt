package com.tiehearts.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.barcodeapp.utils.Constants
import javax.inject.Inject


class SharedPrefrence @Inject constructor(
     context: Context
) {

   var sharedPreferences    =   context.getSharedPreferences("appname", MODE_PRIVATE);


    fun userIsLoogedIn(): Boolean {
        return sharedPreferences.getBoolean(Constants.USER_IS_LOOGED_IN, false)
    }

    fun setIsUserLoggedIn(boolean: Boolean) {
        sharedPreferences.edit().putBoolean(Constants.USER_IS_LOOGED_IN,boolean).apply()
    }

    fun setUserID(username: Int) {
        sharedPreferences.edit().putInt(Constants.USER_ID,username).apply()
    }

    fun getUserID():Int{
        return sharedPreferences.getInt(Constants.USER_ID, 0)
    }
}