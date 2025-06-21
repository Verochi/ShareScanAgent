package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecordAVSource extends com.aliyun.svideosdk.common.AliyunRecordVideoSource {
    private AliyunRecordAVSource() {
    }

    public static com.aliyun.svideosdk.common.AliyunRecordAVSource createAVWithFile(java.lang.String str, long j, long j2) {
        com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource = new com.aliyun.svideosdk.common.AliyunRecordAVSource();
        aliyunRecordAVSource.setNativeHandle(aliyunRecordAVSource.nativeCreateAVWithFile(str, j, j2, false));
        return aliyunRecordAVSource;
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
