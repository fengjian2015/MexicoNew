package com.fly.ayudaconfiable.bean

import java.io.Serializable

class UserInfo (var phone:String, var userId:String ="", var sessionId:String = ""
                , var isNew :Boolean = true, var homeUrl:String? = ""
                , var appVersion:String = "", var devName:String ="android", var tsd:String =""): Serializable {
}