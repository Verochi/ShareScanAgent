package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzq<TResult> {
    public final java.lang.Object a = new java.lang.Object();

    @javax.annotation.concurrent.GuardedBy("mLock")
    public java.util.Queue<com.google.android.gms.tasks.zzr<TResult>> b;

    @javax.annotation.concurrent.GuardedBy("mLock")
    public boolean c;

    public final void a(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<TResult> task) {
        com.google.android.gms.tasks.zzr<TResult> poll;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(task);
                }
            }
        }
    }

    public final void b(@androidx.annotation.NonNull com.google.android.gms.tasks.zzr<TResult> zzrVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new java.util.ArrayDeque();
            }
            this.b.add(zzrVar);
        }
    }
}
