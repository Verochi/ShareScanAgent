package com.google.android.gms.common.util.concurrent;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class HandlerExecutor implements java.util.concurrent.Executor {
    public final android.os.Handler n;

    @com.google.android.gms.common.annotation.KeepForSdk
    public HandlerExecutor(@androidx.annotation.RecentlyNonNull android.os.Looper looper) {
        this.n = new com.google.android.gms.internal.common.zzi(looper);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@androidx.annotation.RecentlyNonNull java.lang.Runnable runnable) {
        this.n.post(runnable);
    }
}
