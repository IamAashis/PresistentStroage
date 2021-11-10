package com.aashis.scheduleprefence.util

import android.content.Context
import android.content.SharedPreferences
import com.aashis.scheduleprefence.constants.PreferenceConstants

object PreferenceUtils {

    private fun getPreference(context: Context?): SharedPreferences? =
        context?.getSharedPreferences(PreferenceConstants.prefFileName, Context.MODE_PRIVATE)

    private fun getPreferenceData(context: Context?): SharedPreferences? =
        context?.getSharedPreferences(PreferenceConstants.prefFileData, Context.MODE_PRIVATE)


    fun setLoginState(context: Context?, state: Boolean) {
        val editor = getPreference(context)?.edit()
        editor?.putBoolean(PreferenceConstants.isLoggedIn, state)
        editor?.apply()
    }

    fun getLoginState(context: Context?) =
        getPreference(context)?.getBoolean(PreferenceConstants.isLoggedIn, false)?: false



    fun removeLoginState(context: Context?) {
        getPreference(context)?.edit()?.remove(PreferenceConstants.isLoggedIn)?.apply()
    }
}