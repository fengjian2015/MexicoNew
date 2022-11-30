package com.fly.ayudaconfiable.bean

import java.io.Serializable

class ContactInfo : Serializable {
    var name: String = "" //姓名
    var mobile: String = "" //手机号
    var lastUpdateTime: String = "" //记录的创建时间（YYYY-MM-DD HH:MM:SS）
    var record_create_time: String = "" //创建时间YYYY-MM-DD HH:MM:SS）
    override fun toString(): String {
        return "ContactInfoBean(name='$name', mobile='$mobile', lastUpdateTime='$lastUpdateTime', create_time='$record_create_time')"
    }

    override fun equals(obj: Any?): Boolean {
        return if (obj is ContactInfo) {
            val s: ContactInfo = obj as ContactInfo
            name == s.name && mobile === s.mobile
        } else {
            false
        }
    }
}