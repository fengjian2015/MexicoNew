package com.lucksoft.commonui.util;

import android.text.TextUtils;

import java.util.Collection;

public class CollectionUtil {

    public static boolean isEmpty(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int getCount(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        return collection.size();
    }

    public static boolean isEmpty(Object[] span) {
        if (span == null || span.length == 0) {
            return true;
        }
        return false;
    }

    public static int getCount(String sug) {
        if (TextUtils.isEmpty(sug)) {
            return 0;
        }
        return sug.length();
    }
}
