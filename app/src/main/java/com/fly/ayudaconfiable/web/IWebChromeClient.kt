package com.fly.ayudaconfiable.web

import android.app.Activity
import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.ConsoleMessage.MessageLevel
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.core.content.FileProvider
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.utils.CommonUtil
import com.fly.ayudaconfiable.utils.CommonUtil.getImageDir
import com.fly.ayudaconfiable.utils.LogUtils
import com.fly.ayudaconfiable.weight.IWebView
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import java.io.File

class IWebChromeClient constructor(iWebView: IWebView) : WebChromeClient() {
    private var webView: WebView? = null
    private var lineProgressbar: ProgressBar? = null
    private var fullFrameLayout: FrameLayout? = null
    private var callback: CustomViewCallback? = null
    private var context:Context?=null
    private var mCameraPhotoPath: String? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
     var INPUT_FILE_REQUEST_CODE : Int = 1025;
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
        mFilePathCallback = filePathCallback;
        openAlbum()
        return true;
    }

    private fun openAlbum() {
        XXPermissions.with(context)
            .permission(Permission.CAMERA)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: List<String>, all: Boolean) {
                    openCamera()
                }

                override fun onDenied(permissions: List<String>, never: Boolean) {
                    if (mFilePathCallback != null) {
                        mFilePathCallback!!.onReceiveValue(null)
                    }
                }
            })
    }

    private var cameraFile: File? = null
    private fun openCamera() {
        try {
            val filePath = getImageDir()
            val fileName = System.currentTimeMillis().toString() + ".jpg"
            cameraFile = File(filePath + fileName)
            val imageUri: Uri = FileProvider.getUriForFile(
                MyApplication.application,
                CommonUtil.getProviderString(), cameraFile!!
            )
            val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(captureIntent, INPUT_FILE_REQUEST_CODE)
        } catch (e: Exception) {
            e.printStackTrace()
            if (mFilePathCallback != null) {
                mFilePathCallback!!.onReceiveValue(null)
            }
        }
    }

    private fun startActivityForResult(intent: Intent, code: Int) {
        if (context is Activity) {
            val activity = context as Activity
            activity.startActivityForResult(intent, code)
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == INPUT_FILE_REQUEST_CODE && mFilePathCallback != null) {
            chooseAbove(resultCode, data)
        } else {

        }
    }

    private fun chooseAbove(resultCode: Int, data: Intent?) {
        if (Activity.RESULT_OK == resultCode) {
//            updatePhotos();
            if (data != null) {
//                处理选择的照片
                val results: Array<Uri>
                val uriData = data.data
                if (uriData != null) {
                    results = arrayOf(uriData)
                    try {
                        val compressImageUri = BitmapUtil.compressBmpFromBmp(uriToString(uriData))
                        mFilePathCallback!!.onReceiveValue(arrayOf(compressImageUri))
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                        //                        requestWritePermission();
                    }
                } else {
                    mFilePathCallback!!.onReceiveValue(null)
                }
            } else {
//                处理拍照的照片
                try {
                    val compressImageUri = BitmapUtil.compressBmpFromBmp(cameraFile!!.absolutePath)
                    mFilePathCallback!!.onReceiveValue(arrayOf(compressImageUri))
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    //                    requestWritePermission();
                }
            }
        } else {
            mFilePathCallback!!.onReceiveValue(null)
        }
        mFilePathCallback = null
    }


    private fun uriToString(uri: Uri): String? {
        var path: String? = null
        if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                // ExternalStorageProvider
                if ("com.android.externalstorage.documents" == uri.authority) {
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    val type = split[0]
                    if ("primary".equals(type, ignoreCase = true)) {
                        path = Environment.getExternalStorageDirectory().toString() + "/" + split[1]
                    }
                } else if ("com.android.providers.downloads.documents" == uri.authority) {
                    // DownloadsProvider
                    val id = DocumentsContract.getDocumentId(uri)
                    val contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        java.lang.Long.valueOf(id)
                    )
                    path = context?.let { getDataColumn(it, contentUri, "",
                        emptyArray()
                    ) }
                } else if ("com.android.providers.media.documents" == uri.authority) {
                    // MediaProvider
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":").toTypedArray()
                    val type = split[0]
                    var contentUri: Uri? = null
                    if ("image" == type) {
                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    } else if ("video" == type) {
                        contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                    } else if ("audio" == type) {
                        contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                    }
                    val selection = "_id=?"
                    val selectionArgs = arrayOf(split[1])
                    path = contentUri?.let { context?.let { it1 -> getDataColumn(it1, it, selection, selectionArgs) } }
                }
            } else {
                path = context?.let { getRealPathFromUri(it, uri) }
            }
        }
        return path
    }


    private fun getRealPathFromUri(context: Context, contentUri: Uri): String? {
        var cursor: Cursor? = null
        return try {
            val proj = arrayOf(MediaStore.Files.FileColumns.DATA)
            cursor = context.contentResolver.query(contentUri, proj, null, null, null)
            val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)
            cursor.moveToFirst()
            cursor.getString(column_index)
        } finally {
            cursor?.close()
        }
    }

    private fun getDataColumn(
        context: Context,
        uri: Uri,
        selection: String,
        selectionArgs: Array<String>
    ): String? {
        var cursor: Cursor? = null
        val column = "_data"
        val projection = arrayOf(column)
        try {
            cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
            if (cursor != null && cursor.moveToFirst()) {
                val column_index = cursor.getColumnIndexOrThrow(column)
                return cursor.getString(column_index)
            }
        } finally {
            cursor?.close()
        }
        return null
    }
}
