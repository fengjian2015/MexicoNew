package com.fly.ayudaconfiable.js

import android.app.Activity
import android.content.Context
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.fly.ayudaconfiable.js.bean.CallBackJSBean
import com.fly.ayudaconfiable.utils.LogUtils
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object AndroidCallBackJS {
    val SUCCESS: String = "200"
    val ERROR_NET: String = "201"
    val EROOR_PERMISSIONS: String = "202"
    val EROOR_OTHER: String = "203"

    fun callBackJsSuccess(webView: WebView, id: String, event: String) {
        callBackJs(webView, CallBackJSBean(id, event))
    }

    fun callBackJsSuccess(webView: WebView, id: String, event: String,data:String) {
        callBackJs(webView, CallBackJSBean(id, event,data,SUCCESS,null))
    }

    fun callBackJsErrorNet(webView: WebView, id: String, event: String) {
        callBackJs(webView, CallBackJSBean(id, event, null, ERROR_NET, null))
    }

    fun callBackJsSuccess(webView: WebView, id: String, event: String, fragment : Fragment) {
        callBackJs(webView, CallBackJSBean(id, event))
    }

    fun callBackJsSuccess(webView: WebView, id: String, event: String,data:String,activity : Activity) {
        callBackJs(webView, CallBackJSBean(id, event,data,SUCCESS,null))
    }

    fun callBackJsErrorNet(webView: WebView, id: String, event: String,context: Context) {
        callBackJs(webView, CallBackJSBean(id, event, null, ERROR_NET, null))
    }

    fun callbackJsErrorPermissions(webView: WebView, id: String, event: String) {
        callBackJs(webView, CallBackJSBean(id, event, null, EROOR_PERMISSIONS, null))
    }

    fun callbackJsErrorOther(webView: WebView, id: String, event: String, errorMsg: String) {
        callBackJs(webView, CallBackJSBean(id, event, null, EROOR_OTHER, errorMsg))
    }

    fun callBackJs(webView: WebView, model: CallBackJSBean?) {
        callBackJs(webView, model, null)
    }

    private fun callBackJs(webView: WebView, model: CallBackJSBean?, callback: ValueCallback<*>?) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val toJson = Gson().toJson(model)
                LogUtils.d("js回传：$toJson")
                val js = "javascript: window.MoxiCallJS && window.MoxiCallJS($toJson);"
                webView.evaluateJavascript(js, callback as ValueCallback<String>?)
            } catch (w: Throwable) {
            }
        }
    }
}