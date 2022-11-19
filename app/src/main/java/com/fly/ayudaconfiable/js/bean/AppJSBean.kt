package com.fly.ayudaconfiable.js.bean

import com.google.gson.internal.LinkedTreeMap
import java.io.Serializable

class AppJSBean : Serializable {
    var id: String = ""
    var shijian: String = ""
    var data: LinkedTreeMap<String,String>? = null

}