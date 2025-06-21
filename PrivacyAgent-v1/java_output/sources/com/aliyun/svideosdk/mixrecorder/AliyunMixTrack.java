package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixTrack {
    private com.aliyun.svideosdk.mixrecorder.AliyunMixStream mAliyunMixStream;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam mMixTrackLayoutParam;
    private int mTrackId;
    private int mMixAudioWeight = 100;
    private boolean outputAudioTrack = false;

    public AliyunMixTrack() {
    }

    @java.lang.Deprecated
    public AliyunMixTrack(int i) {
        this.mTrackId = i;
    }

    public int addStream(com.aliyun.svideosdk.mixrecorder.AliyunMixStream aliyunMixStream) {
        if (aliyunMixStream == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        aliyunMixStream.setTrack(this);
        this.mAliyunMixStream = aliyunMixStream;
        return 0;
    }

    public int getMixAudioWeight() {
        return this.mMixAudioWeight;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixStream getMixStream() {
        return this.mAliyunMixStream;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam getMixTrackLayoutParam() {
        return this.mMixTrackLayoutParam;
    }

    @java.lang.Deprecated
    public int getTrackId() {
        return this.mTrackId;
    }

    public boolean isAudioOutputTrack() {
        return this.outputAudioTrack;
    }

    public void setIsOutputAudioTrack(boolean z) {
        this.outputAudioTrack = z;
    }

    public void setMixAudioWeight(int i) {
        this.mMixAudioWeight = i;
    }

    public void setMixTrackLayoutParam(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
        this.mMixTrackLayoutParam = aliyunMixTrackLayoutParam;
    }

    @java.lang.Deprecated
    public void setTrackId(int i) {
        this.mTrackId = i;
    }
}
