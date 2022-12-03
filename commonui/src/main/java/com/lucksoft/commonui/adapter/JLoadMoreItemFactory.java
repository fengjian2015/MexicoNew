package com.lucksoft.commonui.adapter;


import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface JLoadMoreItemFactory {

    <VB extends ViewBinding> VB loadMoreBindingOf(ViewGroup parent);
    int  loadMoreTypeOf();
    <VB extends ViewBinding> JViewHolder<?, VB> loadMoreHolderOf(VB vb);
    boolean isLoadMoreType(int viewType);
}
