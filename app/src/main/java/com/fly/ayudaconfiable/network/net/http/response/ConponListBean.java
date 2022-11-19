package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class ConponListBean {

    int total;
    List<ListConponBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListConponBean> getList() {
        return list;
    }

    public void setList(List<ListConponBean> list) {
        this.list = list;
    }
}
