package com.aliyun.svideo.crop.bean;

/* loaded from: classes.dex */
public class AlivcCropOutputParam implements java.io.Serializable {
    public static final java.lang.String RESULT_KEY_OUTPUT_PARAM = "outputParam";
    private long mDuration;
    private java.lang.String mOutputPath;
    private long mStartTime;

    public long getDuration() {
        return this.mDuration;
    }

    public java.lang.String getOutputPath() {
        return this.mOutputPath;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setOutputPath(java.lang.String str) {
        this.mOutputPath = str;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }
}
