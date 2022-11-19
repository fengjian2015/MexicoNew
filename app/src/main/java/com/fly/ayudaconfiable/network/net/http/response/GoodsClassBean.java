package com.fly.ayudaconfiable.network.net.http.response;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class GoodsClassBean extends AbstractExpandableItem<GoodsClassBean> implements MultiItemEntity, Serializable {
    /**
     * ClassName : 商品类型
     * ParentID : 0
     * ParentList : 0|14272953160022016
     * ShopID : 14272953155303424
     * IsDelete : 0
     * ModifyTime : 20190706151520
     * ModifyUid : 14272953155336192
     * DeleteTime : 0
     * CreateUid : 14272953155336192
     * CreateTime : 20190528183847
     * CompID : 198
     * Id : 14272953160022016
     */

    private String ClassName = "";
    private String ParentID = "";
    private String ParentList = "";
    private String ShopID = "";
    private int IsDelete;
    private long ModifyTime;
    private String ModifyUid = "";
    private int DeleteTime;
    private String CreateUid = "";
    private long CreateTime;
    private int CompID;
    private String Id = "";
    private int IsCombo;

    public boolean isCombo = false;
    public boolean isSelected = false;

    public List<GoodsClassBean> childGoodsClass;
    public int itemType = 0;

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String ParentID) {
        this.ParentID = ParentID;
    }

    public String getParentList() {
        return ParentList;
    }

    public void setParentList(String ParentList) {
        this.ParentList = ParentList;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String ShopID) {
        this.ShopID = ShopID;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int IsDelete) {
        this.IsDelete = IsDelete;
    }

    public long getModifyTime() {
        return ModifyTime;
    }

    public void setModifyTime(long ModifyTime) {
        this.ModifyTime = ModifyTime;
    }

    public String getModifyUid() {
        return ModifyUid;
    }

    public void setModifyUid(String ModifyUid) {
        this.ModifyUid = ModifyUid;
    }

    public int getDeleteTime() {
        return DeleteTime;
    }

    public void setDeleteTime(int DeleteTime) {
        this.DeleteTime = DeleteTime;
    }

    public String getCreateUid() {
        return CreateUid;
    }

    public void setCreateUid(String CreateUid) {
        this.CreateUid = CreateUid;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getCompID() {
        return CompID;
    }

    public void setCompID(int CompID) {
        this.CompID = CompID;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    @Override
    public int getLevel() {
        return itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public int getIsCombo() {
        return IsCombo;
    }

    public void setIsCombo(int isCombo) {
        IsCombo = isCombo;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
