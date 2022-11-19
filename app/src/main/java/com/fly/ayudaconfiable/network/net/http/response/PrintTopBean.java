package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class PrintTopBean {
    /**
     * name : 订单编号
     * key : BillCode
     * size : 8
     * align : left
     * value : XF201908031028000403
     * bold : 0
     * iscustom : 0
     * enable : 1
     */

    private String name = "";
    private String key="";
    private int size;
    private String align = "";
    private String value = "";
    private int bold;
    private int iscustom;
    private int enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getBold() {
        return bold;
    }

    public void setBold(int bold) {
        this.bold = bold;
    }

    public int getIscustom() {
        return iscustom;
    }

    public void setIscustom(int iscustom) {
        this.iscustom = iscustom;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }
}
