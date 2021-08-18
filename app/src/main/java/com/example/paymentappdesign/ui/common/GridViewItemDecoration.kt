package com.example.paymentappdesign.ui.common

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridViewItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = 50
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) % 2 == 0) {
            // Even Item -> 0 , 2 , 4 , 6
            outRect.apply {
                left = 50
                right = 25
            }
        } else {
            // Odd Item -> 1, 3, 5, 7
            outRect.apply {
                left = 25
                right = 50
            }
        }
    }
}