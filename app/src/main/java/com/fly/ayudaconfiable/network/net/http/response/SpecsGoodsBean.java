package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class SpecsGoodsBean implements Serializable {
    /**
     * Id : 14475124125333504
     * GoodsID : 14475124118927360
     * SpecsKeyID : 14461106671499264
     * SpecsKeyName : 颜色
     * SpecsValueID : 14462087371323392
     * SpecsValueName : 星河银
     * CompID : 198
     * SoftNum : 1
     */
    private String Id="";
    private String GoodsID;
    private String SpecsKeyID;
    private String SpecsKeyName;
    private String SpecsValueID;
    private String SpecsValueName;
    private int CompID;
    private int SoftNum;

    public int parentIndex = 0;
    public int startIndex = 0;
    public int selectedIndex = -1;
    public boolean isSelected = false;
    public boolean isEnable = true;
    public List<SpecsGoodsBean> specsGoods = null;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String GoodsID) {
        this.GoodsID = GoodsID;
    }

    public String getSpecsKeyID() {
        return SpecsKeyID;
    }

    public void setSpecsKeyID(String SpecsKeyID) {
        this.SpecsKeyID = SpecsKeyID;
    }

    public String getSpecsKeyName() {
        return SpecsKeyName;
    }

    public void setSpecsKeyName(String SpecsKeyName) {
        this.SpecsKeyName = SpecsKeyName;
    }

    public String getSpecsValueID() {
        return SpecsValueID;
    }

    public void setSpecsValueID(String SpecsValueID) {
        this.SpecsValueID = SpecsValueID;
    }

    public String getSpecsValueName() {
        return SpecsValueName;
    }

    public void setSpecsValueName(String SpecsValueName) {
        this.SpecsValueName = SpecsValueName;
    }

    public int getCompID() {
        return CompID;
    }

    public void setCompID(int CompID) {
        this.CompID = CompID;
    }

    public int getSoftNum() {
        return SoftNum;
    }

    public void setSoftNum(int SoftNum) {
        this.SoftNum = SoftNum;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

}
