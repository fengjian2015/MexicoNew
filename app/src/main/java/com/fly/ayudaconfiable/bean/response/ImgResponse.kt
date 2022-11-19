package com.fly.ayudaconfiable.bean.response

import com.fly.ayudaconfiable.network.bean.BaseResponseBean

class ImgResponse (var data :String = ""): BaseResponseBean() {
    override fun toString(): String {
        return "ImageResponse(data='$data')"
    }
}