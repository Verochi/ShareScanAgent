package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class VideoTrack extends com.aliyun.svideosdk.common.struct.project.MediaTrack {

    @com.google.gson.annotations.SerializedName("ClipList")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> mVideoTrackClips = new java.util.ArrayList();

    public java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> getVideoTrackClips() {
        return this.mVideoTrackClips;
    }
}
