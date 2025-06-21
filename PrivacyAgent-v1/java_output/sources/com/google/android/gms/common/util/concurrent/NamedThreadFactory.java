package com.google.android.gms.common.util.concurrent;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class NamedThreadFactory implements java.util.concurrent.ThreadFactory {
    public final java.lang.String n;
    public final int t;
    public final java.util.concurrent.ThreadFactory u;

    @com.google.android.gms.common.annotation.KeepForSdk
    public NamedThreadFactory(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(str, 0);
    }

    public NamedThreadFactory(java.lang.String str, int i) {
        this.u = java.util.concurrent.Executors.defaultThreadFactory();
        this.n = (java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(str, "Name must not be null");
        this.t = 0;
    }

    @Override // java.util.concurrent.ThreadFactory
    @androidx.annotation.RecentlyNonNull
    public java.lang.Thread newThread(@androidx.annotation.RecentlyNonNull java.lang.Runnable runnable) {
        java.lang.Thread newThread = this.u.newThread(new com.google.android.gms.common.util.concurrent.zza(runnable, 0));
        newThread.setName(this.n);
        return newThread;
    }
}
