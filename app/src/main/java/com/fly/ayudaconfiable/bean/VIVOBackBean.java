package com.fly.ayudaconfiable.bean;

import java.io.Serializable;

public class VIVOBackBean implements Serializable {
    private String headPhotoUrl;
    private double liveNessScore;
    private String liveNessId;

    @Override
    public String toString() {
        return "VIVOBackBean{" +
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

    public double getLiveNessScore() {
        return liveNessScore;
    }

    public void setLiveNessScore(double liveNessScore) {
        this.liveNessScore = liveNessScore;
    }

    public String getLiveNessId() {
        return liveNessId;
    }

    public void setLiveNessId(String liveNessId) {
        this.liveNessId = liveNessId;
    }
}
