package com.aliyun.svideosdk.multirecorder.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMultiRecorderCreator {
    public static com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder getVideoRecorderInstance(android.content.Context context, com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        return new com.aliyun.svideosdk.multirecorder.impl.a(context, aliyunVideoRecorderConfig);
    }
}
