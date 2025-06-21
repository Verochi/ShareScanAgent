package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIAugmentationController {
    int apply();

    float getBrightness();

    float getContrast();

    float getSaturation();

    float getSharpness();

    float getVignette();

    void resetDefault();

    com.aliyun.svideosdk.editor.AliyunIAugmentationController setBrightness(float f);

    com.aliyun.svideosdk.editor.AliyunIAugmentationController setContrast(float f);

    com.aliyun.svideosdk.editor.AliyunIAugmentationController setSaturation(float f);

    com.aliyun.svideosdk.editor.AliyunIAugmentationController setSharpness(float f);

    com.aliyun.svideosdk.editor.AliyunIAugmentationController setVignette(float f);
}
