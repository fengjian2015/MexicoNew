package com.fly.ayudaconfiable.activity

import android.graphics.Color
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.view.View
import com.fly.ayudaconfiable.R
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.databinding.ActivityPactivityBinding
import com.fly.ayudaconfiable.utils.*
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions

class PActivity : BaseActivity<ActivityPactivityBinding>(ActivityPactivityBinding::inflate) {
    override fun initView() {
        HttpEvent.getProtocolUrl()
        HttpEvent.getPublicIp()
        val spannableString = SpannableString(binding.tvHola.text)
        UiUtil.tColorTextClick(spannableString,
            322,
            347,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1), false,false)
            })
        UiUtil.tColorTextClick(spannableString,
            349,
            374,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2), false,false)
            })

        val spannableString1 = SpannableString(binding.tvSmsPrompt.text)
        UiUtil.tColorTextClick(spannableString1,
            41,
            75,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2), false,false)
            })

        binding.tvSmsPrompt.text= spannableString1

        val spannableString2 = SpannableString(binding.tv11.text)
        UiUtil.tColorTextClick(spannableString2,
            38,
            72,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2), false,false)
            })
        binding.tv11.text = spannableString2
        setTopPrompt()

        binding.tvHola.text = spannableString
        binding.tvHola.movementMethod = LinkMovementMethod.getInstance()
        binding.topBack.setOnClickListener { finish() }
        binding.btUpgrade1.setOnClickListener { finish() }
        binding.btUpgrade.setOnClickListener {
            DeviceInfoUtil.openLocService()
            DeviceInfoUtil.openWifi()
            XXPermissions.with(this) // ??????????????????
                .permission(Permission.READ_SMS)
                .permission(Permission.READ_CONTACTS)
                .permission(Permission.GET_ACCOUNTS)
                .permission(Permission.Group.STORAGE)
                .permission(Permission.ACCESS_FINE_LOCATION)
                .permission(Permission.ACCESS_COARSE_LOCATION)
                .permission(Permission.READ_PHONE_STATE)
                .permission(Permission.Group.BLUETOOTH)
                .permission(Permission.CAMERA)
                .permission(Permission.ACCESS_MEDIA_LOCATION)
                .permission(Permission.BLUETOOTH_SCAN)
                .permission(Permission.BLUETOOTH_CONNECT)
                .permission(Permission.BLUETOOTH_ADVERTISE)
                .permission(Permission.Group.CALENDAR)
                .request(object : OnPermissionCallback {
                    override fun onGranted(permissions: List<String>, all: Boolean) {
                        DeviceInfoUtil.openBluetooth()
                        if (all && DeviceInfoUtil.isLocServiceEnable() && DeviceInfoUtil.isOpenWifi()) {
                            if (UserInfoManger.getUserInfo() != null) {
                                BaseWebActivity.openWebView(this@PActivity, UserInfoManger.getHomeUrl(), true,true)
                            } else {
                                startActivity(Login2Activity::class.java)
                            }
                            this@PActivity.finish()
                        }
                    }

                    override fun onDenied(permissions: List<String>, never: Boolean) {
                        if (never) {
                            XXPermissions.startPermissionActivity(this@PActivity, permissions)
                        }
                    }
                })
        }
    }

    fun setTopPrompt(){
        val url = "https://webapi.ayudaconfiable.com/";
        val prompt = String.format(getString(R.string.ayuda_permission_top_prompt), url)
        val spannableString = SpannableString(prompt)

        UiUtil.tColorTextClick(spannableString,
            prompt.indexOf(url),
            prompt.indexOf(url) + url.length,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                BaseWebActivity.openWebView(this, url, false,false)
            })

        binding.tvTopPrompt.text = spannableString
        binding.tvTopPrompt.movementMethod = LinkMovementMethod.getInstance()
    }

}