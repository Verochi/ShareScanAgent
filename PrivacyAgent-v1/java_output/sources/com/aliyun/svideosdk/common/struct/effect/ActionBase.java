package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class ActionBase {

    @com.google.gson.annotations.SerializedName("AnimationConfig")
    protected java.lang.String mAnimationConfig;
    protected transient java.lang.Long mDuration;
    protected transient int mId;
    protected transient boolean mIsStream;

    @com.google.gson.annotations.SerializedName("PartParam")
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam mPartParam;
    protected transient int mTargetId;

    @com.google.gson.annotations.SerializedName("TimelineIn")
    protected float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    protected float mTimelineOut;

    @com.google.gson.annotations.SerializedName("Type")
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase.Type mType;

    @com.google.gson.annotations.SerializedName("SourceId")
    private java.lang.String resId;

    @com.google.gson.annotations.SerializedName("Scope")
    protected int mScope = com.aliyun.svideosdk.common.struct.effect.ActionBase.Scope.Overall.ordinal();

    @com.google.gson.annotations.SerializedName("TimelineInOffset")
    protected float mStartOffset = -1.0f;

    @com.google.gson.annotations.SerializedName("FillBefore")
    protected int mFillBefore = -1;

    @com.google.gson.annotations.SerializedName("FillAfter")
    protected int mFillAfter = -1;

    @com.google.gson.annotations.SerializedName("RepeatCount")
    protected int mRepeatCount = -1;

    @com.google.gson.annotations.SerializedName("RepeatMode")
    protected int mRepeatMode = -1;

    @com.google.gson.annotations.SerializedName("InterpolatorType")
    protected int mInterpolatorType = -1;

    public enum Interpolator {
        Linear,
        Accelerate,
        Decelerate,
        Accelerate_Decelerate,
        Overshot,
        Anticipate,
        Anticipate_Overshot,
        Bound,
        Cycle
    }

    public static class PartParam {

        @com.google.gson.annotations.SerializedName("Mode")
        private int mode = 0;

        @com.google.gson.annotations.SerializedName("OverlayRadio")
        private float overlayRadio = 0.0f;

        public enum Mode {
            Sequence,
            Reverse,
            Random,
            Middle
        }

        public void setMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam.Mode mode) {
            this.mode = mode.ordinal();
        }

        public void setOverlayRadio(float f) {
            this.overlayRadio = java.lang.Math.min(1.0f, java.lang.Math.max(f, 0.0f));
        }
    }

    public enum RepeatMode {
        None,
        Restart,
        Reverse
    }

    public enum Scope {
        Overall,
        Part
    }

    public enum Type {
        alpha,
        scale,
        translate,
        rotate_repeat,
        rotate_by,
        rotate_to,
        swipe,
        custom,
        action_set
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideosdk.common.struct.effect.ActionBase) && ((com.aliyun.svideosdk.common.struct.effect.ActionBase) obj).mId == this.mId;
    }

    public java.lang.String getAnimationConfig() {
        return this.mAnimationConfig;
    }

    public long getDuration() {
        return (long) ((this.mTimelineOut - this.mTimelineIn) * 1000000.0f);
    }

    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public int getId() {
        return this.mId;
    }

    public java.lang.String getResId() {
        return this.resId;
    }

    public long getStartTime() {
        return (long) (this.mTimelineIn * 1000000.0f);
    }

    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public int getTargetId() {
        return this.mTargetId;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public com.aliyun.svideosdk.common.struct.effect.ActionBase.Type getType() {
        return this.mType;
    }

    public boolean isStream() {
        return this.mIsStream;
    }

    @java.lang.Deprecated
    public void setAnimationConfig(java.lang.String str) {
        this.mAnimationConfig = str;
    }

    public void setDuration(long j) {
        setDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mDuration = java.lang.Long.valueOf(timeUnit.toMicros(j));
        this.mTimelineOut = this.mTimelineIn + (r3.longValue() / 1000000.0f);
    }

    public void setFillAfter(boolean z) {
        this.mFillAfter = z ? 1 : 0;
    }

    public void setFillBefore(boolean z) {
        this.mFillBefore = z ? 1 : 0;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setInterpolatorType(com.aliyun.svideosdk.common.struct.effect.ActionBase.Interpolator interpolator) {
        this.mInterpolatorType = interpolator.ordinal();
    }

    public void setIsStream(boolean z) {
        this.mIsStream = z;
    }

    public void setPartParam(com.aliyun.svideosdk.common.struct.effect.ActionBase.PartParam partParam) {
        this.mPartParam = partParam;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(com.aliyun.svideosdk.common.struct.effect.ActionBase.RepeatMode repeatMode) {
        this.mRepeatMode = repeatMode.ordinal();
    }

    public void setResId(java.lang.String str) {
        this.resId = str;
    }

    public void setScope(com.aliyun.svideosdk.common.struct.effect.ActionBase.Scope scope) {
        this.mScope = scope.ordinal();
    }

    public void setStartOffset(long j) {
        this.mStartOffset = j / 1000000.0f;
    }

    public void setStartTime(long j) {
        setStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (this.mDuration == null) {
            this.mDuration = java.lang.Long.valueOf(((long) (this.mTimelineOut - this.mTimelineIn)) * 1000000);
        }
        float micros = timeUnit.toMicros(j) / 1000000.0f;
        this.mTimelineIn = micros;
        this.mTimelineOut = micros + (this.mDuration.longValue() / 1000000.0f);
    }

    public void setTargetId(int i) {
        this.mTargetId = i;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }

    public void setType(com.aliyun.svideosdk.common.struct.effect.ActionBase.Type type) {
        this.mType = type;
    }
}
