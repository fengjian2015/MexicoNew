package com.lucksoft.commonui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.lucksoft.commonui.R

open class BaseDialog<VB : ViewBinding>(
    context: Context,
    private val inflate: (LayoutInflater) -> VB,
    styleRes: Int = R.style.dialog_base) : Dialog(context, styleRes) {

    protected lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }
}