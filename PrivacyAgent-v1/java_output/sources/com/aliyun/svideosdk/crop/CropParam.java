package com.aliyun.svideosdk.crop;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class CropParam {
    private android.graphics.Rect cropRect;
    private long endTime;
    private java.lang.String mInputPath;
    private int mVideoBitrate;
    private int outputHeight;
    private java.lang.String outputPath;
    private int outputWidth;
    private long startTime;
    private int frameRate = 25;
    private int gop = 5;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality quality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mScaleMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    private com.aliyun.svideosdk.common.struct.common.MediaType mMediaType = com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE;
    private int mFillColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private boolean isUseGPU = false;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private int mCrf = 23;

    public int getCrf() {
        return this.mCrf;
    }

    public android.graphics.Rect getCropRect() {
        return this.cropRect;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getEndTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.endTime, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getGop() {
        return this.gop;
    }

    public java.lang.String getInputPath() {
        return this.mInputPath;
    }

    public com.aliyun.svideosdk.common.struct.common.MediaType getMediaType() {
        return this.mMediaType;
    }

    public int getOutputHeight() {
        return this.outputHeight;
    }

    public java.lang.String getOutputPath() {
        return this.outputPath;
    }

    public int getOutputWidth() {
        return this.outputWidth;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getQuality() {
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = this.quality;
        return videoQuality == null ? com.aliyun.svideosdk.common.struct.common.VideoQuality.HD : videoQuality;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getScaleMode() {
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = this.mScaleMode;
        return videoDisplayMode == null ? com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL : videoDisplayMode;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public java.lang.String getVideoPath() {
        return this.mInputPath;
    }

    public int getvideobitrate() {
        return this.mVideoBitrate;
    }

    @java.lang.Deprecated
    public boolean isUseGPU() {
        return this.isUseGPU;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setCropRect(android.graphics.Rect rect) {
        this.cropRect = rect;
    }

    public void setEndTime(long j) {
        setEndTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setEndTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.endTime = timeUnit.toMicros(j);
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
    }

    public void setFrameRate(int i) {
        this.frameRate = i;
    }

    public void setGop(int i) {
        this.gop = i;
    }

    public void setInputPath(java.lang.String str) {
        this.mInputPath = str;
    }

    public void setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType mediaType) {
        this.mMediaType = mediaType;
    }

    public void setOutputHeight(int i) {
        this.outputHeight = i;
    }

    public void setOutputPath(java.lang.String str) {
        this.outputPath = str;
    }

    public void setOutputWidth(int i) {
        this.outputWidth = i;
    }

    public void setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.quality = videoQuality;
    }

    public void setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setStartTime(long j) {
        setStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.startTime = timeUnit.toMicros(j);
    }

    @java.lang.Deprecated
    public void setUseGPU(boolean z) {
        this.isUseGPU = z;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoPath(java.lang.String str) {
        this.mInputPath = str;
    }
}
