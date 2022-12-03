package com.lucksoft.commonui.adapter;

public class JMultiTypeLAdapter<T> extends JMultiTypeHFLAdapter<CommonBean, CommonBean, T> {

    protected JMultiTypeLAdapter(JCommonItemFactory<T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate, ViewHolderDelegate<CommonBean> headerDelegate, ViewHolderDelegate<CommonBean> footerDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, headerDelegate, footerDelegate);
    }

    public JMultiTypeLAdapter(JMultiTypeItemFactory<CommonBean, CommonBean, T> factory, ViewHolderDelegate<T> viewHolderDelegate, LoadMoreViewHolderDelegate loadMoreViewHolderDelegate) {
        super(factory, viewHolderDelegate, loadMoreViewHolderDelegate, null, null);
    }
}
