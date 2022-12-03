package com.lucksoft.commonui.adapter;

public class JMultiTypeFAdapter<T, F> extends JMultiTypeHFLAdapter<CommonBean, F, T> {

    protected JMultiTypeFAdapter(JMultiTypeItemFactory<CommonBean, F, T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate, ViewHolderDelegate<CommonBean> headerDelegate, ViewHolderDelegate<F> footerDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, headerDelegate, footerDelegate);
    }

    public JMultiTypeFAdapter(JMultiTypeItemFactory<CommonBean, F, T> factory, ViewHolderDelegate<T> viewHolderDelegate, ViewHolderDelegate<F> footerDelegate) {
        super(factory, viewHolderDelegate, null, null, footerDelegate);
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
