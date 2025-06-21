package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADInitService {
    void createDefaultAdInstance(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot);

    @androidx.annotation.NonNull
    java.lang.String getAdUrl(@androidx.annotation.NonNull java.lang.String str);

    int getDs(@androidx.annotation.NonNull java.lang.String str);

    float getFeedShakeAngleValue();

    float getFeedShakeSensitivityValue();

    float getFeedShakeTimeValue();

    int getJumpToH5DelayTime();

    int getNeedCheckMediaClickH5();

    int getOpenReflectOaid();

    int getR(@androidx.annotation.NonNull java.lang.String str);

    int getSen(@androidx.annotation.NonNull java.lang.String str);

    float getShakeAngleValue();

    float getShakeSensitivityValue();

    float getShakeTimeValue();

    float getSwipeAngle();

    float getSwipeLength();

    boolean isForbidModelToH5();
}
