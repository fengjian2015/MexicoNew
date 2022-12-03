package com.lucksoft.commonui.adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public class JViewHolder<T, VB extends ViewBinding> extends RecyclerView.ViewHolder {

    public final VB binding;
    public JViewHolder(@NonNull VB vb) {
        super(vb.getRoot());
        this.binding = vb;
    }

    public void bindViewHolder(T data, JMultiTypeHFLAdapter.ViewHolderDelegate<T> delegate) {
        if (delegate != null) {
            delegate.invoker(this, data, getAbsoluteAdapterPosition());
        }
    }
}
