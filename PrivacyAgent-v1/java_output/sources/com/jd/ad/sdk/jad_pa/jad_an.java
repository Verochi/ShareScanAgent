package com.jd.ad.sdk.jad_pa;

/* loaded from: classes23.dex */
public final class jad_an implements java.util.concurrent.ExecutorService {
    public static final long jad_bo = java.util.concurrent.TimeUnit.SECONDS.toMillis(10);
    public static volatile int jad_cp;
    public final java.util.concurrent.ExecutorService jad_an;

    /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an, reason: collision with other inner class name */
    public static final class ThreadFactoryC0399jad_an implements java.util.concurrent.ThreadFactory {

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        public class C0400jad_an extends java.lang.Thread {
            public C0400jad_an(com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an threadFactoryC0399jad_an, java.lang.Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                android.os.Process.setThreadPriority(9);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an.C0400jad_an(this, runnable);
        }
    }

    public static final class jad_bo implements java.util.concurrent.ThreadFactory {
        public final java.util.concurrent.ThreadFactory jad_an;
        public final java.lang.String jad_bo;
        public final com.jd.ad.sdk.jad_pa.jad_an.jad_cp jad_cp;
        public final boolean jad_dq;
        public final java.util.concurrent.atomic.AtomicInteger jad_er = new java.util.concurrent.atomic.AtomicInteger();

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_bo$jad_an, reason: collision with other inner class name */
        public class RunnableC0401jad_an implements java.lang.Runnable {
            public final /* synthetic */ java.lang.Runnable jad_an;

            public RunnableC0401jad_an(java.lang.Runnable runnable) {
                this.jad_an = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.jd.ad.sdk.jad_pa.jad_an.jad_bo.this.jad_dq) {
                    android.os.StrictMode.setThreadPolicy(new android.os.StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.jad_an.run();
                } catch (java.lang.Throwable th) {
                    com.jd.ad.sdk.jad_pa.jad_an.jad_bo.this.jad_cp.jad_an(th);
                }
            }
        }

        public jad_bo(java.util.concurrent.ThreadFactory threadFactory, java.lang.String str, com.jd.ad.sdk.jad_pa.jad_an.jad_cp jad_cpVar, boolean z) {
            this.jad_an = threadFactory;
            this.jad_bo = str;
            this.jad_cp = jad_cpVar;
            this.jad_dq = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            java.lang.Thread newThread = this.jad_an.newThread(new com.jd.ad.sdk.jad_pa.jad_an.jad_bo.RunnableC0401jad_an(runnable));
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("glide-");
            jad_an.append(this.jad_bo);
            jad_an.append("-thread-");
            jad_an.append(this.jad_er.getAndIncrement());
            newThread.setName(jad_an.toString());
            return newThread;
        }
    }

    public interface jad_cp {
        public static final com.jd.ad.sdk.jad_pa.jad_an.jad_cp jad_an = new com.jd.ad.sdk.jad_pa.jad_an.jad_cp.C0402jad_an();

        /* renamed from: com.jd.ad.sdk.jad_pa.jad_an$jad_cp$jad_an, reason: collision with other inner class name */
        public class C0402jad_an implements com.jd.ad.sdk.jad_pa.jad_an.jad_cp {
            @Override // com.jd.ad.sdk.jad_pa.jad_an.jad_cp
            public void jad_an(java.lang.Throwable th) {
                if (android.util.Log.isLoggable("GlideExecutor", 6)) {
                    com.jd.ad.sdk.logger.Logger.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        void jad_an(java.lang.Throwable th);
    }

    @androidx.annotation.VisibleForTesting
    public jad_an(java.util.concurrent.ExecutorService executorService) {
        this.jad_an = executorService;
    }

    public static int jad_an() {
        if (jad_cp == 0) {
            jad_cp = java.lang.Math.min(4, java.lang.Runtime.getRuntime().availableProcessors());
        }
        return jad_cp;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return this.jad_an.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        this.jad_an.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(@androidx.annotation.NonNull java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) {
        return this.jad_an.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(@androidx.annotation.NonNull java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return this.jad_an.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public <T> T invokeAny(@androidx.annotation.NonNull java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) {
        return (T) this.jad_an.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@androidx.annotation.NonNull java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return (T) this.jad_an.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.jad_an.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.jad_an.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.jad_an.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public java.util.List<java.lang.Runnable> shutdownNow() {
        return this.jad_an.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public java.util.concurrent.Future<?> submit(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        return this.jad_an.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @androidx.annotation.NonNull
    public <T> java.util.concurrent.Future<T> submit(@androidx.annotation.NonNull java.lang.Runnable runnable, T t) {
        return this.jad_an.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> java.util.concurrent.Future<T> submit(@androidx.annotation.NonNull java.util.concurrent.Callable<T> callable) {
        return this.jad_an.submit(callable);
    }

    public java.lang.String toString() {
        return this.jad_an.toString();
    }
}
