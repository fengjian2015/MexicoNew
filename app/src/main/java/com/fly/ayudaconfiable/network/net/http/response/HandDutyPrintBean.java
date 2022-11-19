package com.fly.ayudaconfiable.network.net.http.response;

/**
 * lucksoft
 * Created by AndroidDevelop on 2020/8/31.
 * 158045632@qq.com
 */
public class HandDutyPrintBean {

    private boolean isTitle;
    private int alignmentType;
    private String printItem = "";
    private String leftData = "";
    private String centerData = "";
    private String rightData = "";
    /*打一条线*/
    private boolean printLine = false;
    /*从左往右打一行*/
    private boolean sortPlace = false;
    /*直接从中间打一行*/
    private boolean centerPlace = false;
    /*换行*/
    private boolean feedOneLine = false;

    public HandDutyPrintBean() {
    }

    public HandDutyPrintBean(String printItem) {
        this.isTitle = false;
        this.printItem = printItem;
    }

    public HandDutyPrintBean(boolean isTitle, String printItem) {
        this.isTitle = isTitle;
        this.printItem = printItem;
    }

    public HandDutyPrintBean(int alignmentType, String printItem) {
        this.alignmentType = alignmentType;
        this.printItem = printItem;
    }

    public HandDutyPrintBean(String leftData, String centerData, String rightData) {
        this.leftData = leftData;
        this.centerData = centerData;
        this.rightData = rightData;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public int getAlignmentType() {
        return alignmentType;
    }

    public void setAlignmentType(int alignmentType) {
        this.alignmentType = alignmentType;
    }

    public String getPrintItem() {
        return printItem;
    }

    public void setPrintItem(String printItem) {
        this.printItem = printItem;
    }

    public String getLeftData() {
        return leftData;
    }

    public void setLeftData(String leftData) {
        this.leftData = leftData;
    }

    public String getCenterData() {
        return centerData;
    }

    public void setCenterData(String centerData) {
        this.centerData = centerData;
    }

    public String getRightData() {
        return rightData;
    }

    public void setRightData(String rightData) {
        this.rightData = rightData;
    }

    public boolean isCenterPlace() {
        return centerPlace;
    }

    public void setCenterPlace(boolean centerPlace) {
        this.centerPlace = centerPlace;
    }

    public boolean isFeedOneLine() {
        return feedOneLine;
    }

    public void setFeedOneLine(boolean feedOneLine) {
        this.feedOneLine = feedOneLine;
    }

    public boolean isPrintLine() {
        return printLine;
    }

    public void setPrintLine(boolean printLine) {
        this.printLine = printLine;
    }

    public boolean isSortPlace() {
        return sortPlace;
    }

    public void setSortPlace(boolean sortPlace) {
        this.sortPlace = sortPlace;
    }
}
