package com.fly.ayudaconfiable.network.net.http.request;

public class CouponForQucikPayTranse {

    private double CouponAmount;
    private String ConponSendId="";
    private String ConponCode="";

    public double getCouponAmount() {
        return CouponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        CouponAmount = couponAmount;
    }

    public String getConponSendId() {
        return ConponSendId;
    }

    public void setConponSendId(String conponSendId) {
        ConponSendId = conponSendId;
    }

    public String getConponCode() {
        return ConponCode;
    }

    public void setConponCode(String conponCode) {
        ConponCode = conponCode;
    }
}
