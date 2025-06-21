package com.aliyun.svideosdk.common.struct.encoder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EncoderInfo {
    public long avgUseTime;
    public long bitrateDiff;
    public long duration;
    public long encoderType;
    public long fps;
    public long height;
    public long keyframeDelay;
    public long maxCacheFrame;
    public long width;

    public java.lang.String toString() {
        return "EncoderInfo{encoderType=" + this.encoderType + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", fps=" + this.fps + ", bitrateDiff=" + this.bitrateDiff + ", keyframeDelay=" + this.keyframeDelay + ", avgUseTime=" + this.avgUseTime + ", maxCacheFrame=" + this.maxCacheFrame + '}';
    }
}
