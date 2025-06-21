package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class MediaTrack extends com.aliyun.svideosdk.common.struct.project.Track {

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    private float mDuration;

    public float getDuration() {
        return this.mDuration;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }
}
