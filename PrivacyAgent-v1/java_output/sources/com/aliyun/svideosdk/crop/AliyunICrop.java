package com.aliyun.svideosdk.crop;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunICrop {
    void cancel();

    void dispose();

    long getVideoDuration(java.lang.String str) throws java.lang.Exception;

    void setCropCallback(com.aliyun.svideosdk.crop.CropCallback cropCallback);

    int setCropParam(com.aliyun.svideosdk.crop.CropParam cropParam);

    void setUseHW(boolean z);

    int startCrop();

    int startCropAudio(java.lang.String str, java.lang.String str2, long j, long j2);

    int startCropAudio(java.lang.String str, java.lang.String str2, long j, long j2, java.util.concurrent.TimeUnit timeUnit);

    java.lang.String version();
}
