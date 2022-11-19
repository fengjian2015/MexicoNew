package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

public class OilTypeBean implements Serializable {

    /**
     * ClassID : 2
     * ClassName : 柴油
     */

    private String ClassID;
    private String ClassName;

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
}
