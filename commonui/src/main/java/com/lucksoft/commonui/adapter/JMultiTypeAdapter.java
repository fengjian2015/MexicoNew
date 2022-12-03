package com.lucksoft.commonui.adapter;

public class JMultiTypeAdapter<T> extends JMultiTypeHFLAdapter<CommonBean, CommonBean, T> {

    protected JMultiTypeAdapter(JCommonItemFactory<T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate, ViewHolderDelegate<CommonBean> headerDelegate, ViewHolderDelegate<CommonBean> footerDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, headerDelegate, footerDelegate);
    }

    public JMultiTypeAdapter(JMultiTypeItemFactory<CommonBean, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate) {
        super(factory, viewHolderDelegate, null, null, null);
    }
}
