package com.google.android.gms.common.api.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class LifecycleCallback {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    protected final com.google.android.gms.common.api.internal.LifecycleFragment mLifecycleFragment;

    @com.google.android.gms.common.annotation.KeepForSdk
    public LifecycleCallback(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    @androidx.annotation.Keep
    private static com.google.android.gms.common.api.internal.LifecycleFragment getChimeraLifecycleFragmentImpl(com.google.android.gms.common.api.internal.LifecycleActivity lifecycleActivity) {
        throw new java.lang.IllegalStateException("Method not available in SDK.");
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.internal.LifecycleFragment getFragment(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
        return getFragment(new com.google.android.gms.common.api.internal.LifecycleActivity(activity));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.internal.LifecycleFragment getFragment(@androidx.annotation.RecentlyNonNull android.content.ContextWrapper contextWrapper) {
        throw new java.lang.UnsupportedOperationException();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.internal.LifecycleFragment getFragment(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.isSupport()) {
            return com.google.android.gms.common.api.internal.zzc.zza(lifecycleActivity.asFragmentActivity());
        }
        if (lifecycleActivity.zza()) {
            return com.google.android.gms.common.api.internal.zzb.zza(lifecycleActivity.asActivity());
        }
        throw new java.lang.IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void dump(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.io.FileDescriptor fileDescriptor, @androidx.annotation.RecentlyNonNull java.io.PrintWriter printWriter, @androidx.annotation.RecentlyNonNull java.lang.String[] strArr) {
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.app.Activity getActivity() {
        return this.mLifecycleFragment.getLifecycleActivity();
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onActivityResult(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.RecentlyNonNull android.content.Intent intent) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onDestroy() {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onResume() {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onSaveInstanceState(@androidx.annotation.RecentlyNonNull android.os.Bundle bundle) {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onStart() {
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.MainThread
    public void onStop() {
    }
}
