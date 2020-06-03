package ru.agrointellect.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.layout_calendar_container.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseDialogFragment

class DatesDialog : BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return inflater.inflate(R.layout.dialog_dates, root, false)
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
        rlHeaderCalendar.isVisible = false
        imgVNavLeft.isVisible = false
        imgVNavRight.isVisible = false
    }
}