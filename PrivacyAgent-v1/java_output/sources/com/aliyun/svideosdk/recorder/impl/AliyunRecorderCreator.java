package com.aliyun.svideosdk.recorder.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecorderCreator {
    public static com.aliyun.svideosdk.recorder.AliyunIAudioRecorder getAudioRecorderInstance() {
        return new com.aliyun.svideosdk.recorder.impl.b();
    }

    public static com.aliyun.svideosdk.recorder.AliyunIRecorder getRecorderInstance(android.content.Context context) {
        return new com.aliyun.svideosdk.recorder.impl.g(context, com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1);
    }
}
