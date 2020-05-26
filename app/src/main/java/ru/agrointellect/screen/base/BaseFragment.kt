package ru.agrointellect.screen.base

import android.os.Bundle
import androidx.fragment.app.Fragment

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseFragment : Fragment() {

    protected val args: Bundle
        get() = arguments ?: Bundle()
}