package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
public final class TaskExecutors {
    public static final java.util.concurrent.Executor MAIN_THREAD = new com.google.android.gms.tasks.TaskExecutors.zza();
    public static final java.util.concurrent.Executor a = new com.google.android.gms.tasks.zzt();

    public static final class zza implements java.util.concurrent.Executor {
        public final android.os.Handler n = new com.google.android.gms.internal.tasks.zzb(android.os.Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            this.n.post(runnable);
        }
    }
}
