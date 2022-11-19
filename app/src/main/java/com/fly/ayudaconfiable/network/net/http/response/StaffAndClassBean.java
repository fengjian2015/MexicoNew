package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月6日,0006.
 * 158045632@qq.com
 */
public class StaffAndClassBean implements Serializable {

    /**
     * Id : 14296805436766208
     * StaffClassId : 14296595217954816
     * StaffName : 老白
     * ClassName : 送货员
     */

    private int AssignType;
    private double commissionMoney;
    private boolean isSelected;
    private String Id = "";
    private String StaffClassId = "";
    private String StaffName = "";
    private String ClassName = "";
    private String remark = "";

    public int getAssignType() {
        return AssignType;
    }

    public void setAssignType(int assignType) {
        AssignType = assignType;
    }

    public double getCommissionMoney() {
        return commissionMoney;
    }

    public void setCommissionMoney(double commissionMoney) {
        this.commissionMoney = commissionMoney;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStaffClassId() {
        return StaffClassId;
    }

    public void setStaffClassId(String staffClassId) {
        StaffClassId = staffClassId;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static StaffAndClassBean createSelfBean(StaffAndClassBean bean) {
        StaffAndClassBean newBean = new StaffAndClassBean();
        newBean.setId(bean.getId());
        newBean.setStaffClassId(bean.getStaffClassId());
        newBean.setClassName(bean.getClassName());
        newBean.setStaffName(bean.getStaffName());
        newBean.setCommissionMoney(bean.getCommissionMoney());
        newBean.setRemark(bean.getRemark());
        newBean.setAssignType(bean.getAssignType());
        newBean.setSelected(bean.isSelected());
        return newBean;
    }

}
