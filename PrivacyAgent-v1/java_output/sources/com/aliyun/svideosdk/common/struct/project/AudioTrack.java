package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AudioTrack extends com.aliyun.svideosdk.common.struct.project.MediaTrack {

    @com.google.gson.annotations.SerializedName("ClipList")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrackClip> mAudioTrackClips = new java.util.ArrayList();

    public java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrackClip> getAudioTrackClips() {
        return this.mAudioTrackClips;
    }
}
