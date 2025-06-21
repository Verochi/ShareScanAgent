package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecordBaseSource extends com.aliyun.svideosdk.common.AliyunObject {
    public native long nativeCreateAVWithFile(java.lang.String str, long j, long j2, boolean z);

    public native long nativeCreateAudioWithFile(java.lang.String str, long j, long j2, boolean z);

    public native long nativeCreateAudioWithInfo(int i, int i2);

    public native long nativeCreateVideoWithFile(java.lang.String str, long j, long j2, boolean z);

    public native long nativeCreateVideoWithInfo(int i, int i2);

    public native void nativeDestroy(long j);

    public native long nativeGetStickerManager(long j);

    public void nativeInitError() {
    }

    public native void nativeSetAECFarSource(long j, long j2);

    public native void nativeSetAnimationFilterInfo(long j, java.lang.String str, java.lang.String str2);

    public native void nativeSetBeautyLevel(long j, int i);

    public native void nativeSetCaptureSurface(long j, android.graphics.SurfaceTexture surfaceTexture, int i, int i2, int i3);

    public native void nativeSetDenoiseWeight(long j, float f);

    public native void nativeSetDisplay(long j, android.view.Surface surface);

    public native void nativeSetEffect(long j, int i, float f);

    public native void nativeSetFadeIn(long j, int i, long j2);

    public native void nativeSetFadeOut(long j, int i, long j2);

    public native void nativeSetFilterInfo(long j, java.lang.String str);

    public native void nativeSetIsFixedTempo(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetLayoutInfo(long j, float f, float f2, float f3, float f4, int i, int i2, int i3, int i4);

    public native void nativeSetMirrorInfo(long j, int i);

    public native void nativeSetNeedOutput(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetNeedRender(long j, boolean z, boolean z2, boolean z3);

    public native void nativeSetPureColorBorder(long j, float f, int i, float f2);

    public native void nativeSetVolume(long j, float f);

    public void release() {
        nativeDestroy(getNativeHandle());
        releaseNativeHandle();
    }

    public void setFixedTempo(boolean z, boolean z2, boolean z3) {
        nativeSetIsFixedTempo(getNativeHandle(), z, z2, z3);
    }
}
