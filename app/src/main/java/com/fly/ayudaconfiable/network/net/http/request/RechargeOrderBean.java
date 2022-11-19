package com.fly.ayudaconfiable.network.net.http.request;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 */
public class RechargeOrderBean {
    /**
     {"OrderInfo":{"MemID":"14336590382725120","TotalMoney":1.0,"RealMoney":2.0,"GiveMoney":1.0,"IsModify":0,"Remark":"","Source":1},
     * */
    private int Source = 3;
    private String MemID = "";
    private int IsModify = 0;
    private double TotalMoney = 0.00;
    private double RealMoney = 0.00;
    private double GiveMoney = 0.00;
    private String Remark = "";
    private String AccountType = "";

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
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

    public double getRealMoney() {
        return RealMoney;
    }

    public void setRealMoney(double realMoney) {
        RealMoney = realMoney;
    }

    public double getGiveMoney() {
        return GiveMoney;
    }

    public void setGiveMoney(double giveMoney) {
        GiveMoney = giveMoney;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getIsModify() {
        return IsModify;
    }

    public void setIsModify(int isModify) {
        IsModify = isModify;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
}
