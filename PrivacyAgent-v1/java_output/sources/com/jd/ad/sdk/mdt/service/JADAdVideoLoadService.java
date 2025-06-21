package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADAdVideoLoadService {
    void loadAdVideo(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull java.lang.String str3, @androidx.annotation.NonNull com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener);

    void registerAd(java.lang.String str);

    void unregisterAd(@androidx.annotation.NonNull java.lang.String str);
}
