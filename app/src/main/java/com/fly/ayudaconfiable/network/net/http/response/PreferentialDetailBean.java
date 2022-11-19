package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class PreferentialDetailBean {
    /**
     * ActivityAmount : 0
     * CouponAmount : 4.8
     * ZeroAmount : 0
     * SingleAmount : 0
     */

    private double ActivityAmount;
    private double CouponAmount;
    private double ZeroAmount;
    private double SingleAmount;
    private double PostageTotalAmount;
    private double DiscountAmount;

    public double getActivityAmount() {
        return ActivityAmount;
    }

    public void setActivityAmount(double activityAmount) {
        ActivityAmount = activityAmount;
    }

    public double getCouponAmount() {
        return CouponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        CouponAmount = couponAmount;
    }

    public double getZeroAmount() {
        return ZeroAmount;
    }

    public void setZeroAmount(double zeroAmount) {
        ZeroAmount = zeroAmount;
    }

    public double getSingleAmount() {
        return SingleAmount;
    }

    public void setSingleAmount(double singleAmount) {
        SingleAmount = singleAmount;
    }

    public double getPostageTotalAmount() {
        return PostageTotalAmount;
    }

    public void setPostageTotalAmount(double postageTotalAmount) {
        PostageTotalAmount = postageTotalAmount;
    }

    public double getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        DiscountAmount = discountAmount;
    }
}
