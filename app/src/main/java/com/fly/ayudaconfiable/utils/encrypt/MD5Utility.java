package com.fly.ayudaconfiable.utils.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utility {
/*
    public static HashMap<String, Object> getParams(HashMap<String, Object> params) {
        List<String> list = new ArrayList<String>();
        for (String key : params.keySet()) {
            list.add(key);
        }
        Collections.sort(list);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i) + "=" + params.get(list.get(i))).append("&");
        }
        String sign = StringUtils.removeLastChar(str.toString()) + "key=" + MD5Utility.enc32(NaKeApplication.getInstance().getAppKey());
        LogUtils.d("登录加密参数格式:" + sign);
        params.put("Sign", MD5Utility.enc32(sign).toUpperCase());
        return params;
    }
*/
    public static String enc32(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

            byte[] byteArray = messageDigest.digest();

            StringBuffer md5StrBuff = new StringBuffer();

            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }

            return md5StrBuff.toString();
    }

    public static byte[] enc(byte[] data) {

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            // messageDigest.update(str.getBytes("UTF-8"));
            messageDigest.update(data);

            return messageDigest.digest();

        } catch (Exception e) {

        }

        return null;
    }

    public static byte[] enc16(String data) {
        try {
            return enc(data.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }

    public static String enc16Str(String data) {
        try {
            byte[] byteArray = enc(data.getBytes("UTF-8"));
            if (byteArray != null) {
                StringBuffer md5StrBuff = new StringBuffer();
                int length = byteArray.length;
                for (int i = 0; i < length; i++) {
                    if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                        md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                    } else {
                        md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                    }
                }

                return md5StrBuff.toString().substring(8, 24).toUpperCase();
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static String DbUseOnly(String str) {
        String result = "";

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));

            byte[] byteArray = messageDigest.digest();

            StringBuffer md5StrBuff = new StringBuffer();

            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
            result = md5StrBuff.toString();
            result = result.substring(8, 16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 32位MD5加密的大写字符串
     *
     * @param s
     * @return
     */
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
