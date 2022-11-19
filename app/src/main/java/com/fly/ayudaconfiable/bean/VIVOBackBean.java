package com.fly.ayudaconfiable.bean;

import java.io.Serializable;

public class VIVOBackBean implements Serializable {
    private String headPhotoUrl;
    private String liveNessScore;
    private String liveNessId;

    @Override
    public String toString() {
        return "VIVOBackBean{" +
                "headPhotoUrl='" + headPhotoUrl + '\'' +
                ", liveNessScore='" + liveNessScore + '\'' +
                ", liveNessId='" + liveNessId + '\'' +
                '}';
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public String getLiveNessScore() {
        return liveNessScore;
    }

    public void setLiveNessScore(String liveNessScore) {
        this.liveNessScore = liveNessScore;
    }

    public String getLiveNessId() {
        return liveNessId;
    }

    public void setLiveNessId(String liveNessId) {
        this.liveNessId = liveNessId;
    }
}
