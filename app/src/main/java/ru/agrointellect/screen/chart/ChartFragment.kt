package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseFragment

class ChartFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return inflater.inflate(R.layout.fragment_report, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}