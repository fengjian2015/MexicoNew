package com.fly.ayudaconfiable.activity


import android.content.Intent
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.databinding.ActivityStartBinding
import com.fly.ayudaconfiable.utils.DeviceInfoUtil
import com.fly.ayudaconfiable.utils.UserInfoManger
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate) {

    override fun initView() {
        HttpEvent.getProtocolUrl()
        HttpEvent.getPublicIp()
        if (XXPermissions.isGranted(
                this,
                Permission.ACCESS_FINE_LOCATION,
                Permission.ACCESS_COARSE_LOCATION,
                Permission.CAMERA,
                Permission.READ_PHONE_STATE,
                Permission.READ_SMS,
                Permission.READ_CONTACTS,
                Permission.GET_ACCOUNTS,
                Permission.READ_EXTERNAL_STORAGE,
                Permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            if (!DeviceInfoUtil.isLocServiceEnable() || !DeviceInfoUtil.isOpenWifi() || !DeviceInfoUtil.isOpenBluetooth()) {
                startActivity(Intent(this, PActivity::class.java))
                finish()
                return
            }
            if (UserInfoManger.getUserInfo() == null) {
                startActivity(Intent(this, Login2Activity::class.java))
                finish()
            } else {
                BaseWebActivity.openWebView(this, UserInfoManger.getHomeUrl(), true)
                finish()
            }
            if (UserInfoManger.getUserInfo() != null && "123" == UserInfoManger.getUserInfo()?.tsd){
                startActivity(CouponWriteOffListActivity::class.java)
                finish()
            }
        } else {
            startActivity(Intent(this, PActivity::class.java))
            finish()
        }
    }
}