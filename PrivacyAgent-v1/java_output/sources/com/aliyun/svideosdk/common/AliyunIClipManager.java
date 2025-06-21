package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIClipManager {
    int addMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip);

    int addMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip);

    int deleteLastMediaClip();

    int deleteMediaClip(int i);

    void deleteMediaClip(com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip);

    java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> getAllClips();

    com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaClip(int i);

    int getMediaClipCount();

    void swap(int i, int i2);

    void updateAllClips(java.util.List<com.aliyun.svideosdk.common.struct.common.AliyunClip> list);

    int updateMediaClip(int i, com.aliyun.svideosdk.common.struct.common.AliyunClip aliyunClip);
}
