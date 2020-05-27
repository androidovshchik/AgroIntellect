@file:Suppress("unused", "DEPRECATION")

package ru.agrointellect.extension

import android.net.ConnectivityManager

val ConnectivityManager.isConnected: Boolean
    get() = activeNetworkInfo?.isConnected == true