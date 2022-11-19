package com.fly.ayudaconfiable.network.net.http.request;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月9日,0009.
 * 158045632@qq.com
 */
public class PointExchangeOrder {
    /**
     * OrderType : 0
     * MemberPwd :
     * MemID :
     * TotalMoney : 0
     * Remark :
     * Source : 0
     * Status : 0
     * LogisticsWay : 0
     * ConsigneeID :
     */
    private int OrderType = 6;
    private String MemberPwd;
    private String MemID;
    private double TotalMoney;
    private String Remark;
    private int Source = 3;
    private int Status;
    private int LogisticsWay;
    private String ConsigneeID;

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public String getMemberPwd() {
        return MemberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        MemberPwd = memberPwd;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String memID) {
        MemID = memID;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getLogisticsWay() {
        return LogisticsWay;
    }

    public void setLogisticsWay(int logisticsWay) {
        LogisticsWay = logisticsWay;
    }

    public String getConsigneeID() {
        return ConsigneeID;
    }

    public void setConsigneeID(String consigneeID) {
        ConsigneeID = consigneeID;
    }
}
