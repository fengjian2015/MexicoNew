package com.fly.ayudaconfiable.network.net.http.response;

public class LatestConsumeBean {

    /***
     *    /// 消费金额
     *         /// </summary>
     *         public decimal DiscountMoney { get; set; }
     *         /// <summary>
     *         /// 油品类型名称
     *         /// </summary>
     *         public string OilsClassName { get; set; }
     *         /// <summary>
     *         /// 油品名称
     *         /// </summary>
     *         public string GoodsName { get; set; }
     *         /// <summary>
     *         /// 油枪号
     *         /// </summary>
     *         public string OilGunNum { get; set; }
     *         /// <summary>
     *         /// 消费数量
     *         /// </summary>
     *         public string TotalNum { get; set; }*/
    private String DiscountMoney="";
    private String OilsClassName="";
    private String GoodsName="";
    private String OilGunNum="";
    private String TotalNum="";
    private String Unit="";

    public String getDiscountMoney() {
        return DiscountMoney;
    }

    public void setDiscountMoney(String discountMoney) {
        DiscountMoney = discountMoney;
    }

    public String getOilsClassName() {
        return OilsClassName;
    }

    public void setOilsClassName(String oilsClassName) {
        OilsClassName = oilsClassName;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getOilGunNum() {
        return OilGunNum;
    }

    public void setOilGunNum(String oilGunNum) {
        OilGunNum = oilGunNum;
    }

    public String getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(String totalNum) {
        TotalNum = totalNum;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
