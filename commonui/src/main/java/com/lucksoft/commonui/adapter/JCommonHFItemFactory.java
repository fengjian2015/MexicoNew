package com.lucksoft.commonui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.lucksoft.commonui.databinding.FooterLayoutBinding;
import com.lucksoft.commonui.databinding.HeadLayoutBinding;
import com.lucksoft.commonui.databinding.LoadMoreLayoutBinding;

public abstract class JCommonHFItemFactory<H, F, T> implements JMultiTypeItemFactory<H, F, T>{
    public static final int LOAD_MORE_VIEW_TYPE = -300;
    public static final int FOOTER_VIEW_TYPE = -200;
    public static final int HEADER_VIEW_TYPE = -100;

    @Override
    public <VB extends ViewBinding> JViewHolder holderOf(VB vb, int viewType) {
        return new JViewHolder<>(vb);
    }

    @Override
    public <VB extends ViewBinding> VB footerBindingOf(int viewType, ViewGroup parent) {
        return (VB) FooterLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public <VB extends ViewBinding> JViewHolder footerHolderOf(VB binding, int viewType) {
        return new JViewHolder<>(binding);
    }

    @Override
    public int footerTypeOf(F f) {
        return FOOTER_VIEW_TYPE;
    }

    @Override
    public boolean isFooterType(int viewType) {
        return viewType == FOOTER_VIEW_TYPE;
    }

    @Override
    public <VB extends ViewBinding> VB headBindingOf(int viewType, ViewGroup parent) {
        return (VB) HeadLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public int headTypeOf(H h) {
        return HEADER_VIEW_TYPE;
    }

    @Override
    public boolean isHeadType(int viewType) {
        return viewType == HEADER_VIEW_TYPE;
    }

    @Override
    public <VB extends ViewBinding> JViewHolder headHolderOf(VB binding, int viewType) {
        return new JViewHolder(binding);
    }

    @Override
    public <VB extends ViewBinding> VB loadMoreBindingOf(ViewGroup parent) {
        return (VB) LoadMoreLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public int loadMoreTypeOf() {
        return LOAD_MORE_VIEW_TYPE;
    }

    @Override
    public <VB extends ViewBinding> JViewHolder loadMoreHolderOf(VB vb) {
        return new JViewHolder<>(vb);
    }

    @Override
    public boolean isLoadMoreType(int viewType) {
        return viewType == LOAD_MORE_VIEW_TYPE;
    }
}
