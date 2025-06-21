package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecordAudioSource extends com.aliyun.svideosdk.common.AliyunRecordBaseSource {
    private AliyunRecordAudioSource() {
    }

    public static com.aliyun.svideosdk.common.AliyunRecordAudioSource createAudioWithFile(java.lang.String str, long j, long j2) {
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = new com.aliyun.svideosdk.common.AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithFile(str, j, j2, false));
        return aliyunRecordAudioSource;
    }

    public static com.aliyun.svideosdk.common.AliyunRecordAudioSource createAudioWithFile(java.lang.String str, boolean z) {
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = new com.aliyun.svideosdk.common.AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithFile(str, 0L, 0L, z));
        return aliyunRecordAudioSource;
    }

    public static com.aliyun.svideosdk.common.AliyunRecordAudioSource createAudioWithInfo(int i, int i2) {
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = new com.aliyun.svideosdk.common.AliyunRecordAudioSource();
        aliyunRecordAudioSource.setNativeHandle(aliyunRecordAudioSource.nativeCreateAudioWithInfo(i, i2));
        return aliyunRecordAudioSource;
    }

    public void setAECFarSource(com.aliyun.svideosdk.common.AliyunRecordBaseSource aliyunRecordBaseSource) {
        nativeSetAECFarSource(getNativeHandle(), aliyunRecordBaseSource != null ? aliyunRecordBaseSource.getNativeHandle() : -1L);
    }

    public void setAudioNeedOutput(boolean z) {
        nativeSetNeedOutput(getNativeHandle(), z, true, false);
    }

    public void setAudioNeedRender(boolean z) {
        nativeSetNeedRender(getNativeHandle(), z, true, false);
    }

    public void setDenoiseWeight(float f) {
        nativeSetDenoiseWeight(getNativeHandle(), f);
    }

    public void setEffect(int i, float f) {
        nativeSetEffect(getNativeHandle(), i, f);
    }

    public void setFadeIn(com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade aliyunAudioFade) {
        nativeSetFadeIn(getNativeHandle(), aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setFadeOut(com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade aliyunAudioFade) {
        nativeSetFadeOut(getNativeHandle(), aliyunAudioFade.shapeType, aliyunAudioFade.duration);
    }

    public void setVolume(float f) {
        nativeSetVolume(getNativeHandle(), f);
    }
}
