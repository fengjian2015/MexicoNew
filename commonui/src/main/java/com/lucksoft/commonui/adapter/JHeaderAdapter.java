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

public class JHeaderAdapter<H, VB extends ViewBinding> extends RecyclerView.Adapter<JViewHolder<H, VB>> {

    private final JMultiTypeHFLAdapter.ViewHolderDelegate<H> mViewHolderDelegate;
    private final JHeaderItemFactory<H> mFactory;
    private LayoutInflater layoutInflater;
    private final List<H> mData = new ArrayList<>();

    public JHeaderAdapter(JHeaderItemFactory<H> factory, JMultiTypeHFLAdapter.ViewHolderDelegate<H> headerDelegate) {
        mFactory = factory;
        mViewHolderDelegate = headerDelegate;
    }

    @NonNull
    @Override
    public JViewHolder<H, VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mFactory.headHolderOf(mFactory.headBindingOf(viewType, parent), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull JViewHolder<H, VB> holder, int position) {
        holder.bindViewHolder(mData.get(position), mViewHolderDelegate);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mFactory.headTypeOf(mData.get(position));
    }

    private LayoutInflater getLayoutInflater(Context context) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        return layoutInflater;
    }

    public void setData(List<H> data) {
        mData.clear();
        if (data != null && !data.isEmpty()) {
            mData.addAll(data);
        }
    }

    public void addData(H data) {
        if (data != null) {
            mData.add(data);
        }
    }
}
