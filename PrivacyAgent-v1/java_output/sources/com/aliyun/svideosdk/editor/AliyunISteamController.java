package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunISteamController {
    int apply();

    com.aliyun.svideosdk.editor.AliyunIAnimationController getAnimationController();

    com.aliyun.svideosdk.editor.AliyunIAudioController getAudioController();

    com.aliyun.svideosdk.editor.AliyunIAugmentationController getAugmentationController();

    long getClipDurationInMillis();

    long getClipStartTimeInMillis();

    int getHeight();

    com.aliyun.svideosdk.editor.AliyunILayoutController getLayoutController();

    java.lang.String getPath();

    int getStreamId();

    long getTimeLineEndTimeInMillis();

    long getTimeLineStartTimeInMillis();

    int getWidth();

    com.aliyun.svideosdk.editor.AliyunISteamController setBorderColor(int i);

    com.aliyun.svideosdk.editor.AliyunISteamController setBorderCornerRadius(float f);

    com.aliyun.svideosdk.editor.AliyunISteamController setBorderWidth(float f);

    com.aliyun.svideosdk.editor.AliyunISteamController setClipEndTime(long j, java.util.concurrent.TimeUnit timeUnit);

    com.aliyun.svideosdk.editor.AliyunISteamController setClipStartTime(long j, java.util.concurrent.TimeUnit timeUnit);

    com.aliyun.svideosdk.editor.AliyunISteamController setHorizontalFlip(boolean z);

    com.aliyun.svideosdk.editor.AliyunISteamController setTimelineStartTime(long j, java.util.concurrent.TimeUnit timeUnit);
}
