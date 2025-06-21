package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Timeline {

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    private float mDuration;

    @com.google.gson.annotations.SerializedName("VideoTracks")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrack> mVideoTracks = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("AudioTracks")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrack> mAudioTracks = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("PasterTracks")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> mPasterTracks = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("GlobalTracks")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.GlobalTrack> mGlobalTracks = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("EffectTracks")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.EffectTrack> mEffectTracks = new java.util.ArrayList();

    public java.util.List<com.aliyun.svideosdk.common.struct.project.AudioTrack> getAudioTracks() {
        return this.mAudioTracks;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.EffectTrack> getEffectTracks() {
        return this.mEffectTracks;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.GlobalTrack> getGlobalTracks() {
        return this.mGlobalTracks;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> getPasterTracks() {
        return this.mPasterTracks;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrack> getPipTracks() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.mVideoTracks.size() > 1) {
            java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrack> list = this.mVideoTracks;
            arrayList.addAll(list.subList(1, list.size()));
        }
        return arrayList;
    }

    public com.aliyun.svideosdk.common.struct.project.VideoTrack getPrimaryTrack() {
        if (this.mVideoTracks.isEmpty()) {
            this.mVideoTracks.add(new com.aliyun.svideosdk.common.struct.project.VideoTrack());
        }
        return this.mVideoTracks.get(0);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrack> getVideoTracks() {
        return this.mVideoTracks;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }
}
