package com.fly.ayudaconfiable.network.net.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * lucksoft
 * Created by AndroidDevelop on 2019年10月9日,0009.
 * 158045632@qq.com
 */
public class ServerCertsVerifier implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        /**
         * int count = 0;
        if (chain == null) {
            throw new CertificateException("checkServerTrusted: X509Certificate array is null");
        }
        if (chain.length < 1) {
            throw new CertificateException("checkServerTrusted: X509Certificate is empty");
        }
        if (!(null != authType && authType.equals("ECDHE_RSA"))) {
           // throw new CertificateException("checkServerTrusted: AuthType is not ECDHE_RSA");
        }

        try {
            for (X509Certificate certificate : chain) {
                certificate.checkValidity(); //检查证书是否过期，签名是否通过等
                count++;
                if(count == 1){
                    if(!"CN=*.600vip.cn".equals(certificate.getSubjectDN().getName())){
                        //throw new CertificateException("server's subject is not equals to client's subject");
                    }
                }
                // Make sure that it hasn't expired.
                certificate.checkValidity();
                // Verify the certificate's public key chain.
            }
        } catch (Exception e) {
            throw new CertificateException(e);
        }
        */
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

}
