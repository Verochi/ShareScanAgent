package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class ActionRotate extends com.aliyun.svideosdk.common.struct.effect.ActionRotateBase {

    @com.google.gson.annotations.SerializedName("Clockwise")
    protected boolean mClockwise;

    @com.google.gson.annotations.SerializedName("DurationPerCircle")
    protected float mDurationPerCircle;

    @com.google.gson.annotations.SerializedName("From")
    protected float mFromDegree;

    @com.google.gson.annotations.SerializedName("Repeat")
    protected boolean mRepeat;

    public ActionRotate() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_repeat;
    }

    public float getDurationPerCircle() {
        return this.mDurationPerCircle;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public boolean isRepeat() {
        return this.mRepeat;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    @java.lang.Deprecated
    public void setAnimationConfig(java.lang.String str) {
        throw new java.lang.RuntimeException("Not Support");
    }

    public void setClockwise(boolean z) {
        this.mClockwise = z;
    }

    public void setDurationPerCircle(long j) {
        this.mDurationPerCircle = j / 1000000.0f;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    @java.lang.Deprecated
    public void setRepeat(boolean z) {
        this.mRepeat = z;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setRepeatCount(int i) {
        setRepeat(i > 0);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode repeatMode) {
        throw new java.lang.RuntimeException("Not Support");
    }
}
