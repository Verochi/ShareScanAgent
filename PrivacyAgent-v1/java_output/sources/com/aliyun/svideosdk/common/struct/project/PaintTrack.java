package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class PaintTrack extends com.aliyun.svideosdk.common.struct.project.GlobalTrack {

    @com.google.gson.annotations.SerializedName("CanvasInfo")
    private com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    @com.google.gson.annotations.SerializedName("TimelineIn")
    private float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    private float mTimelineOut;

    public PaintTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.paint);
    }

    public com.aliyun.svideosdk.common.struct.CanvasInfo getCanvasInfo() {
        return this.canvasInfo;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public void setCanvasInfo(com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo) {
        this.canvasInfo = canvasInfo;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }
}
