package com.google.android.gms.common.util.concurrent;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class NumberedThreadFactory implements java.util.concurrent.ThreadFactory {
    public final java.lang.String n;
    public final int t;
    public final java.util.concurrent.atomic.AtomicInteger u;
    public final java.util.concurrent.ThreadFactory v;

    @com.google.android.gms.common.annotation.KeepForSdk
    public NumberedThreadFactory(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(str, 0);
    }

    public NumberedThreadFactory(java.lang.String str, int i) {
        this.u = new java.util.concurrent.atomic.AtomicInteger();
        this.v = java.util.concurrent.Executors.defaultThreadFactory();
        this.n = (java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(str, "Name must not be null");
        this.t = 0;
    }

    @Override // java.util.concurrent.ThreadFactory
    @androidx.annotation.RecentlyNonNull
    public java.lang.Thread newThread(@androidx.annotation.RecentlyNonNull java.lang.Runnable runnable) {
        java.lang.Thread newThread = this.v.newThread(new com.google.android.gms.common.util.concurrent.zza(runnable, 0));
        java.lang.String str = this.n;
        int andIncrement = this.u.getAndIncrement();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
