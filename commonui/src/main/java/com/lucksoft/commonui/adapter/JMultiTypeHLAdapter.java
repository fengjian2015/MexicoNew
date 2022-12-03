package com.lucksoft.commonui.adapter;

public class JMultiTypeHLAdapter<H, T> extends JMultiTypeHFLAdapter<H, CommonBean, T> {

    protected JMultiTypeHLAdapter(JMultiTypeItemFactory<H, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate, ViewHolderDelegate<H> headerDelegate, ViewHolderDelegate<CommonBean> footerDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, headerDelegate, footerDelegate);
    }

    public JMultiTypeHLAdapter(JMultiTypeItemFactory<H, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, null, null);
    }


    @Override
    public void onLoadMore() {
    }

    public void disableLoadMore() {
    }

    public void finishLoadMore() {
    }

    public void loadError() {
    }

    public void noMore() {
    }

    public void clearFinishFlag() {
    }

    public void goneLoadMore() {
    }

    public boolean canLoadMore() {
        return false;
    }
}
