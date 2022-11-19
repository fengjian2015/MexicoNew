package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class GoodsUnitBean {
    /**
     * UnitName : kg
     * IsDelete : 0
     * CreateTime : 0001-01-01 00:00:00
     * Id : 1
     */
    private String UnitName;
    private int IsDelete;
    private String CreateTime;
    private int Id;

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String UnitName) {
        this.UnitName = UnitName;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int IsDelete) {
        this.IsDelete = IsDelete;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
