package com.lucksoft.commonui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class SelectBoldTextView extends AppCompatTextView {
    public SelectBoldTextView(@NonNull Context context) {
        super(context);
    }

    public SelectBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        setTypeface(selected ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }
}
