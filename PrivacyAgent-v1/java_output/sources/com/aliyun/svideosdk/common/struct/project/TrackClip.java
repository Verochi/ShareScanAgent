package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackClip {
    private transient int mClipId;

    @com.google.gson.annotations.SerializedName("DenoiseWeight")
    private int mDenoiseWeight;

    @com.google.gson.annotations.SerializedName("MediaId")
    private java.lang.String mMediaId;

    @com.google.gson.annotations.SerializedName("MixWeight")
    private int mMixWeight = -1;

    @com.google.gson.annotations.SerializedName("TimelineIn")
    private float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    private float mTimelineOut;

    public int getClipId() {
        return this.mClipId;
    }

    public int getDenoiseWeight() {
        return this.mDenoiseWeight;
    }

    public java.lang.String getMediaId() {
        return this.mMediaId;
    }

    public int getMixWeight() {
        return this.mMixWeight;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public void setClipId(int i) {
        this.mClipId = i;
    }

    public void setDenoiseWeight(int i) {
        this.mDenoiseWeight = i;
    }

    public void setMediaId(java.lang.String str) {
        this.mMediaId = str;
    }

    public void setMixWeight(int i) {
        this.mMixWeight = i;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }
}
