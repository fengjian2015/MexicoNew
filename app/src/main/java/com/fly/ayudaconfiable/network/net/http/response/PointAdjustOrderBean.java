package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月14日,0014.
 * 158045632@qq.com
 */
public class PointAdjustOrderBean {
    /**
     * BillCode : BD20190814000002
     * ChangeType : 0
     * ChangePoint : 86
     * EndPoint : 547.91
     */

    private String BillCode;
    private int ChangeType;
    private double ChangePoint;
    private double EndPoint;

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public int getChangeType() {
        return ChangeType;
    }

    public void setChangeType(int ChangeType) {
        this.ChangeType = ChangeType;
    }

    public double getChangePoint() {
        return ChangePoint;
    }

    public void setChangePoint(double ChangePoint) {
        this.ChangePoint = ChangePoint;
    }

    public double getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(double EndPoint) {
        this.EndPoint = EndPoint;
    }
}
