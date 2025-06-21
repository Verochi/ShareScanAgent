package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TailWaterMark extends com.aliyun.svideosdk.common.struct.project.WaterMark {

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    private float mDuration = 3.0f;

    public TailWaterMark() {
        setType(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.tail_watermark);
    }

    public long getDuration() {
        return (long) (this.mDuration * 1000000.0f);
    }

    public void setDuration(long j) {
        this.mDuration = j / 1000000.0f;
    }
}
