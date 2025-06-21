package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class VideoEffect extends com.aliyun.svideosdk.common.struct.project.Effect {
    private transient long mDurationMills;
    private transient int mId;

    @com.google.gson.annotations.SerializedName("In")
    private float mIn;

    @com.google.gson.annotations.SerializedName("Out")
    private float mOut;
    private transient int mStreamId;

    public VideoEffect(com.aliyun.svideosdk.common.struct.project.Effect.Type type, int i, int i2, long j, long j2) {
        super(type);
        this.mId = i2;
        this.mStreamId = i;
        float f = j / 1000.0f;
        this.mIn = f;
        this.mDurationMills = j2;
        this.mOut = f + (j2 / 1000.0f);
    }

    public long getDuration() {
        return (long) ((this.mOut - this.mIn) * 1000.0f);
    }

    public int getId() {
        return this.mId;
    }

    public float getIn() {
        return this.mIn;
    }

    public float getOut() {
        return this.mOut;
    }

    public long getStartTime() {
        return (long) (this.mIn * 1000.0f);
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public void setDuration(long j) {
        this.mDurationMills = j;
        this.mOut = this.mIn + (j / 1000.0f);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setStartTime(long j) {
        float f = j / 1000.0f;
        this.mIn = f;
        this.mOut = f + (this.mDurationMills / 1000.0f);
    }

    public void setStreamId(int i) {
        this.mStreamId = i;
    }
}
