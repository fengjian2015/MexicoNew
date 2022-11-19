package com.fly.ayudaconfiable.bean;

import java.io.Serializable;
import java.util.List;

public class FlavorBean implements Serializable {

    /**
     * FlavorID : 15434659316168706
     * GoodsID : 15434659315791872
     * FlavorName : 温度
     * SelectType : 0
     * IsMustBeSelected : 1
     * MinSelectedItems : 0
     * MaxSelectedItems : 0
     * ItemList : [{"FlavorValueID":"15434659316168707","FlavorID":"15434659316168706","ItemName":"常温","ItemPrice":0,"IsSelected":1},{"FlavorValueID":"15434659316168708","FlavorID":"15434659316168706","ItemName":"热","ItemPrice":0,"IsSelected":0},{"FlavorValueID":"15434659316168709","FlavorID":"15434659316168706","ItemName":"沙冰","ItemPrice":0,"IsSelected":0}]
     */

    private String FlavorID = "";
    private String GoodsID = "";
    private String FlavorName = "";
    /*1多选  0单选*/
    private int SelectType;
    /*1必须选择*/
    private int IsMustBeSelected;
    private int MinSelectedItems;
    private int MaxSelectedItems;
    /*本地添加字段*/
    private boolean selected;
    private List<TasteItemBean> ItemList;

    public String getFlavorID() {
        return FlavorID;
    }

    public void setFlavorID(String flavorID) {
        FlavorID = flavorID;
    }

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String goodsID) {
        GoodsID = goodsID;
    }

    public String getFlavorName() {
        return FlavorName;
    }

    public void setFlavorName(String flavorName) {
        FlavorName = flavorName;
    }

    public int getSelectType() {
        return SelectType;
    }

    public void setSelectType(int selectType) {
        SelectType = selectType;
    }

    public int getIsMustBeSelected() {
        return IsMustBeSelected;
    }

    public void setIsMustBeSelected(int isMustBeSelected) {
        IsMustBeSelected = isMustBeSelected;
    }

    public int getMinSelectedItems() {
        return MinSelectedItems;
    }

    public void setMinSelectedItems(int minSelectedItems) {
        MinSelectedItems = minSelectedItems;
    }

    public int getMaxSelectedItems() {
        return MaxSelectedItems;
    }

    public void setMaxSelectedItems(int maxSelectedItems) {
        MaxSelectedItems = maxSelectedItems;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<TasteItemBean> getItemList() {
        return ItemList;
    }

    public void setItemList(List<TasteItemBean> itemList) {
        ItemList = itemList;
    }
}
