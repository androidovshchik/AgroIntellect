package ru.agrointellect.extension

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

@SuppressLint("RestrictedApi")
fun NavController.navigateExclusive(@IdRes resId: Int, args: Bundle? = null) {
    if (currentDestination?.id != resId) {
        try {
            getBackStackEntry(resId)
            popBackStack(resId, false)
            return
        } catch (ignored: Throwable) {
        }
        navigate(resId, args)
    }
}