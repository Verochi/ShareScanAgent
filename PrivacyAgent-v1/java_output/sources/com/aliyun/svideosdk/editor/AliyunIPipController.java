package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIPipController extends com.aliyun.svideosdk.editor.AliyunISteamController {
    com.aliyun.svideosdk.editor.AliyunIPipTrack getOwnerTrack();

    android.graphics.RectF getPipRectFInCurrentScreen();

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setBorderColor(int i);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setBorderCornerRadius(float f);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setBorderWidth(float f);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setClipEndTime(long j, java.util.concurrent.TimeUnit timeUnit);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setClipStartTime(long j, java.util.concurrent.TimeUnit timeUnit);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setHorizontalFlip(boolean z);

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    com.aliyun.svideosdk.editor.AliyunIPipController setTimelineStartTime(long j, java.util.concurrent.TimeUnit timeUnit);
}
