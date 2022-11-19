package com.in.progress;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 创建时间：2018/11/16
 * 方法编写人：Rea.X
 * 功能描述：
 */
public abstract class ProgressDialogConfig {

    protected ProgressDialog providerProgressDialog(Context context, String message) {
        ApiProgressDialog progressDialog = new ApiProgressDialog(context, message);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
