package com.google.android.gms.common.api.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class LifecycleActivity {
    public final java.lang.Object a;

    public LifecycleActivity(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
        this.a = com.google.android.gms.common.internal.Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public LifecycleActivity(@androidx.annotation.RecentlyNonNull android.content.ContextWrapper contextWrapper) {
        throw new java.lang.UnsupportedOperationException();
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.app.Activity asActivity() {
        return (android.app.Activity) this.a;
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public androidx.fragment.app.FragmentActivity asFragmentActivity() {
        return (androidx.fragment.app.FragmentActivity) this.a;
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.Object asObject() {
        return this.a;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isSupport() {
        return this.a instanceof androidx.fragment.app.FragmentActivity;
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean zza() {
        return this.a instanceof android.app.Activity;
    }
}
