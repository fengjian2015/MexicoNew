package com.lucksoft.commonui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.lucksoft.commonui.R;
import com.lucksoft.commonui.databinding.FooterLayoutBinding;
import com.lucksoft.commonui.databinding.HeadLayoutBinding;
import com.lucksoft.commonui.databinding.LoadMoreLayoutBinding;


public abstract class JCommonItemFactory<T> implements JMultiTypeItemFactory<CommonBean, CommonBean, T> {
    public static final int LOAD_MORE__VIEW_TYPE = -300;
    public static final int FOOTER_VIEW_TYPE = -200;
    public static final int HEADER_VIEW_TYPE = -100;

    @Override
    public <VB extends ViewBinding>JViewHolder holderOf(VB binding, int viewType) {
        return new JViewHolder<>(binding);
    }

    @Override
    public <VB extends ViewBinding> VB loadMoreBindingOf(ViewGroup parent) {
        return (VB) LoadMoreLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public <VB extends ViewBinding> JViewHolder loadMoreHolderOf(VB binding) {
        return new JLoadMoreViewHolder((LoadMoreLayoutBinding) binding);
    }

    @Override
    public int loadMoreTypeOf() {
        return LOAD_MORE__VIEW_TYPE;
    }

    @Override
    public boolean isLoadMoreType(int viewType) {
        return viewType == LOAD_MORE__VIEW_TYPE;
    }

    @Override
    public <VB extends ViewBinding> VB footerBindingOf(int viewType, ViewGroup parent) {
        return (VB) FooterLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public <VB extends ViewBinding>JViewHolder footerHolderOf(VB binding, int viewType) {
        return new JViewHolder<>(binding);
    }

    @Override
    public int footerTypeOf(CommonBean commonBean) {
        return FOOTER_VIEW_TYPE;
    }

    @Override
    public boolean isFooterType(int viewType) {
        return FOOTER_VIEW_TYPE == viewType;
    }

    @Override
    public int headTypeOf(CommonBean commonBean) {
        return HEADER_VIEW_TYPE;
    }

    @Override
    public boolean isHeadType(int viewType) {
        return viewType == HEADER_VIEW_TYPE;
    }

    @Override
    public <VB extends ViewBinding> VB headBindingOf(int viewType, ViewGroup parent) {
        return (VB) HeadLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public <VB extends ViewBinding> JViewHolder<CommonBean, VB> headHolderOf(VB binding, int viewType) {
        return new JViewHolder<>(binding);
    }
}
