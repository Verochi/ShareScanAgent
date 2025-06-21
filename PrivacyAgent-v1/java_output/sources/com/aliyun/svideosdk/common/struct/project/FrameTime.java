package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class FrameTime implements java.io.Serializable {
    private static final long serialVersionUID = 7821490823848983173L;
    public double beginTime;
    public double endTime;
    public double maxTime;
    public double minTime;
    public int shrink;

    public double getBeginTime() {
        return this.beginTime;
    }

    public double getEndTime() {
        return this.endTime;
    }

    public double getMaxTime() {
        return this.maxTime;
    }

    public double getMinTime() {
        return this.minTime;
    }

    public int getShrink() {
        return this.shrink;
    }

    public void setBeginTime(double d) {
        this.beginTime = d;
    }

    public void setEndTime(double d) {
        this.endTime = d;
    }

    public void setMaxTime(double d) {
        this.maxTime = d;
    }

    public void setMinTime(double d) {
        this.minTime = d;
    }

    public void setShrink(int i) {
        this.shrink = i;
    }
}
