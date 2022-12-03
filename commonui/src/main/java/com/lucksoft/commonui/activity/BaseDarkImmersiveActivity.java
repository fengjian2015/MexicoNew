package com.lucksoft.commonui.activity;

import android.os.Bundle;

import com.lucksoft.commonui.StatusBarUtil;

import androidx.annotation.Nullable;

public class BaseDarkImmersiveActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBar(this, false);
    }
}
