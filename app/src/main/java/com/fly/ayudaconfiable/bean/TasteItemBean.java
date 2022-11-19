package com.fly.ayudaconfiable.bean;

import java.io.Serializable;

public class TasteItemBean implements Serializable {

    private int IsSelected;
    private double ItemPrice;
    private String FlavorValueID = "";
    private String FlavorID = "";
    private String ItemName = "";

    public int getIsSelected() {
        return IsSelected;
    }

    public void setIsSelected(int isSelected) {
        IsSelected = isSelected;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getFlavorValueID() {
        return FlavorValueID;
    }

    public void setFlavorValueID(String flavorValueID) {
        FlavorValueID = flavorValueID;
    }

    public String getFlavorID() {
        return FlavorID;
    }

    public void setFlavorID(String flavorID) {
        FlavorID = flavorID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public static TasteItemBean cloneSelf(TasteItemBean bean) {
        TasteItemBean newBean = new TasteItemBean();
        newBean.setIsSelected(bean.getIsSelected());
        newBean.setItemPrice(bean.getItemPrice());
        newBean.setFlavorValueID(bean.getFlavorValueID());
        newBean.setFlavorID(bean.getFlavorID());
        newBean.setItemName(bean.getItemName());
        return newBean;
    }
}
