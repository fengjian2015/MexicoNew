package com.fly.ayudaconfiable.network.net.http.request;


/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 * 商品消费跟 计次项目消费共用 Detail 项
 */
public class ProductConsumeDetail {

    private int GoodsType = 0;
    private int IsModify = 0;
    private int IsCombo;
    private int IsLimit = 1;
    private long PassDate;
    private double TotalMoney = 0;
    private double DiscountAmount = 0;
    private double CouponAmount = 0;
    private double DiscountPrice = 0;
    private double Number = 0;
    private String BatchCode = "";
    private String GoodsID = "";
    private String GoodsCode = "";
    private String GoodsName = "";
    private String SpecsId = "";
    private String MemberCountCardID = "";
    private String OrderDetailID = "";
    private String GID = "";
    private String StartTime = "0";
    private String EndTime = "0";
    private String OriginalMoney = "0";
    //0新增数量 1修改信息 2扣减数量
    private int OperateType = 0;
    private String StaffType = "";
    /*仅手牌开单的时候 商品的提成员工需要传这个字段 其他都传下面那个 这是李金山写的代码 CD*/

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
    }

    public int getIsModify() {
        return IsModify;
    }

    public void setIsModify(int isModify) {
        IsModify = isModify;
    }

    public int getIsCombo() {
        return IsCombo;
    }

    public void setIsCombo(int isCombo) {
        IsCombo = isCombo;
    }

    public int getIsLimit() {
        return IsLimit;
    }

    public void setIsLimit(int isLimit) {
        IsLimit = isLimit;
    }

    public long getPassDate() {
        return PassDate;
    }

    public void setPassDate(long passDate) {
        PassDate = passDate;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public double getDiscountAmount() {
        return DiscountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        DiscountAmount = discountAmount;
    }

    public double getCouponAmount() {
        return CouponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        CouponAmount = couponAmount;
    }

    public double getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        DiscountPrice = discountPrice;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double number) {
        Number = number;
    }

    public String getBatchCode() {
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String goodsID) {
        GoodsID = goodsID;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getSpecsId() {
        return SpecsId;
    }

    public void setSpecsId(String specsId) {
        SpecsId = specsId;
    }

    public String getMemberCountCardID() {
        return MemberCountCardID;
    }

    public void setMemberCountCardID(String memberCountCardID) {
        MemberCountCardID = memberCountCardID;
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        OrderDetailID = orderDetailID;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getOriginalMoney() {
        return OriginalMoney;
    }

    public void setOriginalMoney(String originalMoney) {
        OriginalMoney = originalMoney;
    }

    public int getOperateType() {
        return OperateType;
    }

    public void setOperateType(int operateType) {
        OperateType = operateType;
    }

    public String getStaffType() {
        return StaffType;
    }

    public void setStaffType(String staffType) {
        StaffType = staffType;
    }


    public static ProductConsumeDetail createSame(ProductConsumeDetail detail) {
        ProductConsumeDetail bean = new ProductConsumeDetail();
        bean.setIsModify(detail.getIsModify());
        bean.setIsLimit(detail.getIsLimit());
        bean.setGoodsType(detail.getGoodsType());
        bean.setIsCombo(detail.getIsCombo());
        bean.setDiscountAmount(detail.getDiscountAmount());
        bean.setCouponAmount(detail.getCouponAmount());
        bean.setDiscountPrice(detail.getDiscountPrice());
        bean.setNumber(detail.getNumber());
        bean.setTotalMoney(detail.getTotalMoney());
        bean.setPassDate(detail.getPassDate());
        bean.setGID(detail.getGID());
        bean.setBatchCode(detail.getBatchCode());
        bean.setGoodsID(detail.getGoodsID());
        bean.setGoodsCode(detail.getGoodsCode());
        bean.setGoodsName(detail.getGoodsName());
        bean.setSpecsId(detail.getSpecsId());
        bean.setMemberCountCardID(detail.getMemberCountCardID());
        bean.setStaffType(detail.getStaffType());
        bean.setStartTime(detail.getStartTime());
        bean.setEndTime(detail.getEndTime());
        bean.setOriginalMoney(detail.getOriginalMoney());
        bean.setOperateType(detail.getOperateType());
        bean.setOrderDetailID(detail.getOrderDetailID());
        return bean;
    }
}
