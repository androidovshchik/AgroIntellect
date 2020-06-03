package ru.agrointellect.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView
import kotlinx.android.synthetic.main.layout_calendar_container.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseDialogFragment

class DatesDialog : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        super.onCreateView(inflater, root, bundle)
        return DateRangeCalendarView(requireContext()).apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                dismiss()
            }
            inflateMenu(R.menu.menu_dates)
            setOnMenuItemClickListener {
                if (it.itemId == R.id.action_done) {
                    dismiss()
                }
                return@setOnMenuItemClickListener true
            }
        }
    }
}