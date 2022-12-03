package com.lucksoft.commonui.adapter;

public class JMultiTypeHAdapter<H, T> extends JMultiTypeHFLAdapter<H, CommonBean, T> {

    protected JMultiTypeHAdapter(JMultiTypeItemFactory<H, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate, ViewHolderDelegate<H> headerDelegate, ViewHolderDelegate<CommonBean> footerDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, headerDelegate, footerDelegate);
    }

    public JMultiTypeHAdapter(JMultiTypeItemFactory<H, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate, ViewHolderDelegate<H> headerDelegate) {
        super(factory, viewHolderDelegate, null, headerDelegate, null);
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
