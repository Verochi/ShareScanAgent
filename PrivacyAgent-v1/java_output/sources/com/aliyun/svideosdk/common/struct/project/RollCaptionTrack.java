package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class RollCaptionTrack extends com.aliyun.svideosdk.common.struct.project.PasterTrack {

    @com.google.gson.annotations.SerializedName("Items")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip> mRollCaptionTrackClips = new java.util.ArrayList();

    public RollCaptionTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.RollCaptionTrackClip> getRollCaptionTrackClips() {
        return this.mRollCaptionTrackClips;
    }
}
