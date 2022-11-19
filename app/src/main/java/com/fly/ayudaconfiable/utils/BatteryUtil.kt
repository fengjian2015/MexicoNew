package com.fly.ayudaconfiable.utils

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.fly.ayudaconfiable.BatteryChangeReceiver
import com.fly.ayudaconfiable.bean.BatteryInfo
import com.fly.ayudaconfiable.utils.Cons.KEY_BATTERY_INFO
import com.google.gson.Gson


object BatteryUtil {

    fun registerReceiver(context: Context,batteryChangeReceiver: BatteryChangeReceiver){
        var intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        context.registerReceiver(batteryChangeReceiver, intentFilter)
    }

    fun unRegisterReceiver(context: Context,batteryChangeReceiver: BatteryChangeReceiver){
        context.unregisterReceiver(batteryChangeReceiver)
    }

    fun getBatteryBean():BatteryInfo{
        var batteryBean = BatteryInfo()
        val string = MMKVCacheUtil.getString(KEY_BATTERY_INFO)
        try {
            string?.let {
                batteryBean = Gson().fromJson(string,BatteryInfo::class.java)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return batteryBean
    }
}