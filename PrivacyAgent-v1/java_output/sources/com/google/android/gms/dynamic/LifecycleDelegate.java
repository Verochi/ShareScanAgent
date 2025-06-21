package com.google.android.gms.dynamic;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public interface LifecycleDelegate {
    @com.google.android.gms.common.annotation.KeepForSdk
    void onCreate(@androidx.annotation.RecentlyNonNull android.os.Bundle bundle);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    android.view.View onCreateView(@androidx.annotation.RecentlyNonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.RecentlyNonNull android.view.ViewGroup viewGroup, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle);

    @com.google.android.gms.common.annotation.KeepForSdk
    void onDestroy();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onDestroyView();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onInflate(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle2);

    @com.google.android.gms.common.annotation.KeepForSdk
    void onLowMemory();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onPause();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onResume();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onSaveInstanceState(@androidx.annotation.RecentlyNonNull android.os.Bundle bundle);

    @com.google.android.gms.common.annotation.KeepForSdk
    void onStart();

    @com.google.android.gms.common.annotation.KeepForSdk
    void onStop();
}
