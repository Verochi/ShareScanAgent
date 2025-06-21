package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunPasterManager {
    com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, long j, long j2);

    com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, long j, long j2, java.util.concurrent.TimeUnit timeUnit);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, long j2);

    com.aliyun.svideosdk.editor.impl.AliyunPasterControllerImage addImage(com.aliyun.svideosdk.common.struct.project.Source source);

    com.aliyun.svideosdk.editor.AliyunPasterController addPaster(com.aliyun.svideosdk.common.struct.project.Source source);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addPaster(java.lang.String str);

    com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2);

    com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2, java.util.concurrent.TimeUnit timeUnit);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(java.lang.String str, long j, long j2);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addSubtitle(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addSubtitle(java.lang.String str, java.lang.String str2);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addSubtitleWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2);

    @java.lang.Deprecated
    com.aliyun.svideosdk.editor.AliyunPasterController addSubtitleWithStartTime(java.lang.String str, java.lang.String str2, long j, long j2);

    com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint(android.graphics.PointF pointF, long j);

    com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint(android.graphics.PointF pointF, long j, java.util.concurrent.TimeUnit timeUnit);

    java.util.List<com.aliyun.svideosdk.editor.AliyunIPasterController> findControllersByType(int i);

    void remove(com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController);

    void setDisplaySize(int i, int i2);

    void setOnPasterRestoreListener(com.aliyun.svideosdk.editor.OnPasterRestored onPasterRestored);
}
