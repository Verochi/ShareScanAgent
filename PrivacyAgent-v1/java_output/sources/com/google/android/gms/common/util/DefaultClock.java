package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class DefaultClock implements com.google.android.gms.common.util.Clock {
    public static final com.google.android.gms.common.util.DefaultClock a = new com.google.android.gms.common.util.DefaultClock();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.util.Clock getInstance() {
        return a;
    }

    @Override // com.google.android.gms.common.util.Clock
    @androidx.annotation.RecentlyNonNull
    public long currentThreadTimeMillis() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    @androidx.annotation.RecentlyNonNull
    public long currentTimeMillis() {
        return java.lang.System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    @androidx.annotation.RecentlyNonNull
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    @androidx.annotation.RecentlyNonNull
    public long nanoTime() {
        return java.lang.System.nanoTime();
    }
}
