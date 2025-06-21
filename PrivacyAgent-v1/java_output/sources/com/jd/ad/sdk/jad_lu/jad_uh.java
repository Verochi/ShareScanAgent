package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_uh<T> {
    public static java.util.concurrent.Executor jad_er = java.util.concurrent.Executors.newCachedThreadPool();
    public final java.util.Set<com.jd.ad.sdk.jad_lu.jad_ob<T>> jad_an = new java.util.LinkedHashSet(1);
    public final java.util.Set<com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable>> jad_bo = new java.util.LinkedHashSet(1);
    public final android.os.Handler jad_cp = new android.os.Handler(android.os.Looper.getMainLooper());

    @androidx.annotation.Nullable
    public volatile com.jd.ad.sdk.jad_lu.jad_sf<T> jad_dq = null;

    public class jad_an extends java.util.concurrent.FutureTask<com.jd.ad.sdk.jad_lu.jad_sf<T>> {
        public jad_an(java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                com.jd.ad.sdk.jad_lu.jad_uh.this.jad_an(get());
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e) {
                com.jd.ad.sdk.jad_lu.jad_uh.this.jad_an(new com.jd.ad.sdk.jad_lu.jad_sf<>(e));
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public jad_uh(java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<T>> callable, boolean z) {
        if (!z) {
            jad_er.execute(new com.jd.ad.sdk.jad_lu.jad_uh.jad_an(callable));
            return;
        }
        try {
            jad_an(callable.call());
        } catch (java.lang.Throwable th) {
            jad_an(new com.jd.ad.sdk.jad_lu.jad_sf<>(th));
        }
    }

    public synchronized com.jd.ad.sdk.jad_lu.jad_uh<T> jad_an(com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> jad_obVar) {
        if (this.jad_dq != null && this.jad_dq.jad_bo != null) {
            jad_obVar.jad_an(this.jad_dq.jad_bo);
        }
        this.jad_bo.add(jad_obVar);
        return this;
    }

    public final void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_lu.jad_sf<T> jad_sfVar) {
        if (this.jad_dq != null) {
            throw new java.lang.IllegalStateException("A task may only be set once.");
        }
        this.jad_dq = jad_sfVar;
        this.jad_cp.post(new com.jd.ad.sdk.jad_lu.jad_tg(this));
    }

    public synchronized com.jd.ad.sdk.jad_lu.jad_uh<T> jad_bo(com.jd.ad.sdk.jad_lu.jad_ob<T> jad_obVar) {
        if (this.jad_dq != null && this.jad_dq.jad_an != null) {
            jad_obVar.jad_an(this.jad_dq.jad_an);
        }
        this.jad_an.add(jad_obVar);
        return this;
    }
}
