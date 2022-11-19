package com.in.progress;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import com.in.utils.LogUtil;

/**
 * <p>Created by Rea.X on 2017/2/6.</p>
 * <p>显示ProgressDialog的工具类</p>
 */

public class ProgressDialogUtils {

    private static ProgressDialog progressDialog;
    private static volatile int progressDialogCount = 0;
    private static ProgressDialogConfig progressDialogConfig = new ProgressDialogConfig() {
        @Override
        protected ProgressDialog providerProgressDialog(Context context, String message) {
            return super.providerProgressDialog(context, message);
        }
    };
    public static void setIProgressDialogConfig(ProgressDialogConfig progressDialogConfig){
        ProgressDialogUtils.progressDialogConfig = progressDialogConfig;
    }

    private static void initProgressDialog(Context context, String message) {
        if (progressDialog == null) {
            progressDialogCount = 0;
            progressDialog = ProgressDialogUtils.progressDialogConfig.providerProgressDialog(context, message);
        }
    }

    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trace.length; i++) {
            String s = trace[i].toString();
            if (s.equals("java.lang.reflect.Method.invoke(Native Method)")) break;
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static synchronized void showProgress(Context context, String message, boolean flag) {
        LogUtil.d("ProgressDialogUtils::showProgress::context::" + getTag());
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) return;
        } else {
            return;
        }
        if (progressDialog == null)
            initProgressDialog(context, message);
        progressDialogCount++;
        if (progressDialog != null && !progressDialog.isShowing()) {
            try {
                progressDialog.show();
                progressDialog.setCancelable(flag);
            } catch (Exception e) {
            }
        }
    }

    public static synchronized void showProgress(Context context, boolean flag) {
        showProgress(context, null, flag);
    }

    public static synchronized void showProgress(Context context, String message) {
        showProgress(context, message, true);
    }

    public static synchronized void showProgress(Context context) {
        showProgress(context, null, true);
    }

    public static synchronized void dismissProgress() {
        progressDialogCount--;
        if (progressDialogCount > 0) return;
        try {
            if ((progressDialog != null) && progressDialog.isShowing()) {
                Context context = ((ContextWrapper) progressDialog.getContext()).getBaseContext();
                if (context instanceof Activity) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        if (!((Activity) context).isFinishing() && !((Activity) context).isDestroyed())
                            progressDialog.dismiss();
                    } else {
                        progressDialog.dismiss();
                    }
                } else
                    progressDialog.dismiss();
            }
        } catch (IllegalArgumentException e) {
            // Handle or log or ignore
        } catch (Throwable e) {
            // Handle or log or ignore
        } finally {
            progressDialog = null;
        }
    }
}
