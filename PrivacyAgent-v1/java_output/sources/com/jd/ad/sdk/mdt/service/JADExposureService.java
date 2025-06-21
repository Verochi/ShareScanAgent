package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADExposureService {
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<android.view.View>> getNativeExposureFeedShakeViewMap();

    void registerExposureView(@androidx.annotation.NonNull java.lang.String str);

    void registerNativeExposureFeedShakeView(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.view.View view);

    void setViewExposureCallback(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener jADExposureListener);

    void setViewForceExposure(@androidx.annotation.NonNull java.lang.String str);

    void unregisterExposureView(@androidx.annotation.NonNull java.lang.String str);

    void unregisterNativeExposureFeedShakeView(@androidx.annotation.NonNull java.lang.String str);
}
