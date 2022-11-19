package com.fly.ayudaconfiable.utils

import com.fly.ayudaconfiable.bean.UserInfo
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.utils.Cons.KEY_USER_INFO
import com.google.gson.Gson

object UserInfoManger {

    fun saveUserInfo(user: UserInfo) {
        user.let {
            var u = Gson().toJson(user)
            MMKVCacheUtil.putString(KEY_USER_INFO, u)
        }
    }

    fun getUserInfo(): UserInfo? {
        var u = MMKVCacheUtil.getString(KEY_USER_INFO)
        try {
            return Gson().fromJson(u, UserInfo::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getHomeUrl():String?{
        getUserInfo()?.let {
            return it.homeUrl
        }
        return ""
    }

    fun getUserPhone():String?{
        getUserInfo()?.let {
            return it.phone
        }
        return ""
    }

    fun getUserSessionId():String?{
        getUserInfo()?.let {
            return it.sessionId
        }
        return ""
    }

    fun getUserUserId():String?{
        getUserInfo()?.let {
            return it.userId
        }
        return ""
    }

    fun getUserInfoJson(): String {
        return MMKVCacheUtil.getString(KEY_USER_INFO)
    }

    fun logout() {
        HttpEvent.logout()
        MMKVCacheUtil.remove(KEY_USER_INFO)
    }
}