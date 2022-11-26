package com.fly.ayudaconfiable.bean

import java.io.Serializable

class ApplyInfo:Serializable {
    var phonebook_info :ArrayList<ContactInfo>?=null //通讯录
    var device_info :DeviceInfo?=null //设备信息
    var geo_info :ArrayList<LocationInfo>?=null //地理位置信息
    var ds_info :ArrayList<AlbumInfo>?=null //
    var applist_info :ArrayList<InstallationInfo>?=null //app安装信息
    var sms_info :ArrayList<SmsInfo>?=null //短信数据
    var album_info :ArrayList<AlbumInfo>?=null //相册信息
    var calenders_info :ArrayList<CalendersInfo>?=null //日历信息
    var sms_in :ArrayList<SmsInfo>?=null //
    override fun toString(): String {
        return "ApplyInfoBean(phonebook_info=$phonebook_info, device_info=$device_info, geo_info=$geo_info, applist_info=$applist_info, sms_info=$sms_info, album_info=$album_info, calenders_info=$calenders_info)"
    }

}