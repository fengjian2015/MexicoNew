package com.fly.ayudaconfiable.network.net.http.response;

public class MemberAccountBean {

    /**
     * Id : 15846632336816128
     * AccountType : 006
     * IsEnable : 0
     * Sort : 2
     */

    //是否启用 0：启用 1：不启用
    private int IsEnable;
    //排序
    private int Sort;
    private String Id = "";
    //账户类别 002:通用账户 006 汽油账户  007 柴油账户  008 天然气账户
    private String AccountType = "";

    public int getIsEnable() {
        return IsEnable;
    }

    public void setIsEnable(int isEnable) {
        IsEnable = isEnable;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int sort) {
        Sort = sort;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
}
