@file:Suppress("DEPRECATION")

package ru.agrointellect.extension

inline fun androidx.fragment.app.FragmentManager.transact(
    commit: Boolean = true,
    action: androidx.fragment.app.FragmentTransaction.() -> Unit
) {
    beginTransaction().apply {
        action()
        if (commit) {
            commitAllowingStateLoss()
            executePendingTransactions()
        }
    }
}

inline fun android.app.FragmentManager.transactLegacy(
    commit: Boolean = true,
    action: android.app.FragmentTransaction.() -> Unit
) {
    beginTransaction().apply {
        action()
        if (commit) {
            commitAllowingStateLoss()
            executePendingTransactions()
        }
    }
}