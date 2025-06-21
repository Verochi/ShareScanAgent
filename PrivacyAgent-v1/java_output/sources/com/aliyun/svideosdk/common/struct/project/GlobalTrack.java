package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class GlobalTrack extends com.aliyun.svideosdk.common.struct.project.Track {

    @com.google.gson.annotations.SerializedName("Type")
    private com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type mType;

    public enum Type {
        paint,
        watermark,
        tail_watermark
    }

    public com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type getType() {
        return this.mType;
    }

    public void setType(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type type) {
        this.mType = type;
    }
}
