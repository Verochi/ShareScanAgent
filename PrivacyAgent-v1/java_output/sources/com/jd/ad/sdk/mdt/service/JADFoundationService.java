package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADFoundationService {
    @androidx.annotation.Nullable
    android.app.Application getApplication();

    boolean isNetAvailable();

    void loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener);

    void preloadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener onImageLoadListener);
}
