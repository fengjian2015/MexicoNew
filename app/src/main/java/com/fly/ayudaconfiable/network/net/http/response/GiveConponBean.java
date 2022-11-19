package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class GiveConponBean implements Serializable {

    /**
     * Id : 14332517962364928
     * Qty : 22
     * Name : 测试代金券
     */
    private int Qty;
    private String Id="";
    private String Name="";

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
