package com.in.toast;

import android.widget.Toast;

import androidx.annotation.DrawableRes;

import com.in.utils.R;

/**
 * Created by Rea.X on 2017/2/2.
 * <p>Toast工具类</p>
 */

public class ToastUtils {


    private static boolean isShowFace = false;
    private static ToastConfig toastConfig = new ToastConfig() {
        @Override
        public Toast providerToast(String message, int res) {
            return super.providerToast(message, res);
        }
    };

    public static void toastError(String msg) {
        show(msg, R.drawable.toast_error_tips);
    }


    public static void toastSuccess(String msg) {
        show(msg, R.drawable.toast_success_tips);
    }


    public static void toastWarn(String msg) {
        show(msg, R.drawable.toast_error_tips);
    }

    public static boolean isIsShowFace() {
        return isShowFace;
    }

    public static void setIsShowFace(boolean isShowFace) {
        ToastUtils.isShowFace = isShowFace;
    }

    public static void setIToastConfig(ToastConfig toastConfig){
        ToastUtils.toastConfig = toastConfig;
    }

    private static void show(String message, @DrawableRes int res) {
        Toast toast = toastConfig.providerToast(message, res);
        toast.show();
    }

}
