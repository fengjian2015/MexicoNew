package com.fly.ayudaconfiable.network.net.http;



import com.fly.ayudaconfiable.utils.LogUtils;

import okhttp3.Call;
import okhttp3.EventListener;

/**
 * lucksoft
 * Created by AndroidDevelop on 2022/6/30.
 * 158045632@qq.com
 */
public class PicEventListenerFactory implements EventListener.Factory {
    @Override
    public EventListener create(Call call) {
        //LogUtils.v(" ====> this is new call ?? ");
        NetEventModel tag = call.request().tag(NetEventModel.class);
        if(null == tag){
            LogUtils.e("tag is null !!");
        }
        return tag != null ? new NetEventListener(tag) : EventListener.NONE;
    }
}