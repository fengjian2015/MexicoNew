package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * lucksoft
 * Created by AndroidDevelop on 2020年3月31日,0031.
 * 158045632@qq.com
 */
public class StaffsBean implements Serializable {

    /**
     * StaffId : 14701729388492800
     * CommissionMoney : 0
     * Remark :
     */

    private int CommissionMoney;
    private String StaffId="";
    private String Remark="";

    public int getCommissionMoney() {
        return CommissionMoney;
    }

    public void setCommissionMoney(int commissionMoney) {
        CommissionMoney = commissionMoney;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
