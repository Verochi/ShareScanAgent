package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunAugmentation extends com.aliyun.svideosdk.common.AliyunObject {
    private native float nativeGetAugmentationBrightness(long j);

    private native float nativeGetAugmentationContrast(long j);

    private native float nativeGetAugmentationSaturation(long j);

    private native float nativeGetAugmentationSharpness(long j);

    private native float nativeGetAugmentationVignette(long j);

    private native void nativeSetAugmentationBrightness(long j, float f);

    private native void nativeSetAugmentationContrast(long j, float f);

    private native void nativeSetAugmentationSaturation(long j, float f);

    private native void nativeSetAugmentationSharpness(long j, float f);

    private native void nativeSetAugmentationVignette(long j, float f);

    public float getBrightness() {
        return nativeGetAugmentationBrightness(this.mNativeHandle);
    }

    public float getContrast() {
        return nativeGetAugmentationContrast(this.mNativeHandle);
    }

    public float getSaturation() {
        return nativeGetAugmentationSaturation(this.mNativeHandle);
    }

    public float getSharpness() {
        return nativeGetAugmentationSharpness(this.mNativeHandle);
    }

    public float getVignette() {
        return nativeGetAugmentationVignette(this.mNativeHandle);
    }

    public void setBrightness(float f) {
        nativeSetAugmentationBrightness(this.mNativeHandle, f);
    }

    public void setContrast(float f) {
        nativeSetAugmentationContrast(this.mNativeHandle, f);
    }

    public void setSaturation(float f) {
        nativeSetAugmentationSaturation(this.mNativeHandle, f);
    }

    public void setSharpness(float f) {
        nativeSetAugmentationSharpness(this.mNativeHandle, f);
    }

    public void setVignette(float f) {
        nativeSetAugmentationVignette(this.mNativeHandle, f);
    }
}
