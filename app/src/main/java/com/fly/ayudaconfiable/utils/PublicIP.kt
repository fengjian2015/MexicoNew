package com.fly.ayudaconfiable.utils

import com.fly.ayudaconfiable.utils.Cons.KEY_PUBLIC_IP


object PublicIP {
    fun getIp():String?{
        return MMKVCacheUtil.getString(KEY_PUBLIC_IP)
    }
}