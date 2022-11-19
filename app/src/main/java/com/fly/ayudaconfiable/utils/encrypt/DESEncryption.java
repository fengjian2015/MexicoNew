package com.fly.ayudaconfiable.utils.encrypt;

import android.util.Base64;

import com.fly.ayudaconfiable.utils.LogUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author：Raoqw on 2016/7/21 09:45
 * Email：lhholylight@163.com
 */
public class DESEncryption {

    /**
     * @param message //待加密数据
     * @return
     */
    public static String encrypt(String message, String appkey) {
        if (message == null) {
            message = "";
        }

        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(appkey.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(appkey.getBytes("UTF-8"));

            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(message.getBytes("UTF-8"));
            String result = new String(Base64.encode(bytes, Base64.DEFAULT));
            LogUtils.v("待加密数据: " + message + " [结果:] " + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDES(String decryptString, String decryptKey, boolean needUrlDecode) {
        try {
            if (needUrlDecode) {
                decryptString = java.net.URLDecoder.decode(decryptString, "UTF-8");
            }

            IvParameterSpec iv = new IvParameterSpec(decryptKey.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte decryptedData[] = cipher.doFinal(Base64.decode(decryptString, Base64.DEFAULT));

            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
