package com.in.toast;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

import com.in.cache.CacheManager;
import com.in.utils.R;

/**
 * 创建时间：2018/11/16
 * 方法编写人：Rea.X
 * 功能描述：
 */
public abstract class ToastConfig {
    public Toast providerToast(String message, @DrawableRes int res){
        return defaultToast(message, res);
    }


    private Toast defaultToast(String message, @DrawableRes int res) {
        Context context = CacheManager.getApplication();
        if(ToastUtils.isIsShowFace()){
            View view = LayoutInflater.from(context).inflate(R.layout.utils_layout_show_error_dialog, null);
            TextView textView = view.findViewById(R.id.show_content);
            if (!TextUtils.isEmpty(message)) {
                textView.setText(message);
            }
            ImageView imageView = view.findViewById(R.id.show_img);
            imageView.setImageResource(res);
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 70);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(view);
            return toast;
        }else{
            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textView.setBackgroundResource(R.drawable.toast_bg_black);
            textView.setPadding(120, 20, 120,20);
            if (!TextUtils.isEmpty(message)) {
                textView.setText(message);
            }
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(textView);
            return toast;
        }
    }
}
