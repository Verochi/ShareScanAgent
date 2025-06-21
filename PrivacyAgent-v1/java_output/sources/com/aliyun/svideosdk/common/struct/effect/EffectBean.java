package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class EffectBean {
    private int mId;
    private int mMvAudioId;
    private int mOldId;
    private com.aliyun.svideosdk.common.struct.project.Source mSource;
    private long mStartTime;
    private long mStreamDuration;
    private long mStreamStartTime;
    private long mDuration = 2147483647L;
    private int mWeight = 50;

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideosdk.common.struct.effect.EffectBean) && this.mId == ((com.aliyun.svideosdk.common.struct.effect.EffectBean) obj).mId;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public int getId() {
        return this.mId;
    }

    public int getMvAudioId() {
        return this.mMvAudioId;
    }

    public int getOldId() {
        return this.mOldId;
    }

    @java.lang.Deprecated
    public java.lang.String getPath() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mSource;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public long getStreamDuration() {
        return this.mStreamDuration;
    }

    public long getStreamDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.mStreamDuration, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public long getStreamStartTime() {
        return this.mStreamStartTime;
    }

    public long getStreamStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.mStreamStartTime, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public int getWeight() {
        return this.mWeight;
    }

    public void setDuration(long j) {
        setDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mDuration = timeUnit.toMicros(j);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMvAudioId(int i) {
        this.mMvAudioId = i;
    }

    public void setOldId(int i) {
        this.mOldId = i;
    }

    @java.lang.Deprecated
    public void setPath(java.lang.String str) {
        this.mSource = new com.aliyun.svideosdk.common.struct.project.Source(str);
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setStartTime(long j) {
        setStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mStartTime = timeUnit.toMicros(j);
    }

    public void setStreamDuration(long j) {
        setStreamDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setStreamDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mStreamDuration = timeUnit.toMicros(j);
    }

    public void setStreamStartTime(long j) {
        setStreamStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setStreamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mStreamStartTime = timeUnit.toMicros(j);
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }

    public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream toTrackAudioStream() {
        com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder().streamId(getId()).source(getSource());
        long startTime = getStartTime();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        return source.startTime(startTime, timeUnit).streamStartTime(getStreamStartTime(), timeUnit).streamDuration(getStreamDuration(), timeUnit).audioWeight(getWeight()).build();
    }

    public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter toTrackEffectFilter() {
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder().source(getSource());
        long startTime = getStartTime();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        return source.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).resId(getId()).build();
    }

    public com.aliyun.svideosdk.common.struct.effect.TrackEffectMV toTrackMV() {
        com.aliyun.svideosdk.common.struct.effect.TrackEffectMV.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackEffectMV.Builder().source(getSource());
        long startTime = getStartTime();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        com.aliyun.svideosdk.common.struct.effect.TrackEffectMV build = source.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).build();
        build.setAudioStreamId(getMvAudioId());
        build.setViewId(getId());
        return build;
    }
}
