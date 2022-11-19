package com.in.progress;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.in.utils.R;


/**
 * author: Rea.X
 * date: 2017/3/13.
 */

public class ApiProgressDialog extends ProgressDialog {
    private ImageView loading_img;
    private AnimationDrawable animationDrawable;
    private String message;

    public ApiProgressDialog(Context context, String message) {
        super(context, R.style.ProgressDialogStyle);
        this.message = message;
    }

    public ApiProgressDialog(Context context, int theme) {
        super(context, R.style.ProgressDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.utils_dialog_progress);
        loading_img = (ImageView) findViewById(R.id.loading_img);
        loading_img.setBackgroundResource(R.drawable.loading_annmation);
        animationDrawable = (AnimationDrawable) loading_img.getBackground();
        TextView tv_message = findViewById(R.id.tv_message);
        if(!TextUtils.isEmpty(message)){
            tv_message.setVisibility(View.VISIBLE);
            tv_message.setText(message);
        }
    }

    @Override
    public void show() {
        super.show();
        animationDrawable.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animationDrawable.stop();
    }
}
