package com.fly.ayudaconfiable.network.net.http.request;

import java.io.Serializable;

public class ActivityForQucikPayTranse implements Serializable {

    private double ActivityAmount;
    private String ActId="";
    private String ActName="";

    public void setActivityAmount(double activityAmount) {
        ActivityAmount = activityAmount;
    }

    public void setActId(String actId) {
        ActId = actId;
    }

    public void setActName(String actName) {
        ActName = actName;
    }
}
