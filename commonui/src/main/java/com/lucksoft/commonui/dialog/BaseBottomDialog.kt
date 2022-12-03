package com.lucksoft.commonui.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.lucksoft.commonui.R

open class BaseBottomDialog<VB : ViewBinding>(
    context: Context,
    private val inflate: (LayoutInflater) -> VB,
    styleRes: Int = R.style.bottom_dialog_base) : BaseDialog<VB>(context, inflate, styleRes) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val attributes = window?.attributes
        attributes?.gravity = Gravity.BOTTOM
        attributes?.width = context.resources.displayMetrics.widthPixels
        window?.attributes = attributes
    }
}