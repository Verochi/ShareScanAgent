package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TimeFilter extends com.aliyun.svideosdk.common.struct.project.EffectTrack {
    private transient java.lang.Long mDuration;

    @com.google.gson.annotations.SerializedName("NeedOriginDuration")
    private boolean mIsNeedOriginDuration;

    @com.google.gson.annotations.SerializedName("TimeParam")
    private float mParam;

    @com.google.gson.annotations.SerializedName("EffectType")
    private int mTimeFilterType;

    public TimeFilter() {
        setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.time_effect);
    }

    public TimeFilter(int i, long j, long j2, int i2, float f, boolean z) {
        this();
        setId(i);
        this.mDuration = java.lang.Long.valueOf(j2);
        this.mTimeFilterType = i2;
        this.mParam = f;
        this.mIsNeedOriginDuration = z;
        float f2 = j / 1000.0f;
        this.mTimelineIn = f2;
        this.mTimelineOut = f2 + (r1.longValue() / 1000.0f);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.aliyun.svideosdk.common.struct.project.TimeFilter timeFilter = (com.aliyun.svideosdk.common.struct.project.TimeFilter) obj;
        return this.mTimelineIn == timeFilter.mTimelineIn && this.mDuration.equals(timeFilter.mDuration) && this.mTimeFilterType == timeFilter.mTimeFilterType && this.mParam == timeFilter.mParam;
    }

    public long getDuration() {
        return (long) ((this.mTimelineOut - this.mTimelineIn) * 1000.0f);
    }

    public float getParam() {
        return this.mParam;
    }

    public long getStartTime() {
        return (long) (this.mTimelineIn * 1000.0f);
    }

    public int getTimeFilterType() {
        return this.mTimeFilterType;
    }

    public boolean isNeedOriginDuration() {
        return this.mIsNeedOriginDuration;
    }

    public void setDuration(long j) {
        this.mDuration = java.lang.Long.valueOf(j);
        this.mTimelineOut = this.mTimelineIn + (r3.longValue() / 1000.0f);
    }

    public void setNeedOriginDuration(boolean z) {
        this.mIsNeedOriginDuration = z;
    }

    public void setParam(float f) {
        this.mParam = f;
    }

    public void setStartTime(long j) {
        if (this.mDuration == null) {
            this.mDuration = java.lang.Long.valueOf(((long) (this.mTimelineIn - this.mTimelineOut)) * 1000);
        }
        float f = j / 1000.0f;
        this.mTimelineIn = f;
        this.mTimelineOut = f + (this.mDuration.longValue() / 1000.0f);
    }

    public void setTimeFilterType(int i) {
        this.mTimeFilterType = i;
    }
}
