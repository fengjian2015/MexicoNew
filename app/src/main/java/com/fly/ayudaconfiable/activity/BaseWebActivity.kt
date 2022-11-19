package com.fly.ayudaconfiable.activity

import android.content.Intent
import android.view.KeyEvent
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import com.fly.ayudaconfiable.BatteryChangeReceiver
import com.fly.ayudaconfiable.R
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.databinding.ActivityBaseWebBinding
import com.fly.ayudaconfiable.js.AndroidJS
import com.fly.ayudaconfiable.utils.BatteryUtil
import com.fly.ayudaconfiable.utils.SoftKeyboardUtils
import com.fly.ayudaconfiable.web.IWebSetting
import com.fly.ayudaconfiable.weight.IWebView
import com.gyf.immersionbar.ImmersionBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BaseWebActivity : BaseActivity<ActivityBaseWebBinding>(ActivityBaseWebBinding::inflate),
    IWebView.OnTitleListener {
    var isHome: Boolean = false
    var webUrl: String = ""
    private lateinit var appJS:AndroidJS
    private lateinit var batteryChangeReceiver:BatteryChangeReceiver;

    companion object{
        val WEB_IS_HOME = "WEB_IS_HOME"
        val WEB_URL = "WEB_URL"
        fun openWebView(activity: AppCompatActivity,url:String? ,boolean: Boolean){
            var intent = Intent(activity,BaseWebActivity::class.java)
            intent.putExtra(WEB_IS_HOME,boolean)
            intent.putExtra(WEB_URL,url)
            activity.startActivity(intent)
        }
    }

    override fun initView() {
        //获取ip
        HttpEvent.getPublicIp()
        //电池信息需要广播
        batteryChangeReceiver = BatteryChangeReceiver()
        BatteryUtil.registerReceiver(this,batteryChangeReceiver)
        appJS = AndroidJS(binding.webview.getWebView(),this)
        binding.webview.getWebView().addJavascriptInterface(appJS,appJS.APP_CLIENT)
        isHome = intent.getBooleanExtra(WEB_IS_HOME, false)
        webUrl = intent.getStringExtra(WEB_URL).toString()
        webUrl = "file:///android_asset/h5.html"
        if (!webUrl.startsWith("http") && !webUrl.startsWith("file")){
            webUrl = "https://$webUrl"
        }
        if (isHome){
            binding.include.toolbar.visibility = GONE
            immersionBar = ImmersionBar
                .with(this)
                .fitsSystemWindows(false)
                .statusBarColor(R.color.translucent)
                .statusBarDarkFont(true)
                .keyboardEnable(true)
            immersionBar?.let {
                it.init()
            }
            //检测更新
            HttpEvent.getNewVersion()
        }
        binding.webview.getWebView()?.loadUrl(webUrl)
        binding.include.toolbarBack.setOnClickListener {
            backActivity()
        }
        binding.webview.setOnTitleListener(this)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            backActivity()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    private fun backActivity() {
        if (binding.webview.getWebView()?.canGoBack() == true) {
            binding.webview.getWebView()?.goBack()
        } else {
            if (isHome) {
                moveTaskToBack(true)
            } else {
                finish()
                SoftKeyboardUtils.hideSoftKeyboard(this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BatteryUtil.unRegisterReceiver(this,batteryChangeReceiver)
        IWebSetting.releaseWebView(binding.webview.getWebView())
    }

    override fun webTitle(title: String) {
        GlobalScope.launch(Dispatchers.Main) {
            binding.include.toolbarTitle.text = title
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        appJS.onActivityResult(requestCode,resultCode,data)
        binding.webview.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}