package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIClipConstructor extends com.aliyun.svideosdk.common.AliyunIClipManager {
    @java.lang.Deprecated
    int addImage(java.lang.String str, long j, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode);

    @java.lang.Deprecated
    int addVideo(java.lang.String str, long j, long j2, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode);

    @java.lang.Deprecated
    int addVideo(java.lang.String str, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode);

    @java.lang.Deprecated
    int deleteMediaClip();

    @java.lang.Deprecated
    com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaPart(int i);

    @java.lang.Deprecated
    int getMediaPartCount();

    void removeMedia(int i);

    void removeVideo(java.lang.String str) throws java.lang.IllegalAccessException;
}
