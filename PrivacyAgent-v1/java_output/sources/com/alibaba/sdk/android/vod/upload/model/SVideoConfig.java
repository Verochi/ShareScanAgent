package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class SVideoConfig {
    private java.lang.String accessKeyId;
    private java.lang.String accessKeySecret;
    private java.lang.String appId;
    private java.lang.String expriedTime;
    private java.lang.String imagePath;
    private boolean isTranscode;
    private long partSize;
    private java.lang.String requestId;
    private java.lang.String secrityToken;
    private java.lang.String storageLocation;
    private java.lang.String templateGroupId;
    private java.lang.String userData;
    private java.lang.String videoId;
    private java.lang.String videoPath;
    private com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo;
    private java.lang.String workFlowId;

    public java.lang.String getAccessKeyId() {
        return this.accessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public java.lang.String getExpriedTime() {
        return this.expriedTime;
    }

    public java.lang.String getImagePath() {
        return this.imagePath;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public java.lang.String getSecrityToken() {
        return this.secrityToken;
    }

    public java.lang.String getStorageLocation() {
        return this.storageLocation;
    }

    public java.lang.String getTemplateGroupId() {
        return this.templateGroupId;
    }

    public java.lang.String getUserData() {
        return this.userData;
    }

    public java.lang.String getVideoId() {
        return this.videoId;
    }

    public java.lang.String getVideoPath() {
        return this.videoPath;
    }

    public com.alibaba.sdk.android.vod.upload.model.VodInfo getVodInfo() {
        return this.vodInfo;
    }

    public java.lang.String getWorkFlowId() {
        return this.workFlowId;
    }

    public boolean isTranscode() {
        return this.isTranscode;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.accessKeySecret = str;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setExpriedTime(java.lang.String str) {
        this.expriedTime = str;
    }

    public void setImagePath(java.lang.String str) {
        this.imagePath = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setSecrityToken(java.lang.String str) {
        this.secrityToken = str;
    }

    public void setStorageLocation(java.lang.String str) {
        this.storageLocation = str;
    }

    public void setTemplateGroupId(java.lang.String str) {
        this.templateGroupId = str;
    }

    public void setTranscode(boolean z) {
        this.isTranscode = z;
    }

    public void setUserData(java.lang.String str) {
        this.userData = str;
    }

    public void setVideoId(java.lang.String str) {
        this.videoId = str;
    }

    public void setVideoPath(java.lang.String str) {
        this.videoPath = str;
    }

    public void setVodInfo(com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }

    public void setWorkFlowId(java.lang.String str) {
        this.workFlowId = str;
    }
}
