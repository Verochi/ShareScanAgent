package com.aliyun.svideo.editor.bean;

/* loaded from: classes31.dex */
public class AlivcEditOutputParam {
    private java.lang.String mConfigPath;
    private int mOutputVideoHeight;
    private int mOutputVideoWidth;
    private java.lang.String mThumbnailPath;
    private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam mVideoParam;
    private float mVideoRatio;

    public java.lang.String getConfigPath() {
        return this.mConfigPath;
    }

    public int getOutputVideoHeight() {
        return this.mOutputVideoHeight;
    }

    public int getOutputVideoWidth() {
        return this.mOutputVideoWidth;
    }

    public java.lang.String getThumbnailPath() {
        return this.mThumbnailPath;
    }

    public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam getVideoParam() {
        return this.mVideoParam;
    }

    public float getVideoRatio() {
        return this.mVideoRatio;
    }

    public void setConfigPath(java.lang.String str) {
        this.mConfigPath = str;
    }

    public void setOutputVideoHeight(int i) {
        this.mOutputVideoHeight = i;
    }

    public void setOutputVideoWidth(int i) {
        this.mOutputVideoWidth = i;
    }

    public void setThumbnailPath(java.lang.String str) {
        this.mThumbnailPath = str;
    }

    public void setVideoParam(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam) {
        this.mVideoParam = aliyunVideoParam;
    }

    public void setVideoRatio(float f) {
        this.mVideoRatio = f;
    }
}
