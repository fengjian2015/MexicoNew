package com.fly.ayudaconfiable.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Message
import android.text.*
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.CompoundButton
import com.appsflyer.AppsFlyerLib
import com.blankj.utilcode.util.ToastUtils
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.R
import com.fly.ayudaconfiable.bean.UserInfo
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.bean.response.UserInfoBeanResponse
import com.fly.ayudaconfiable.databinding.ActivitySmsactivityBinding
import com.fly.ayudaconfiable.network.HttpClient
import com.fly.ayudaconfiable.network.NetworkScheduler
import com.fly.ayudaconfiable.network.bean.BaseResponseBean
import com.fly.ayudaconfiable.network.bean.HttpErrorBean
import com.fly.ayudaconfiable.network.bean.HttpResponse
import com.fly.ayudaconfiable.utils.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SMSActivity : BaseActivity<ActivitySmsactivityBinding>(ActivitySmsactivityBinding::inflate) {

    //秒
    private val codeTime: Long = 60
    private var smsSendTime: Long = 0

    private val handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        @SuppressLint("HandlerLeak")
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (binding.sendSmsCode != null) {
                val currentTime: Long = DateTool.getServerTimestamp() / 1000
                val l = smsSendTime - currentTime
                binding.sendSmsCode.text = "" + l
                if (l <= 0) {
                    sendSMS(true)
                    return
                }
                sendEmptyMessage(1)
            }
        }
    }

    override fun initView() {
        val spannableString = SpannableString(binding.ptv.text)
        UiUtil.tColorTextClick(spannableString,
            29,
            51,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1), false,false)
            })
        UiUtil.tColorTextClick(spannableString,
            54,
            79,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2), false,false)
            })
        binding.ptv.text = spannableString
        binding.ptv.movementMethod = LinkMovementMethod.getInstance()

        binding.edtv.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(4))
        binding.edtv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                checkButton()
            }
        })
        binding.pcb.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener {
                compoundButton: CompoundButton?, b: Boolean -> checkButton() })
        binding.sendSmsCode.setOnClickListener {
            sendCodeHttp()
        }
        binding.btUpgrade.setOnClickListener {
            login();
        }
        checkButton()
        sendCodeHttp()
    }

    private fun login(){
        val map: MutableMap<String, String> = HashMap()
        map["Phone"] = MMKVCacheUtil.getString(Cons.KEY_PHONE)
        map["Code"] = binding.edtv.text.toString()
        map["appsFlyerId"] = AppsFlyerLib.getInstance().getAppsFlyerUID(MyApplication.application)
        map["deviceModel"] = Build.MODEL
        map["channelCode"] = MMKVCacheUtil.getString(Cons.KEY_AF_CHANNEL)
        map["mobilePhoneBrands"] = Build.BRAND
        map["appMarketCode"] = "Google"
        HttpClient.instance.httpService
            .loginByPhoneVerifyCode(map)
            .compose(NetworkScheduler.compose())
            .doOnSubscribe { LoadingUtil.showLoading() }
            .doFinally { LoadingUtil.dismissProgress() }
            .subscribe(object : HttpResponse<UserInfoBeanResponse>() {
                override fun businessSuccess(data: UserInfoBeanResponse) {
                    if (data.code == 200){
                        data.data?.let {
                            it.appVersion = CommonUtil.getVersionName(MyApplication.application).toString()
                            it.phone = MMKVCacheUtil.getString(Cons.KEY_PHONE)
                            it.devName = "android"
                            UserInfoManger.saveUserInfo(it)
                            if (it.isNew){
                                AppsFlyerUtil.postAF("ayudalogin")
                            }
                            BaseWebActivity.openWebView(this@SMSActivity,UserInfoManger.getHomeUrl(),true,true)
                        }
                        handler.postDelayed({ finish() },1000)
                    }else{
                        ToastUtils.showShort(data.message)
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {
                    ToastUtils.showShort(httpErrorBean.message)
                }
            })
    }

    private fun sendCodeHttp(){
        val map: MutableMap<String, String> = HashMap()
        map["phone"] = MMKVCacheUtil.getString(Cons.KEY_PHONE)
        HttpClient.instance.httpService
            .sendVerifyCode(map)
            .compose(NetworkScheduler.compose())
            .doOnSubscribe { LoadingUtil.showLoading() }
            .doFinally { LoadingUtil.dismissProgress() }
            .subscribe(object : HttpResponse<BaseResponseBean>() {
                override fun businessSuccess(data: BaseResponseBean) {
                    if (data.code == 200){
                        smsSendTime = DateTool.getServerTimestamp() / 1000 + codeTime
                        handler.sendEmptyMessage(1)
                        sendSMS(false)
                    }else{
                        sendSMS(true)
                        ToastUtils.showShort(data.message)
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {
                    sendSMS(true)
                    ToastUtils.showShort(httpErrorBean.message)
                }
            })
    }

    private fun sendSMS(isReset: Boolean){
        if (isReset){
            binding.sendSmsCode.background = resources.getDrawable(R.drawable.button_ok)
            binding.sendSmsCode.isClickable = true
            binding.sendSmsCode.isEnabled = true
            binding.sendSmsCode.text = "Código"
        }else{
            binding.sendSmsCode.background = resources.getDrawable(R.drawable.button_no)
            binding.sendSmsCode.isClickable = false
            binding.sendSmsCode.isEnabled = false
        }
    }

    private fun checkButton() {
        if (!binding.pcb.isChecked) {
            binding.btUpgrade.background = resources.getDrawable(R.drawable.button_no)
            binding.btUpgrade.isClickable = false
            binding.btUpgrade.isEnabled = false
            return
        }
        if (TextUtils.isEmpty(binding.edtv.text) || binding.edtv.text.length != 4) {
            binding.btUpgrade.background = resources.getDrawable(R.drawable.button_no)
            binding.btUpgrade.isClickable = false
            binding.btUpgrade.isEnabled = false
            return
        }
        binding.btUpgrade.background = resources.getDrawable(R.drawable.button_ok)
        binding.btUpgrade.isClickable = true
        binding.btUpgrade.isEnabled = true
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}