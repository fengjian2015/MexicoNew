package com.lucksoft.commonui;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class AllDataLiveDataWrapper<K, T> {

    public K mSearchKey;

    /**
     * 全量数据
     */
    public final MutableLiveData<List<T>> mLiveData = new MutableLiveData<>();

    public void post(K searchText, List<T> data) {
        mSearchKey = searchText;
        mLiveData.postValue(data);
    }
}
