package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public final class jad_an {
    public final boolean jad_an;

    @androidx.annotation.VisibleForTesting
    public final java.util.Map<com.jd.ad.sdk.jad_ju.jad_hu, com.jd.ad.sdk.jad_mx.jad_an.jad_cp> jad_bo;
    public final java.lang.ref.ReferenceQueue<com.jd.ad.sdk.jad_mx.jad_re<?>> jad_cp;
    public com.jd.ad.sdk.jad_mx.jad_re.jad_an jad_dq;

    /* renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an, reason: collision with other inner class name */
    public class ThreadFactoryC0391jad_an implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.jd.ad.sdk.jad_mx.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        public class RunnableC0392jad_an implements java.lang.Runnable {
            public final /* synthetic */ java.lang.Runnable jad_an;

            public RunnableC0392jad_an(com.jd.ad.sdk.jad_mx.jad_an.ThreadFactoryC0391jad_an threadFactoryC0391jad_an, java.lang.Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.os.Process.setThreadPriority(10);
                this.jad_an.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(new com.jd.ad.sdk.jad_mx.jad_an.ThreadFactoryC0391jad_an.RunnableC0392jad_an(this, runnable), "glide-active-resources");
        }
    }

    public class jad_bo implements java.lang.Runnable {
        public jad_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_mx.jad_an jad_anVar = com.jd.ad.sdk.jad_mx.jad_an.this;
            jad_anVar.getClass();
            while (true) {
                try {
                    jad_anVar.jad_an((com.jd.ad.sdk.jad_mx.jad_an.jad_cp) jad_anVar.jad_cp.remove());
                } catch (java.lang.InterruptedException unused) {
                    java.lang.Thread.currentThread().interrupt();
                }
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class jad_cp extends java.lang.ref.WeakReference<com.jd.ad.sdk.jad_mx.jad_re<?>> {
        public final com.jd.ad.sdk.jad_ju.jad_hu jad_an;
        public final boolean jad_bo;

        @androidx.annotation.Nullable
        public com.jd.ad.sdk.jad_mx.jad_xk<?> jad_cp;

        public jad_cp(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_re<?> jad_reVar, @androidx.annotation.NonNull java.lang.ref.ReferenceQueue<? super com.jd.ad.sdk.jad_mx.jad_re<?>> referenceQueue, boolean z) {
            super(jad_reVar, referenceQueue);
            this.jad_an = (com.jd.ad.sdk.jad_ju.jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
            this.jad_cp = (jad_reVar.jad_fs() && z) ? (com.jd.ad.sdk.jad_mx.jad_xk) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_reVar.jad_er()) : null;
            this.jad_bo = jad_reVar.jad_fs();
        }
    }

    public jad_an(boolean z) {
        this(z, java.util.concurrent.Executors.newSingleThreadExecutor(new com.jd.ad.sdk.jad_mx.jad_an.ThreadFactoryC0391jad_an()));
    }

    @androidx.annotation.VisibleForTesting
    public jad_an(boolean z, java.util.concurrent.Executor executor) {
        this.jad_bo = new java.util.HashMap();
        this.jad_cp = new java.lang.ref.ReferenceQueue<>();
        this.jad_an = z;
        executor.execute(new com.jd.ad.sdk.jad_mx.jad_an.jad_bo());
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar, com.jd.ad.sdk.jad_mx.jad_re<?> jad_reVar) {
        com.jd.ad.sdk.jad_mx.jad_an.jad_cp put = this.jad_bo.put(jad_huVar, new com.jd.ad.sdk.jad_mx.jad_an.jad_cp(jad_huVar, jad_reVar, this.jad_cp, this.jad_an));
        if (put != null) {
            put.jad_cp = null;
            put.clear();
        }
    }

    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_an.jad_cp jad_cpVar) {
        com.jd.ad.sdk.jad_mx.jad_xk<?> jad_xkVar;
        synchronized (this) {
            this.jad_bo.remove(jad_cpVar.jad_an);
            if (jad_cpVar.jad_bo && (jad_xkVar = jad_cpVar.jad_cp) != null) {
                this.jad_dq.jad_an(jad_cpVar.jad_an, new com.jd.ad.sdk.jad_mx.jad_re<>(jad_xkVar, true, false, jad_cpVar.jad_an, this.jad_dq));
            }
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_mx.jad_re.jad_an jad_anVar) {
        synchronized (jad_anVar) {
            synchronized (this) {
                this.jad_dq = jad_anVar;
            }
        }
    }
}
