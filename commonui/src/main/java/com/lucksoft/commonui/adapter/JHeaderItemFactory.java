package com.lucksoft.commonui.adapter;

import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface JHeaderItemFactory<H> {
    <VB extends ViewBinding> VB headBindingOf(int viewType, ViewGroup parent);
    int headTypeOf(H h);
    boolean isHeadType(int viewType);
    <VB extends ViewBinding> JViewHolder<H, VB> headHolderOf(VB binding, int viewType);
}
