package com.fly.ayudaconfiable.network.net.http.response;

public class InfoBean {

    private String title = "";
    private String content = "";
    private int contentColor;
    private boolean gotoMemberList;

    public boolean isGotoMemberList() {
        return gotoMemberList;
    }

    public void setGotoMemberList(boolean gotoMemberList) {
        this.gotoMemberList = gotoMemberList;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
