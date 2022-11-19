package com.fly.ayudaconfiable.network.net.http;


import com.fly.ayudaconfiable.utils.LogUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * lucksoft
 * Created by AndroidDevelop on 2019年10月9日,0009.
 * 158045632@qq.com
 */
public class ServerHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        LogUtils.v("  hostname : " + hostname);
        //验证主机名是否匹配
        return true;
        /**
        try {
            String principla =  session.getPeerPrincipal().getName();
            if(!principla.equals("CN=*.600vip.cn")){
              //  return false;
            }
        } catch (SSLPeerUnverifiedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(InternalProcess.getInstance().getDomainAddr(1).equals(hostname)){
            return true;
        } else {
            HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
            return hv.verify(hostname, session);
        }
        **/
    }
}
