package com.lucksoft.commonui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.lucksoft.commonui.R

class LoadingView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0)

    init {
        LayoutInflater.from(context).inflate(R.layout.common_loading_view, this, true)
        isClickable = false
    }
}