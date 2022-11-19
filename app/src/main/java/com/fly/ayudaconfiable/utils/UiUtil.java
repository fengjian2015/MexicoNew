package com.fly.ayudaconfiable.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class UiUtil {
    public static SpannableString tColorTextClick(SpannableString style, int start, int end, int color, View.OnClickListener onClickListener){
        style.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                onClickListener.onClick(widget);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(color);
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }
}
