package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectTrack extends com.aliyun.svideosdk.common.struct.project.Track {

    @com.google.gson.annotations.SerializedName("TimelineIn")
    protected float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    protected float mTimelineOut;

    @com.google.gson.annotations.SerializedName("Type")
    private com.aliyun.svideosdk.common.struct.project.EffectTrack.Type mType;

    public enum Type {
        time_effect,
        filter,
        animation_filter,
        mv,
        lut_filter
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public com.aliyun.svideosdk.common.struct.project.EffectTrack.Type getType() {
        return this.mType;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }

    public void setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type type) {
        this.mType = type;
    }
}
