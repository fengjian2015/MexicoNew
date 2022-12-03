package com.lucksoft.commonui.adapter;

import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface JItemFactory<T> {

    public int typeOf(T t);

    public <VB extends ViewBinding> VB viewBindingOf(int type, ViewGroup parent);

    public <VB extends ViewBinding> JViewHolder<T, VB> holderOf(VB vb, int viewType);


}
