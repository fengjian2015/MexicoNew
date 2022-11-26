package com.fly.ayudaconfiable.bean;

import java.io.Serializable;

public class VIVOBackBean implements Serializable {
    private String liveNessId;
    private double liveNessScore;
    private String fileType;
    private String fileName;
    private String headPhotoUrl;

    @Override
    public String toString() {
        return "VIVOBackBean{" +
                "liveNessId='" + liveNessId + '\'' +
                ", liveNessScore=" + liveNessScore +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", headPhotoUrl='" + headPhotoUrl + '\'' +
                '}';
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
