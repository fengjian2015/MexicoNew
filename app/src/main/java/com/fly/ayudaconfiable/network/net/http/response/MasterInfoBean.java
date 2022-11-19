package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class MasterInfoBean implements Serializable {

    /**
     * NewMembersToday : 0
     * SalesToday : 0
     * RechargeCountToday : 0
     * MasterAccount : admin
     * MasterName : 黄兴林3
     * RoleName :
     * UserName : 黄兴林3
     * Mobile : 15208885311
     * HotLine :
     * CustomerQQ :
     * QrCode :
     */

    private int NewMembersToday;
    private double SalesToday;
    private double RechargeCountToday;
    private String MasterAccount;
    private String MasterName;
    private String RoleName;
    private String Mobile;
    private String Address;
    private String HotLine;
    private String CustomerQQ;
    private String QrCode;

    public int getNewMembersToday() {
        return NewMembersToday;
    }

    public void setNewMembersToday(int newMembersToday) {
        NewMembersToday = newMembersToday;
    }

    public double getSalesToday() {
        return SalesToday;
    }

    public void setSalesToday(double salesToday) {
        SalesToday = salesToday;
    }

    public double getRechargeCountToday() {
        return RechargeCountToday;
    }

    public void setRechargeCountToday(double rechargeCountToday) {
        RechargeCountToday = rechargeCountToday;
    }

    public String getMasterAccount() {
        return MasterAccount;
    }

    public void setMasterAccount(String masterAccount) {
        MasterAccount = masterAccount;
    }

    public String getMasterName() {
        return MasterName;
    }

    public void setMasterName(String masterName) {
        MasterName = masterName;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHotLine() {
        return HotLine;
    }

    public void setHotLine(String hotLine) {
        HotLine = hotLine;
    }

    public String getCustomerQQ() {
        return CustomerQQ;
    }

    public void setCustomerQQ(String customerQQ) {
        CustomerQQ = customerQQ;
    }

    public String getQrCode() {
        return QrCode;
    }

    public void setQrCode(String qrCode) {
        QrCode = qrCode;
    }

}
