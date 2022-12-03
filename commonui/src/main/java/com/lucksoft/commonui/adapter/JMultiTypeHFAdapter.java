package com.lucksoft.commonui.adapter;

public class JMultiTypeHFAdapter<H, F, T> extends JMultiTypeHFLAdapter<H, F, T> {

    public JMultiTypeHFAdapter(JMultiTypeItemFactory<H, F, T> factory, ViewHolderDelegate<T> viewHolderDelegate, ViewHolderDelegate<H> headerDelegate, ViewHolderDelegate<F> footerDelegate) {
        super(factory, viewHolderDelegate, null, headerDelegate, footerDelegate);
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
