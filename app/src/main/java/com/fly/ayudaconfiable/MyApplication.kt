package com.fly.ayudaconfiable

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.fly.ayudaconfiable.network.HttpClient
import com.fly.ayudaconfiable.utils.ActivityManager
import com.fly.ayudaconfiable.utils.AppsFlyerUtil
import com.fly.ayudaconfiable.utils.Cons
import com.fly.ayudaconfiable.utils.LogUtils
import com.liveness.dflivenesslibrary.DFProductResult
import com.liveness.dflivenesslibrary.DFTransferResultInterface
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.mmkv.MMKV

class MyApplication : Application(), DFTransferResultInterface {
    private var mResult: DFProductResult? = null

    companion object {
        @JvmStatic
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        Utils.init(this)
        ActivityManager.registerActivityLifecycleCallbacks()
        LogUtils.setDebug(BuildConfig.DEBUG)
        HttpClient.instance.init(Cons.baseUrl)
        AppsFlyerUtil.initAppsFlyer()
        MMKV.initialize(this)

        CrashReport.initCrashReport(applicationContext, "8d1fe7226a", true);
    }

    override fun setResult(p0: DFProductResult?) {
        mResult = p0
    }

    override fun getResult(): DFProductResult? {
        return mResult
    }
}

