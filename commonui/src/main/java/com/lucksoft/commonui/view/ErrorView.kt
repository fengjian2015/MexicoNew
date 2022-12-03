package com.lucksoft.commonui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.lucksoft.commonui.R

class ErrorView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet): this(context, attrs, 0)

    private var mErrorBtn: TextView
    private var mErrorImg: ImageView
    private var mErrorText: TextView
    private var mRootView: View

    init {
        LayoutInflater.from(context).inflate(R.layout.common_empty_view, this, true)
        isClickable = true
        mErrorBtn = findViewById(R.id.common_empty_btn)
        mRootView = findViewById(R.id.common_empty_root_view)
        mErrorImg = findViewById(R.id.common_empty_img)
        mErrorText = findViewById(R.id.common_empty_text)
        if (this.background == null) {
            setBackgroundResource(R.color.white)
        }
    }

    fun showEmptyBtn(imageRes: Int, emptyBtnText: String?, listener: (() -> Unit)?) {
        mErrorText.visibility = GONE
        mErrorImg.visibility = VISIBLE
        mErrorBtn.visibility = VISIBLE
        mErrorBtn.text = emptyBtnText
        mErrorImg.setImageResource(imageRes)
        mErrorBtn.setOnClickListener { listener?.invoke() }
    }

    fun showEmptyBtn(imageRes: Int, emptyText: String?) {
        mErrorText.visibility = VISIBLE
        mErrorImg.visibility = VISIBLE
        mErrorBtn.visibility = GONE
        mErrorText.text = emptyText
        mErrorImg.setImageResource(imageRes)
    }

    fun showEmptyBtn(
        imageRes: Int,
        emptyBtnText: String?,
        emptyText: String?,
        listener: (() -> Unit)?
    ) {
        mErrorText.visibility = VISIBLE
        mErrorImg.visibility = VISIBLE
        mErrorBtn.visibility = VISIBLE
        mErrorText.text = emptyText
        mErrorBtn.text = emptyBtnText
        mErrorImg.setImageResource(imageRes)
        mErrorBtn.setOnClickListener { listener?.invoke() }
    }

    fun showEmptyText(text: String?) {
        mErrorImg.visibility = GONE
        mErrorBtn.visibility = GONE
        mErrorText.visibility = VISIBLE
        mErrorText.text = text
        mErrorBtn.setOnClickListener(null)
    }

    fun showEmptyImg(img: Int) {
        mErrorImg.visibility = VISIBLE
        mErrorBtn.visibility = GONE
        mErrorText.visibility = GONE
        mErrorImg.setImageResource(img)
        mErrorBtn.setOnClickListener(null)
    }

    fun showEmptyImageText(imageRes: Int, text: String?) {
        mErrorBtn.visibility = GONE
        mErrorText.visibility = VISIBLE
        mErrorImg.visibility = VISIBLE
        mErrorImg.setImageResource(imageRes)
        mErrorText.text = text
        mErrorBtn.setOnClickListener(null)
    }

    fun setBgResource(resource: Int) {
        mRootView.setBackgroundResource(resource)
    }
}