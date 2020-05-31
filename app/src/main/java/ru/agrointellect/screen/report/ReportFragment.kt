package ru.agrointellect.screen.report

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.recyclical.setup
import kotlinx.android.synthetic.main.fragment_report.*
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.screen.base.BaseFragment

class ReportFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Отчёт"
        }
        return inflater.inflate(R.layout.fragment_report, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_data.setup {

        }
    }
}