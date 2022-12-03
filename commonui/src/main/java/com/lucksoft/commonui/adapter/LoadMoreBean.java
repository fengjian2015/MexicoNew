package com.lucksoft.commonui.adapter;

public class LoadMoreBean {
    private LoadingMoreState mState = LoadingMoreState.NONE;

    public void setState(LoadingMoreState state) {
        mState = state;
    }

    public LoadingMoreState getState() {
        return mState;
    }

    public static enum LoadingMoreState {
        // 不显示，加载中，加载失败点击重试，没有更多了，加载完成
        NONE, LOADING, LOADED_ERROR, NO_MORE, FINISH
    }
}
