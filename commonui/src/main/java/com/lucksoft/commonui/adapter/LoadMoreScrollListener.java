package com.lucksoft.commonui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoadMoreScrollListener extends RecyclerView.OnScrollListener {

    private final ILoadMoreDelegate mDelegate;
    private boolean mIsScrollUp = false;

    public LoadMoreScrollListener(ILoadMoreDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        mIsScrollUp = dy > 0;
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            //有回调接口，且不是加载状态，且计算后剩下2个item，且处于向下滑动，则自动加载
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();
                if (mIsScrollUp && totalItemCount > 2 && lastVisibleItemPosition >= totalItemCount - 2)
                    if (mDelegate.canLoadMore()) {
                        mDelegate.onLoadMore();
                    }
            }
        }
    }
}
