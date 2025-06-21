package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class OSSUploadInfo implements java.io.Serializable {
    private java.lang.String bucket;
    private java.lang.String endpoint;
    private java.lang.String md5;
    private java.lang.String object;
    private java.lang.String videoID;

    public java.lang.String getBucket() {
        return this.bucket;
    }

    public java.lang.String getEndpoint() {
        return this.endpoint;
    }

    public java.lang.String getMd5() {
        return this.md5;
    }

    public java.lang.String getObject() {
        return this.object;
    }

    public java.lang.String getVideoID() {
        return this.videoID;
    }

    public void setBucket(java.lang.String str) {
        this.bucket = str;
    }

    public void setEndpoint(java.lang.String str) {
        this.endpoint = str;
    }

    public void setMd5(java.lang.String str) {
        this.md5 = str;
    }

    public void setObject(java.lang.String str) {
        this.object = str;
    }

    public void setVideoID(java.lang.String str) {
        this.videoID = str;
    }
}
