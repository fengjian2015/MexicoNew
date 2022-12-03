package com.lucksoft.commonui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public class JFooterAdapter<F, VB extends ViewBinding> extends RecyclerView.Adapter<JViewHolder<F, VB>> {

    private final JMultiTypeHFLAdapter.ViewHolderDelegate<F> mViewHolderDelegate;
    private final JFooterItemFactory<F> mFactory;
    private LayoutInflater layoutInflater;
    private final List<F> mData = new ArrayList<>();

    public JFooterAdapter(JFooterItemFactory<F> factory, JMultiTypeHFLAdapter.ViewHolderDelegate<F> footerDelegate) {
        mFactory = factory;
        mViewHolderDelegate = footerDelegate;
    }

    @NonNull
    @Override
    public JViewHolder<F, VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.footerHolderOf(mFactory.footerBindingOf(viewType, parent), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull JViewHolder<F, VB> holder, int position) {
        holder.bindViewHolder(mData.get(position), mViewHolderDelegate);
    }

    public void setData(List<F> data) {
        mData.clear();
        if (data != null && !data.isEmpty()) {
            mData.addAll(data);
        }
    }

    public void addData(F data) {
        if (data != null) {
            mData.add(data);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mFactory.footerTypeOf(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private LayoutInflater getLayoutInflater(Context context) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        return layoutInflater;
    }

}
