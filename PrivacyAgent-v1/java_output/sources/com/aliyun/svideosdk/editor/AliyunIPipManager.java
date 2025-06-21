package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIPipManager {
    com.aliyun.svideosdk.editor.AliyunIPipController createNewPip(java.lang.String str);

    com.aliyun.svideosdk.editor.AliyunIPipController createPipInTrack(java.lang.String str, com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack);

    com.aliyun.svideosdk.editor.AliyunIPipController findTopPipController(long j, android.graphics.PointF pointF);

    java.util.List<com.aliyun.svideosdk.editor.AliyunIPipController> getAllPip();

    java.util.List<com.aliyun.svideosdk.editor.AliyunIPipTrack> getPipTracks();

    boolean movePipIntoTrack(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController, com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack, long j);

    boolean removePip(com.aliyun.svideosdk.editor.AliyunIPipController aliyunIPipController);
}
