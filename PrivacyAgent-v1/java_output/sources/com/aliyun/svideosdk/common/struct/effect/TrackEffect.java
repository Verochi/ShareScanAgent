package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackEffect<BEAN extends com.aliyun.svideosdk.common.struct.effect.EffectBase> {
    protected BEAN bean;
    protected long duration;
    protected long startTime;

    public TrackEffect(long j, long j2, BEAN bean) {
        this.bean = bean;
        this.startTime = j;
        this.duration = j2;
    }

    public BEAN getBean() {
        return this.bean;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public long getEndTime() {
        return this.startTime + this.duration;
    }

    public long getEndTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime + this.duration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public int getResId() {
        return this.bean.getResId();
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.bean.getSource();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public int getViewId() {
        return this.bean.getViewId();
    }

    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.duration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.bean.setSource(source);
    }

    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.startTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setViewId(int i) {
        this.bean.setViewId(i);
    }
}
