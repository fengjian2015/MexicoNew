package com.lucksoft.commonui.adapter;


import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface JFooterItemFactory<F> {

    <VB extends ViewBinding> VB footerBindingOf(int viewType, ViewGroup parent);
    <VB extends ViewBinding> JViewHolder<F, VB> footerHolderOf(VB binding, int viewType);
    int footerTypeOf(F f);
    boolean isFooterType(int viewType);

}
