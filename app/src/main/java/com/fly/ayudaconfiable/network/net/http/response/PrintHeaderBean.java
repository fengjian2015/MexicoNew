package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class PrintHeaderBean {
    /**
     * name : 店铺名称
     * key : ShopName
     * size : 8
     * align : left
     * bold : 1
     * iscustom : 1
     * enable : 1
     * value : 3423423
     */

    private String name= "";
    private String key= "";
    private int size;
    private String align= "";
    private int bold;
    private int iscustom;
    private int enable;
    private String value = "";

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
