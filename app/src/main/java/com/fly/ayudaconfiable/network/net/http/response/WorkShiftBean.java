package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class WorkShiftBean {

    private String title = "";
    private String classTitle = "";
    private String chargeTypeTitle = "";
    private String titleLeft = "";
    private String titleMiddle = "";
    private String titleRight = "";
    private boolean showChargeType = false;
    private boolean hiddenBigTitle = false;
    private boolean hiddenThreeTitle = false;
    private boolean hiddenClassTitle = false;
    private List<WorkShiftDetailsBean.ItemBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public String getChargeTypeTitle() {
        return chargeTypeTitle;
    }

    public void setChargeTypeTitle(String chargeTypeTitle) {
        this.chargeTypeTitle = chargeTypeTitle;
    }

    public String getTitleLeft() {
        return titleLeft;
    }

    public void setTitleLeft(String titleLeft) {
        this.titleLeft = titleLeft;
    }

    public String getTitleMiddle() {
        return titleMiddle;
    }

    public void setTitleMiddle(String titleMiddle) {
        this.titleMiddle = titleMiddle;
    }

    public String getTitleRight() {
        return titleRight;
    }

    public void setTitleRight(String titleRight) {
        this.titleRight = titleRight;
    }

    public boolean isShowChargeType() {
        return showChargeType;
    }

    public void setShowChargeType(boolean showChargeType) {
        this.showChargeType = showChargeType;
    }

    public boolean isHiddenBigTitle() {
        return hiddenBigTitle;
    }

    public void setHiddenBigTitle(boolean hiddenBigTitle) {
        this.hiddenBigTitle = hiddenBigTitle;
    }

    public boolean isHiddenThreeTitle() {
        return hiddenThreeTitle;
    }

    public void setHiddenThreeTitle(boolean hiddenThreeTitle) {
        this.hiddenThreeTitle = hiddenThreeTitle;
    }

    public boolean isHiddenClassTitle() {
        return hiddenClassTitle;
    }

    public void setHiddenClassTitle(boolean hiddenClassTitle) {
        this.hiddenClassTitle = hiddenClassTitle;
    }

    public List<WorkShiftDetailsBean.ItemBean> getList() {
        return list;
    }

    public void setList(List<WorkShiftDetailsBean.ItemBean> list) {
        this.list = list;
    }
}
