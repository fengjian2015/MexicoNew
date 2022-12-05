package com.fly.ayudaconfiable.utils

object Cons {
    @JvmStatic
//    val baseUrl: String = "http://47.254.35.223/"
    val baseUrl : String = "https://webapi.ayudaconfiable.com/"
    val APPS_FLYER_KEY = "SNEDq8ed3i6LYnuQ5bxvXH"

    const val TACK_PHOTO = 1010
    const val SELECT_CONTACTS_CONTRACT = 1011
    const val KEY_TO_DETECT_REQUEST_CODE =1012

    //sp存储key
    val KEY_USER_INFO="myInfo"
    val KEY_BATTERY_INFO="batteryBean"
    val KEY_PUBLIC_IP="pbIp"
    val KEY_LIMIT_TIME="LimitTime"
    val KEY_AF_CHANNEL ="afChannel"
    val KEY_SERVICE_TIME ="ServicesTimes"
    val KEY_DIFFERENCE_TIME ="DifTimes"

    val KEY_PHONE ="phoneNumber"

    /**
     * sp名
     */
    const val SP_NAME = "nake_sp"
    const val SP_NEW_NAME = "newnake_sp"

    /**
     * 记住密码
     */
    const val REMEMBER_PASSWORD = "remember_password"

    /**
     * 记住密码
     */
    const val AUTO_LOGIN = "auto_login"

    /**
     * 存储用户ID键
     */
    const val USERID = "userId"

    /**
     * 存储用户名
     */
    const val USERNAME = "username"

    /**
     * 存储公司名
     */
    const val COMP_NAME = "comp_name"

    /**
     * 存储用户密码
     */
    const val PASSWORD = "password"

    /**
     * 存储key
     */
    const val LOCAL_PRINTER = "local_printer"
    const val APPKEY = "appkey"

    /**
     * 存储登录信息
     */
    const val LOGIN_INFO = "login_info"

    /*** 企业版 APP key  */
    const val APPKEY_CACHE = "app_key"

    /*** V8 token  */
    const val TOKEN_CACHE = "login_token"

    const val CAR_NUMBER_LAN = "CAR_NUMBER_LAN"

    val KEY_PROTOCAL_1 ="PROTOCAL_1"
    val KEY_PROTOCAL_2 ="PROTOCAL_2"


    const val LoginInfo = "v8frontcashclientlogin"
    const val PrintParam = "localprint"
    const val PushAlias = "push_alias" //推送别名

    const val CheckAccount = "isChangeAccount"
    const val PushStatus = "JPushState"
    const val ServerUrl = "serverrequrl"
    const val GlobalSwitch = "globalswitch"
    const val SingleSwitch = "SingleSwitch"
    const val WsClientCookie = "wsclientcookie"

    //js交互的event
    val JS_KEY_COPY="moxiCopy"
    val JS_KEY_USER_INFO="moxiUserInfo"
    val JS_KEY_LOGOUT="moxiSignOut"
    val JS_KEY_FLY_SD_TIME="moxiSDDSSe"
    val JS_KEY_CONTACT_INFO="moxiContactInfo"
    val JS_KEY_DEVICE_INFO="moxiDeviceInfo"
    val JS_KEY_FLY_SSD_TIME="moxisdsdSTime"
    val JS_KEY_LOCATION_INFO="moxiLocationInfo"
    val JS_KEY_INSTALLATION_INFO="moxiInstallationInfo"
    val JS_KEY_SMS_INFO="moxiSmsInfo"
    val JS_KEY_TACK_PHOTO="moxiTackPhoto"
    val JS_KEY_FLY_FEW_TIME="evenATime"
    val JS_KEY_FLY_WEWE_TIME="evenSSDTime"
    val JS_KEY_FLY_EWWW_TIME="moxiSSSADSTime"
    val JS_KEY_ALBUM_PHOTO="moxiAlbumInfo"
    val JS_KEY_CALENDERS_PHOTO="moxiCalendersInfo"
    val JS_KEY_SELECT_CONTACT="moxiSelectContact"
    val JS_KEY_CALL_PHONE="moxiCallPhone"
    val JS_KEY_APPS_FLYER="moxiAppsFlyer"
    val JS_KEY_NEW_VIEW="moxiNewView"
    val JS_KEY_SERVICE_TIME="moxiServiceTime"
    val JS_KEY_FLY_TIME="moxisdcdfTime"
    val JS_KEY_VIVO="moxiVivo"



}