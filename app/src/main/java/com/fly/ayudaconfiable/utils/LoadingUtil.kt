package com.fly.ayudaconfiable.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import com.fly.ayudaconfiable.R


object LoadingUtil {
    private var progressDialog: AlertDialog? = null

    @Synchronized
    fun showLoading() {
        LogUtils.d("activity ："+ActivityManager.getCurrentActivity())
        var context = ActivityManager.getCurrentActivity() ?: return
        if (context is Activity) {
            if (context.isFinishing) return
        } else {
            return
        }
        initLoading(context)
        try {
            progressDialog?.let {
                if (!it.isShowing) {
                    it.show()
                }
            }
        } catch (e: Exception) {
        }
    }

    @Synchronized
    fun dismissProgress() {
        try {
            progressDialog?.let {
                if (it.isShowing) {
                    val context = (it.context as ContextWrapper).baseContext
                    if (context is Activity) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            if (!context.isFinishing && !context.isDestroyed) it.dismiss()
                        } else {
                            it.dismiss()
                        }
                    } else it.dismiss()
                }
            }
        } catch (e: IllegalArgumentException) {
            // Handle or log or ignore
        } catch (e: Throwable) {
            // Handle or log or ignore
        } finally {
            progressDialog = null
        }
    }

    @Synchronized
    private fun initLoading(context: Context) {
        if (progressDialog == null) {
            val builder = AlertDialog.Builder(context,R.style.LoadingStyle)
                .setView(R.layout.layout_loading)
            builder.setCancelable(true)
            progressDialog = builder.create()
        }
    }
}