package com.google.android.gms.common.api.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public interface LifecycleFragment {
    @com.google.android.gms.common.annotation.KeepForSdk
    void addCallback(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback);

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    <T extends com.google.android.gms.common.api.internal.LifecycleCallback> T getCallbackOrNull(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Class<T> cls);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    android.app.Activity getLifecycleActivity();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    boolean isCreated();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    boolean isStarted();

    @com.google.android.gms.common.annotation.KeepForSdk
    void startActivityForResult(@androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull int i);
}
