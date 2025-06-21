package com.aliyun.svideosdk.common.struct.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class MediaInfo {
    protected int mBitrate;
    private int videoHeight;
    private int videoWidth;
    private int fps = 30;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private int mCrf = com.aliyun.svideosdk.common.b.a.c;
    private int mEncoderFps = 30;
    protected int mGop = 250;
    protected com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;

    public int getCrf() {
        return this.mCrf;
    }

    public int getEncoderFps() {
        return this.mEncoderFps;
    }

    public int getFps() {
        return this.fps;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getVideoBitrate() {
        return this.mBitrate;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int setCrf(int i) {
        int i2 = com.aliyun.svideosdk.common.b.a.a;
        if (i >= i2 && i <= (i2 = com.aliyun.svideosdk.common.b.a.b)) {
            i2 = i;
        }
        this.mCrf = i2;
        if (i >= com.aliyun.svideosdk.common.b.a.a && i <= com.aliyun.svideosdk.common.b.a.b) {
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid crf = ");
        sb.append(i);
        sb.append(", crf must be [");
        sb.append(com.aliyun.svideosdk.common.b.a.a);
        sb.append(", ");
        sb.append(com.aliyun.svideosdk.common.b.a.b);
        sb.append("]");
        return -20003002;
    }

    public int setEncoderFps(int i) {
        if (i >= 1 && i <= 120) {
            this.mEncoderFps = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid encoderFps value ");
        sb.append(i);
        sb.append(", encoderFps has must be between 0 and 120!");
        return -20003002;
    }

    public int setFps(int i) {
        if (i >= 1 && i <= 120) {
            this.fps = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid fps value ");
        sb.append(i);
        sb.append(", fps has must be between ");
        sb.append(1);
        sb.append(" and ");
        sb.append(120);
        sb.append("!");
        return -20003002;
    }

    public int setGop(int i) {
        if (i >= 0 && i <= 9000) {
            this.mGop = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid gop value ");
        sb.append(i);
        sb.append(", gop has must be between 0 and 9000!");
        return -20003002;
    }

    public int setVideoBitrate(int i) {
        if (i >= 200 && i <= 20000) {
            this.mBitrate = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid bitrate value ");
        sb.append(i);
        sb.append(", gop has must be between 200 and 20000!");
        return -20003002;
    }

    public void setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public int setVideoHeight(int i) {
        if (i > 0) {
            this.videoHeight = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid videoHeight ");
        sb.append(i);
        sb.append(", videoHeight must be grate than 0!");
        return -20003002;
    }

    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }

    public int setVideoWidth(int i) {
        if (i > 0) {
            this.videoWidth = i;
            return 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid videoWidth ");
        sb.append(i);
        sb.append(", videoWidth must be grate than 0!");
        return -20003002;
    }
}
