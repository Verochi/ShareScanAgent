package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class PasterTrack extends com.aliyun.svideosdk.common.struct.project.Track {

    @com.google.gson.annotations.SerializedName("Type")
    private com.aliyun.svideosdk.common.struct.project.PasterTrack.Type mType;

    public enum Type {
        photo,
        gif,
        subtitle,
        bubble_caption,
        caption,
        roll_captions
    }

    public com.aliyun.svideosdk.common.struct.project.PasterTrack.Type getType() {
        return this.mType;
    }

    public void setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type) {
        this.mType = type;
    }
}
