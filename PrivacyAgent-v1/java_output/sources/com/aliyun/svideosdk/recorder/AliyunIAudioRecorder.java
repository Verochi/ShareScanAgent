package com.aliyun.svideosdk.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIAudioRecorder {
    com.aliyun.svideosdk.common.struct.common.AliyunAudioClip[] allClips();

    com.aliyun.svideosdk.common.struct.common.AliyunAudioClip breakTag();

    int connectClip();

    int deleteClip(com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip);

    long getRecordDuration();

    int init(android.content.Context context);

    int release();

    void setOnAudioRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback onAudioRecordCallback);

    int setOutputPath(java.lang.String str);

    int startRecord();

    com.aliyun.svideosdk.common.struct.common.AliyunAudioClip stopRecord();
}
