package com.fly.ayudaconfiable.network.net.http.response;

import java.util.ArrayList;

public class ProductStaffBean {

    private String productId = "";
    private ArrayList<StaffAndClassBean> productStaffList = new ArrayList<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ArrayList<StaffAndClassBean> getProductStaffList() {
        return productStaffList;
    }

    public void setProductStaffList(ArrayList<StaffAndClassBean> productStaffList) {
        this.productStaffList = productStaffList;
    }
}
