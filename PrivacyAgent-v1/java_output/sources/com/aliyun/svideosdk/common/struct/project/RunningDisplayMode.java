package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class RunningDisplayMode extends com.aliyun.svideosdk.common.struct.project.VideoEffect {

    @com.google.gson.annotations.SerializedName("Mode")
    private int mDisplayMode;

    public RunningDisplayMode(int i, int i2, long j, long j2, int i3) {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.running_display_mode, i, i2, j, j2);
        this.mDisplayMode = i3;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }

    public java.lang.String toString() {
        return "RunningDisplayMode{mId=" + getId() + ", mDisplayMode=" + this.mDisplayMode + ", mStartTimeMills=" + getStartTime() + ", mDurationMills=" + getDuration() + ", mStreamId=" + getStreamId() + '}';
    }
}
