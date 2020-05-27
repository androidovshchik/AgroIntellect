package ru.agrointellect.screen.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseFragment : Fragment(), KodeinAware {

    override val kodein by closestKodein()

    protected val args: Bundle
        get() = arguments ?: Bundle()
}