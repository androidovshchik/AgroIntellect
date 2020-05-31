package ru.agrointellect.screen.chart

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.screen.base.BaseFragment

class ChartFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "График"
        }
        return inflater.inflate(R.layout.fragment_chart, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}