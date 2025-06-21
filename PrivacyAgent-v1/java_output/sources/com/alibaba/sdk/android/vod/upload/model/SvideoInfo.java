package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class SvideoInfo {
    private java.lang.Integer cateId;
    private java.lang.String desc;
    private boolean isProcess = true;
    private boolean isShowWaterMark = false;
    private int priority = 6;
    private java.util.List<java.lang.String> tags;
    private java.lang.String title;
    private java.lang.String userData;

    public java.lang.Integer getCateId() {
        return this.cateId;
    }

    public java.lang.String getDesc() {
        return this.desc;
    }

    public int getPriority() {
        return this.priority;
    }

    public java.util.List<java.lang.String> getTags() {
        return this.tags;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getUserData() {
        return this.userData;
    }

    public boolean isProcess() {
        return this.isProcess;
    }

    public boolean isShowWaterMark() {
        return this.isShowWaterMark;
    }

    public void setCateId(java.lang.Integer num) {
        this.cateId = num;
    }

    public void setDesc(java.lang.String str) {
        this.desc = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setProcess(boolean z) {
        this.isProcess = z;
    }

    public void setShowWaterMark(boolean z) {
        this.isShowWaterMark = z;
    }

    public void setTags(java.util.List<java.lang.String> list) {
        this.tags = list;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setUserData(java.lang.String str) {
        this.userData = str;
    }
}
