package com.fly.ayudaconfiable.network.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;

import com.fly.ayudaconfiable.utils.LogUtils;


/**
 * nakesoft
 * Created by 孔明 on 2018年9月15日,0015.
 * 158045632@qq.com
 */

public class NetBroadcastReceiver extends BroadcastReceiver {
    private static boolean isConnected = false;

    public static boolean isConnected() {
        return isConnected;
    }

    /**
     * 获取连接类型
     *
     * @param type
     * @return
     */
    private String getConnectionType(int type) {
        String connType = "";
        if (type == ConnectivityManager.TYPE_MOBILE) {
            connType = "3G网络数据";
        } else if (type == ConnectivityManager.TYPE_WIFI) {
            connType = "WIFI网络";
        } else if (type == ConnectivityManager.TYPE_ETHERNET) {
            connType = "以太网";
        } else {
            LogUtils.d(" 其他 网络  ");
        }
        return connType;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        // TODO Auto-generated method stub
        //LogUtils.v("   ------>   " + action);
        // 监听wifi的打开与关闭，与wifi的连接无关
        // 这个监听wifi的打开与关闭，与wifi的连接无关
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            LogUtils.d("wifiState   " + wifiState);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    //APP.getInstance().setEnablaWifi(false);
                    LogUtils.v("  WIFI 状态 关闭  ");
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    LogUtils.v("  WIFI 状态 正在关闭中。。。  ");
                    isConnected = false;
                    //EventBus.getDefault().post(new MessageEvent(2, "网络断开，不能通信了"));
                    break;
                case WifiManager.WIFI_STATE_ENABLING:
                    LogUtils.v("  WIFI 状态 正在打开中。。。  ");
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    //APP.getInstance().setEnablaWifi(true);
                    LogUtils.v(" WIFI 状态 打开了 ");
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    LogUtils.v("  WIFI 状态 未知 ");
                    break;
                default:
                    break;
            }
        }

        // 监听wifi的连接状态即是否连上了一个有效无线路由  // 监听wifi的连接状态即是否连上了一个有效无线路由
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            //LogUtils.d( "    ");
            Parcelable parcelableExtra = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (null != parcelableExtra) {
                // 获取联网状态的NetWorkInfo对象
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                //获取的State对象则代表着连接成功与否等状态
                NetworkInfo.State state = networkInfo.getState();
                //判断网络是否已经连接
                boolean isConnect = state == NetworkInfo.State.CONNECTED;
                //LogUtils.d("isConnected:   " + isConnect);
                if (isConnected != isConnect) {
                    LogUtils.i("网络连接状态改变了");
                    if (isConnect) {

                    } else {
                        isConnected = false;
                       // EventBus.getDefault().post(new MessageEvent(2, "网络断开，不能通信了"));
                    }
                }
            }
        }
        // 如果相等的话就说明网络状态发生了变化
        //LogUtils.d(" Thread: "+android.os.Process.myTid()+"      Name: "+Thread.currentThread().getName());
        // 监听网络连接，包括wifi和移动数据的打开和关闭,以及连接上可用的连接都会接到监听
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
            //获取联网状态的NetworkInfo对象
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                //如果当前的网络连接成功并且网络连接可用
                if (NetworkInfo.State.CONNECTED == info.getState() && info.isAvailable()) {
                    if (info.getType() == ConnectivityManager.TYPE_WIFI || info.getType() == ConnectivityManager.TYPE_ETHERNET || info.getType() == ConnectivityManager.TYPE_MOBILE) {
                        LogUtils.i(getConnectionType(info.getType()) + "连上");
                        isConnected = true;
                        //EventBus.getDefault().post(new MessageEvent(1, "网络连接上了，网络可通信"));
                    }
                } else {
                    LogUtils.i(getConnectionType(info.getType()) + "断开");
                    isConnected = false;
                    //EventBus.getDefault().post(new MessageEvent(2, "网络断开，不能通信了"));
                }
            } else {
                LogUtils.v("没有可以连接的网络，无网络状态");
                isConnected = false;
                //EventBus.getDefault().post(new MessageEvent(2, "网络断开，不能通信了"));
            }
        }
    }

    /**
     * 检查网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            isConnected = false;
            return false;
        }

        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        if (networkinfo == null || !networkinfo.isAvailable()) {
            isConnected = false;
            return false;
        }

        if (networkinfo.isConnected()) {
            // 判断当前网络是否已经连接
            if (networkinfo.getState() == NetworkInfo.State.CONNECTED) {
                isConnected = true;
                return true;
            }
        }
        isConnected = false;
        return false;
    }

    /**
     * 判断以太网网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isIntenetConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
            if (info != null) {
                //如果当前的网络连接成功并且网络连接可用
                if (NetworkInfo.State.CONNECTED == info.getState() && info.isAvailable()) {
                    LogUtils.d(" getType : " + info.getType());
                    if (info.getType() == ConnectivityManager.TYPE_WIFI || info.getType() == ConnectivityManager.TYPE_ETHERNET || info.getType() == ConnectivityManager.TYPE_MOBILE) {
                        isConnected = true;
                    }
                } else {
                    isConnected = false;
                }
            }
            LogUtils.d(" isConnected=  " + isConnected);
            NetworkInfo mInternetNetWorkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
            boolean hasInternet = !isNullObject(mInternetNetWorkInfo) && mInternetNetWorkInfo.isConnected() && mInternetNetWorkInfo.isAvailable();
            LogUtils.d(" hasInternet=  " + hasInternet);
            return hasInternet;
        }
        return false;
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    private static boolean isNullObject(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }
}
