package com.fly.ayudaconfiable.network.net.http;


import android.util.Log;

import com.fly.ayudaconfiable.utils.LogUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/**
 * lucksoft
 * Created by AndroidDevelop on 2022/6/30.
 * 158045632@qq.com
 */
public class NetEventListener extends EventListener {
    private long callStart = 0;
    //建立连接
    private long dnsStart = 0;
    private long connectStart = 0;
    private long secureConnectStart = 0;

    //连接已经建立
    private long reqHeaderStart = 0;
    private long requestStart = 0;
    private long resHeaderStart = 0;
    private long responseStart = 0;

    public long MAX_TIME = 90000;//30000;

    private NetEventModel model;


    public NetEventListener(NetEventModel model) {
        LogUtils.d(" --this is request --> Call  ");
        this.model = model;
        if(null != model){
            LogUtils.w(" request id: " + model.getRequestId());
        }
    }

    public NetEventModel getModel() {
        return model;
    }

    @Override
    public void callStart(Call call) {
        LogUtils.w(" =====> Trace Call <===");
        callStart = System.currentTimeMillis();
        //mRequestId = String.valueOf(mNextRequestId.getAndIncrement());
    }

    @Override
    public void callEnd(Call call) {
        LogUtils.w(" ====> Trace Call <=====");
        model.fetch_duration = System.currentTimeMillis() - callStart;

        if (model.fetch_duration >= MAX_TIME) {
            model.fetch_duration = 0;
        }

        if(model.fetch_duration > 800){
            //LogUtils.f(call.request().url().toString() + "  cost : " + model.fetch_duration + " ms ");
            Log.i("debug",call.request().url().toString() + "  cost : " + model.fetch_duration + " ms ");
            //Log.i("staic", " serve_duration : " + model.serve_duration);
            Log.i("staic", " 总耗时 : " + model.fetch_duration + " ms ");

            Log.i("staic", " dns: " + model.dns_duration + " secure: " + model.secure_duration + " connect: " + model.connect_duration);

            Log.i("staic", " reqheader: " + model.reqheader_duration + " request: " + model.request_duration);

            Log.i("staic", " resheader: " + model.resheader_duration + " response: " + model.response_duration);
        }
    }

    /*** Http请求永久失败时，会调用callFailed()方法 **/
    @Override
    public void callFailed(Call call, IOException ioe) {
        LogUtils.e(" =====> Trace Call <====== " + call.request().url().toString());
        model.fetch_duration = System.currentTimeMillis() - callStart;

        if (model.fetch_duration >= MAX_TIME) {
            model.fetch_duration = 0;
        }
    }

    @Override
    public void dnsStart(Call call, String domainName) {
        //LogUtils.w(" =========> Trace Call <========");
        dnsStart = System.currentTimeMillis();
    }

    @Override
    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        //LogUtils.w(" =========> Trace Call <========");
        model.dns_duration = System.currentTimeMillis() - dnsStart;

        if (model.dns_duration >= MAX_TIME) {
            model.dns_duration = 0;
        }
    }

    @Override
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        //LogUtils.w(" =========> Trace Call <========");
        connectStart = System.currentTimeMillis();
    }

    @Override
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        //LogUtils.w(" =========> Trace Call <========");
        model.connect_duration = System.currentTimeMillis() - connectStart;

        if (model.connect_duration >= MAX_TIME) {
            model.connect_duration = 0;
        }

        //因为connectionAcquired可能会有多次，那么请求从此处开始计时
        //requestStart =  System.currentTimeMillis();
        //model.request_duration = 0;
    }

    /*** 向服务端发起创建连接失败时，会调用connectFailed() **/
    @Override
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        LogUtils.e(" =========> Trace Call <========");
        model.connect_duration = System.currentTimeMillis() - connectStart;

        if (model.connect_duration >= MAX_TIME) {
            model.connect_duration = 0;
        }
    }

    @Override
    public void secureConnectStart(Call call) {
        //LogUtils.w(" =========> Trace Call <========");
        secureConnectStart = System.currentTimeMillis();
    }

    @Override
    public void secureConnectEnd(Call call, Handshake handshake) {
        //LogUtils.w(" =========> Trace Call <========");
        model.secure_duration = System.currentTimeMillis() - secureConnectStart;

        if (model.secure_duration >= MAX_TIME) {
            model.secure_duration = 0;
        }
    }

    /** 实际未用  **/
    @Override
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        //LogUtils.w(" =========> Trace Call <========");
        reqHeaderStart = System.currentTimeMillis();
    }

    @Override
    public void requestHeadersEnd(Call call, Request request) {
        //LogUtils.w(" =========> Trace Call <========");
        model.reqheader_duration = System.currentTimeMillis() - reqHeaderStart;

        if (model.reqheader_duration >= MAX_TIME) {
            model.reqheader_duration = 0;
        }
    }

    /** 实际未用  **/
    @Override
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        //LogUtils.w(" =========> Trace Call <========");
        requestStart = System.currentTimeMillis();
    }

    @Override
    public void requestBodyEnd(Call call, long byteCount) {
        //LogUtils.w(" =========> Trace Call <========");
        model.request_duration = System.currentTimeMillis() - requestStart;

        if (model.request_duration >= MAX_TIME) {
            model.request_duration = 0;
        }
    }

    @Override
    public void responseHeadersStart(Call call) {
        //LogUtils.w(" =========> Trace Call <========");
        resHeaderStart = System.currentTimeMillis();
        model.resheader_duration = 0;
    }

    @Override
    public void responseHeadersEnd(Call call, Response response) {
        //LogUtils.w(" =========> Trace Call <========");
        model.resheader_duration = System.currentTimeMillis() - resHeaderStart;

        if (model.resheader_duration >= MAX_TIME) {
            model.resheader_duration = 0;
        }
    }

    @Override
    public void responseBodyStart(Call call) {
        //LogUtils.w(" =========> Trace Call <========");
        //if (responseStart == 0) {
        responseStart = System.currentTimeMillis();
        //}
        model.response_duration = 0;
    }

    @Override
    public void responseBodyEnd(Call call, long byteCount) {
        //LogUtils.w(" =========> Trace Call <========");
        model.response_duration = System.currentTimeMillis() - responseStart;

        if (model.response_duration >= MAX_TIME) {
            model.response_duration = 0;
        }

        //model.serve_duration = responseStart - (requestStart + model.request_duration);
        model.serve_duration = resHeaderStart - (requestStart + model.request_duration);
    }


}