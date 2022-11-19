package com.fly.ayudaconfiable.web

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.ConsoleMessage.MessageLevel
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.fly.ayudaconfiable.utils.ActivityManager
import com.fly.ayudaconfiable.utils.CommonUtil
import com.fly.ayudaconfiable.utils.DateTool
import com.fly.ayudaconfiable.utils.LogUtils
import com.fly.ayudaconfiable.weight.IWebView
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import java.io.File
import java.io.IOException

class IWebChromeClient constructor(iWebView: IWebView) : WebChromeClient() {
    private var webView: WebView? = null
    private var lineProgressbar: ProgressBar? = null
    private var fullFrameLayout: FrameLayout? = null
    private var callback: CustomViewCallback? = null
    private var context:Context?=null
    private var mCameraPhotoPath: String? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null

    init {
        webView = iWebView.getWebView()
        lineProgressbar = iWebView.getProgressbar()
        fullFrameLayout = iWebView.getFullFrameLayout()
        context = webView!!.context
    }

    override fun onProgressChanged(webView: WebView?, newProgress: Int) {
        super.onProgressChanged(webView, newProgress)
        lineProgressbar?.visibility = View.VISIBLE
        lineProgressbar?.progress = newProgress
        if (newProgress >= 80) {
            lineProgressbar?.visibility = View.GONE
        }
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
        val sb = StringBuffer()
        sb.append("\n|")
        sb.append("|------------------------------------------------------------------------------------------------------------------|")
        sb.append("\n|")
        sb.append("|\tmessage->" + consoleMessage.message())
        sb.append("\n|")
        sb.append("|\tsourceId->" + consoleMessage.sourceId())
        sb.append("\n|")
        sb.append("|\tlineNumber->" + consoleMessage.lineNumber())
        sb.append("\n|")
        sb.append("|\tmessageLevel->" + consoleMessage.messageLevel())
        sb.append("\n|")
        sb.append("|----------------------------------------------------------------------------------------------------------------|")
        when (consoleMessage.messageLevel()) {
            MessageLevel.ERROR -> LogUtils.e("consoleMessage:$sb")
            MessageLevel.WARNING -> LogUtils.w("consoleMessage:$sb")
            else -> LogUtils.d("consoleMessage:$sb")
        }
        return super.onConsoleMessage(consoleMessage)
    }

    override fun onHideCustomView() {
        LogUtils.d("onHideCustomView:")
        if (callback != null) {
            callback?.onCustomViewHidden()
        }
        webView?.visibility = View.VISIBLE
        fullFrameLayout?.removeAllViews()
        fullFrameLayout?.visibility = View.GONE
        super.onHideCustomView()
    }


    override fun onShowCustomView(view: View?, customViewCallback: CustomViewCallback) {
        LogUtils.d("onShowCustomView:")
        webView?.visibility = View.GONE
        fullFrameLayout?.visibility = View.VISIBLE
        fullFrameLayout?.removeAllViews()
        fullFrameLayout?.addView(view)
        callback = customViewCallback
        super.onShowCustomView(view, customViewCallback)
    }

    override fun onShowCustomView(view: View?, i: Int, customViewCallback: CustomViewCallback) {
        LogUtils.d("onShowCustomView:")
        webView?.visibility = View.GONE
        fullFrameLayout?.visibility = View.VISIBLE
        fullFrameLayout?.removeAllViews()
        fullFrameLayout?.addView(view)
        callback = customViewCallback
        super.onShowCustomView(view, i, customViewCallback)
    }

    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.Group.STORAGE)
            .permission(Permission.CAMERA)
            .request { permissions, all ->
                if (all) {
                    if (mFilePathCallback != null) {
                        mFilePathCallback!!.onReceiveValue(null)
                    }
                    mFilePathCallback = filePathCallback

                    var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (takePictureIntent.resolveActivity(context!!.getPackageManager()) != null) {
                        var photoFile: File? = null
                        try {
                            photoFile = File(
                                CommonUtil.getImageDir(),
                                DateTool.getServerTimestamp().toString() + ".jpg"
                            )
                            takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
                        } catch (ex: IOException) {
                            // Error occurred while creating the File
                            Log.e("WebViewSetting", "Unable to create Image File", ex)
                        }
                        mCameraPhotoPath = "file:" + photoFile?.absolutePath
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile))
                    }
                    startActivityForResult(takePictureIntent, 1232)
                }
            }
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }

    private fun startActivityForResult(intent: Intent, code: Int) {
        if (context is Activity) {
            val activity = context as Activity
            activity.startActivityForResult(intent, code)
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if (requestCode == 1232 && mFilePathCallback != null) {
            // 5.0的回调
            var results: Array<Uri>? = null

            // Check that the response is a good one
            if (resultCode == Activity.RESULT_OK) {
                if (data == null) {
                    // If there is not data, then we may have taken a photo
                    if (mCameraPhotoPath != null) {
                        results = arrayOf(Uri.parse(mCameraPhotoPath))
                    }
                } else {
                    data.data
                    val dataString = data.dataString
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
            mFilePathCallback!!.onReceiveValue(results)
            mFilePathCallback = null
        }
    }
}
