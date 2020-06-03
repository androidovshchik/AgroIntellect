package ru.agrointellect.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dates.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseDialogFragment

class DatesDialog : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        super.onCreateView(inflater, root, bundle)
        return inflater.inflate(R.layout.fragment_dates, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cv_dates
    }
}