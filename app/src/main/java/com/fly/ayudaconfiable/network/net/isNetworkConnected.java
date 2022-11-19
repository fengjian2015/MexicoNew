package com.fly.ayudaconfiable.network.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class isNetworkConnected {
    public static boolean isNetworkConnectted(Context context) {
        if (context!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){
                return true;
            }
        }
        return false;
    };


}