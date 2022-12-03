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

public class JMultiTypeHFLAdapter<H, F, T> extends RecyclerView.Adapter<JViewHolder<?, ?>> {

    private boolean isLoadingMore = false;
    private final LoadMoreBean mLoadMoreBean = new LoadMoreBean();
    private final JMultiTypeItemFactory<H, F, T> mFactory;
    private final ViewHolderDelegate<T> mViewHolderDelegate;
    private final LoadMoreViewHolderDelegate mLoadMoreViewHolderDelegate;
    private final JHeaderAdapter<H, ViewBinding> mHeaderAdapter;
    private final JFooterAdapter<F, ViewBinding> mFooterAdapter;
    private boolean showLoadMore = false;
    private final List<T> mData = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private RecyclerView mRecycler;

    public JMultiTypeHFLAdapter(JMultiTypeItemFactory<H, F, T> factory, ViewHolderDelegate<T> viewHolderDelegate
            , LoadMoreViewHolderDelegate loadMoreViewHolderDelegate
            , ViewHolderDelegate<H> headerDelegate
            , ViewHolderDelegate<F> footerDelegate) {
        mFactory = factory;
        mHeaderAdapter = new JHeaderAdapter<>(factory, headerDelegate);
        mFooterAdapter = new JFooterAdapter<>(factory, footerDelegate);
        mViewHolderDelegate = viewHolderDelegate;
        mLoadMoreViewHolderDelegate = loadMoreViewHolderDelegate;
    }

    @NonNull
    @Override
    public JViewHolder<?, ViewBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mFactory.isLoadMoreType(viewType)) {
            return mFactory.loadMoreHolderOf(mFactory.loadMoreBindingOf(parent));
        }
        if (mFactory.isFooterType(viewType)) {
            return mFooterAdapter.onCreateViewHolder(parent, viewType);
        }
        if (mFactory.isHeadType(viewType)) {
            return mFactory.headHolderOf(mFactory.headBindingOf(viewType, parent), viewType);
        }

        return mFactory.holderOf(mFactory.viewBindingOf(viewType, parent), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull JViewHolder holder, int position) {
        if (mFactory.isLoadMoreType(getItemViewType(position))) {
            ((JLoadMoreViewHolder) holder).bindLoadMoreHolder(mLoadMoreBean, mLoadMoreViewHolderDelegate);
            return;
        }

        if (mFactory.isHeadType(getItemViewType(position))) {
            mHeaderAdapter.onBindViewHolder(holder, position);
            return;
        }

        if (mFactory.isFooterType(getItemViewType(position))) {
            mFooterAdapter.onBindViewHolder(holder, getFooterPosition(position));
            return;
        }
        holder.bindViewHolder(mData.get(getItemPosition(position)), mViewHolderDelegate);
    }

    public void addRefreshData(List<T> data) {
        mData.clear();
        if (data != null && !data.isEmpty()) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }

    public void addHisData(List<T> data) {
        if (data != null && !data.isEmpty()) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mHeaderAdapter.getItemCount() + mData.size() + mFooterAdapter.getItemCount() + getLoadMoreItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mHeaderAdapter.getItemCount()) {
            return mHeaderAdapter.getItemViewType(position);
        }
        position -= mHeaderAdapter.getItemCount();
        if (position < mData.size()) {
            return mFactory.typeOf(mData.get(position));
        }
        position -= mData.size();
        if (position < mFooterAdapter.getItemCount()) {
            return mFooterAdapter.getItemViewType(position);
        }
        return mFactory.loadMoreTypeOf();
    }

    /**
     * Returns true if the footer configured is not null.
     */
    private boolean hasLoadMore() {
        return showLoadMore;
    }

    private int getLoadMorePosition() {
        return getItemCount() - 1;
    }

    private int getLoadMoreItemCount() {
        return hasLoadMore() ? 1 : 0;
    }

    private int getItemPosition(int position) {
        return position - mHeaderAdapter.getItemCount();
    }

    private int getFooterPosition(int position) {
        return position - mHeaderAdapter.getItemCount() - mData.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecycler = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecycler = null;
    }

    private boolean isNotFullList() {
        if (mRecycler == null) {
            return false;
        }
        return mRecycler.getVisibility() == View.VISIBLE
                && !mRecycler.canScrollVertically(-1)
                && !mRecycler.canScrollVertically(1);
    }

    public void onLoadMore() {
        showLoadMore = true;
        isLoadingMore = true;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.LOADING);
        notifyItemChanged(getLoadMorePosition());
    }

    public void disableLoadMore() {
        showLoadMore = true;
        isLoadingMore = true;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.NONE);
        notifyItemChanged(getLoadMorePosition());
    }

    public void finishLoadMore() {
        showLoadMore = true;
        isLoadingMore = false;
        if (isNotFullList()) {
            mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.NONE);
        } else {
            mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.LOADING);
        }
        notifyItemChanged(getLoadMorePosition());
    }

    public void loadError() {
        showLoadMore = true;
        isLoadingMore = false;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.LOADED_ERROR);
        notifyItemChanged(getLoadMorePosition());
    }

    public void noMore() {
        showLoadMore = true;
        isLoadingMore = false;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.NO_MORE);
        notifyItemChanged(getLoadMorePosition());
    }

    public void clearFinishFlag() {
        showLoadMore = true;
        isLoadingMore = false;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.NONE);
        notifyItemChanged(getLoadMorePosition());
    }

    public void goneLoadMore() {
        showLoadMore = true;
        isLoadingMore = false;
        mLoadMoreBean.setState(LoadMoreBean.LoadingMoreState.NONE);
    }

    public boolean canLoadMore() {
        // 没有更多了不在触发
        if (!hasLoadMore()) {
            return false;
        }
        if (mLoadMoreBean.getState() == LoadMoreBean.LoadingMoreState.NO_MORE) {
            return false;
        }
        if (mData.isEmpty() || isLoadingMore) {
            return false;
        }
        return true;
    }

    public void addHeader(H h) {
        mHeaderAdapter.addData(h);
        notifyDataSetChanged();
    }

    public void setHeader(List<H> data) {
        mHeaderAdapter.setData(data);
        notifyDataSetChanged();
    }

    public int getHeaderCount() {
        return mHeaderAdapter.getItemCount();
    }

    public void addFooter(F h) {
        mFooterAdapter.addData(h);
        notifyDataSetChanged();
    }

    public void setFooter(List<F> data) {
        mFooterAdapter.setData(data);
        notifyDataSetChanged();
    }

    public int getFooterCount() {
        return mFooterAdapter.getItemCount();
    }

    private LayoutInflater getLayoutInflater(Context context) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        return layoutInflater;
    }


    public interface ViewHolderDelegate<T> {
        void invoker(final JViewHolder<T, ?> holder, final T data, final int position);
    }

    public interface LoadMoreViewHolderDelegate {
        void invoker(final JViewHolder<LoadMoreBean, ?> holder, final LoadMoreBean data);
    }
}
