package com.fly.ayudaconfiable.bean.response

import com.fly.ayudaconfiable.network.bean.BaseResponseBean

class IpResponse (var data :String = ""): BaseResponseBean() {
    override fun toString(): String {
        return "PublicIpResponse(data='$data')"
    }
}