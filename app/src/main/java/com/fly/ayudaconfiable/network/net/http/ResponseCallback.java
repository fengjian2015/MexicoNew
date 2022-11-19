package com.fly.ayudaconfiable.network.net.http;

/**
 * nakesoft
 * Created by 孔明 on 2018年9月11日,0011.
 * 158045632@qq.com
 */
public abstract class ResponseCallback <T> {
    public ResponseCallback() {}

    /**
     * @param statusCode
     * @param result
     */
    public abstract void onSuccess(int statusCode, T result);

    /**
     * @param statusCode
     * @param message
     */
    public abstract void onFailure(int statusCode, String message);

    public void onResponseStr(String response){}
}
