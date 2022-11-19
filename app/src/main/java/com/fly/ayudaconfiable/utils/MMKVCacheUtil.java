package com.fly.ayudaconfiable.utils;

import android.os.Parcelable;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;

public class MMKVCacheUtil {

    private static MMKV kv = null;
    private static MMKV multiKv = null;

    private static synchronized void init() {
        if (kv == null) {
            kv = MMKV.defaultMMKV();
        }
    }
    // ******************************单进程***************************************

    public static boolean putBoolean(String key, boolean value) {
        init();
        return kv.encode(key, value);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        init();
        return kv.decodeBool(key);
    }

    public static boolean putInt(String key, int value) {
        init();
        return kv.encode(key, value);
    }

    public static int getInt(String key) {
        init();
        return kv.decodeInt(key);
    }

    public static boolean putLong(String key, Long value) {
        init();
        return kv.encode(key, value);
    }

    public static Long getLong(String key) {
        init();
        return kv.decodeLong(key);
    }

    public static Long getLong(String key,long defaultLong) {
        init();
        return kv.decodeLong(key,defaultLong);
    }

    public static boolean putString(String key, String value) {
        init();
        return kv.encode(key, value);
    }

    public static String getString(String key) {
        init();
        return kv.decodeString(key,"");
    }

    public static String getString(String key,String defaultValue) {
        init();
        return kv.decodeString(key,defaultValue);
    }

    public static boolean put(String key, @NonNull Object object) {
        init();
        if (object instanceof Parcelable) {
            return kv.encode(key, (Parcelable) object);
        } else {
            return kv.encode(key, new Gson().toJson(object));
        }
    }

    public static <T> T getObject(String key, @NonNull Class<T> tClass) {
        init();
        if (tClass != null) {
            if (Parcelable.class.isAssignableFrom(tClass)) {
                return (T) kv.decodeParcelable(key, (Class<? extends Parcelable>) tClass);
            }
        } else {
            String v = kv.decodeString(key, (String) null);
            if (!TextUtils.isEmpty(v)) {
                return new Gson().fromJson(v, tClass);
            }
        }
        return null;
    }

    public static void remove(String key) {
        init();
        kv.remove(key);
    }
}
