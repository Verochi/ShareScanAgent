package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIAudioController {
    int apply();

    com.aliyun.svideosdk.editor.AliyunIAudioController denoise(int i);

    int getVolume();

    com.aliyun.svideosdk.editor.AliyunIAudioController removeAudioFadeIn();

    com.aliyun.svideosdk.editor.AliyunIAudioController removeAudioFadeOut();

    com.aliyun.svideosdk.editor.AliyunIAudioController setAudioEffect(com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, float f);

    com.aliyun.svideosdk.editor.AliyunIAudioController setAudioFadeIn(com.aliyun.svideosdk.editor.ShapeType shapeType, long j);

    com.aliyun.svideosdk.editor.AliyunIAudioController setAudioFadeOut(com.aliyun.svideosdk.editor.ShapeType shapeType, long j);

    com.aliyun.svideosdk.editor.AliyunIAudioController setVolume(int i);
}
