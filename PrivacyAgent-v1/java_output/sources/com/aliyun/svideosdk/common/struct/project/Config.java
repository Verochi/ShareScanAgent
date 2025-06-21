package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Config {

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_BITRATE)
    private int mBitrate;

    @com.google.gson.annotations.SerializedName("DisplayMode")
    private int mDisplayMode;

    @com.google.gson.annotations.SerializedName("FPS")
    private int mFps;

    @com.google.gson.annotations.SerializedName("Mute")
    private boolean mMute;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_HEIGHT)
    private int mOutputHeight;

    @com.google.gson.annotations.SerializedName(com.aliyun.svideo.editor.bean.AlivcEditInputParam.INTENT_KEY_OUTPUT_WIDTH)
    private int mOutputWidth;

    @com.google.gson.annotations.SerializedName("VideoCodec")
    private int mVideoCodec;

    @com.google.gson.annotations.SerializedName("GOP")
    private int mGop = -1;

    @com.google.gson.annotations.SerializedName("VideoQuality")
    private int mVideoQuality = -1;

    @com.google.gson.annotations.SerializedName("CRF")
    private int mCrf = 23;

    @com.google.gson.annotations.SerializedName("Scale")
    private float mScale = 1.0f;

    @com.google.gson.annotations.SerializedName("Volume")
    private int mVolume = 50;

    @com.google.gson.annotations.SerializedName("BackgroundColor")
    private int mBackgroundColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getVolume() {
        return this.mVolume;
    }

    public boolean isMute() {
        return this.mMute;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }

    public void setFps(int i) {
        this.mFps = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setMute(boolean z) {
        this.mMute = z;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void setVideoCodec(int i) {
        this.mVideoCodec = i;
    }

    public void setVideoQuality(int i) {
        this.mVideoQuality = i;
    }

    public void setVolume(int i) {
        this.mVolume = i;
    }
}
