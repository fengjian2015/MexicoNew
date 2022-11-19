package com.fly.ayudaconfiable.task;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.fly.ayudaconfiable.BuildConfig;
import com.fly.ayudaconfiable.utils.LogUtils;
import com.google.gson.Gson;
import com.in.utils.LogUtil;

/**
 * lucksoft
 * Created by AndroidDevelop on 2020/6/14.
 * 158045632@qq.com
 */
public class CheckOrderTask implements Runnable {
    private Handler mainHandler = null;
    private Gson mgson = new Gson();
    private String tempOrderid = "";
    private int cnt = 0;

    @Override
    public void run() {
        LogUtil.v(" 正式执行任务 ！！！ 检查 是否有 未处理的订单 ");
        processFailedOrder();
    }

    private Handler getMainHandler(){
        if (mainHandler == null) {
            return (mainHandler = new Handler(Looper.getMainLooper()));
        } else {
            return mainHandler;
        }
    }

    private void processFailedOrder() {
        LogUtils.v("  有可能短时间内会调用多次  ");
    }

    private void processInMainThread(final String orderno){
        getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                LogUtils.d("   orderno: " + orderno);
                queryOrder(orderno);
            }
        });
    }

    private void queryOrder(String orderid) {
        if(TextUtils.isEmpty(orderid)){
            LogUtil.e("  订单号不能为空 ");
            return;
        }
        /**
        Request request = new Request();
        request.transType = "A2"; // 交易类型
        request.appId = BuildConfig.APPLICATION_ID; // 业务软件包名, 必填
        request.orderId = orderid;   //Saas系统支付订单号
        tempOrderid = orderid;
        //request.misId  //收银台流水号
        //request.platformId  //商户(第三方平台)订单号
        String jsonStr = mgson.toJson(request);
        LogUtils.v("v", "  PRINT: " + jsonStr);
        callPayment(jsonStr);
        **/
    }

    private void callPayment(String request) {
        LogUtil.i("callPayment：" + request);
        boolean isTest = BuildConfig.DEBUG;


    }

    private void sleepWhile(long seelptime){
        if(seelptime < 0 || seelptime == 0){
            seelptime = 600;
        }
        try {
            Thread.sleep(seelptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
