package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class Executors {
    private static final java.util.concurrent.Executor MAIN_THREAD_EXECUTOR = new com.bumptech.glide.util.Executors.AnonymousClass1();
    private static final java.util.concurrent.Executor DIRECT_EXECUTOR = new com.bumptech.glide.util.Executors.AnonymousClass2();

    /* renamed from: com.bumptech.glide.util.Executors$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Executor {
        private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            this.handler.post(runnable);
        }
    }

    /* renamed from: com.bumptech.glide.util.Executors$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            runnable.run();
        }
    }

    private Executors() {
    }

    public static java.util.concurrent.Executor directExecutor() {
        return DIRECT_EXECUTOR;
    }

    public static java.util.concurrent.Executor mainThreadExecutor() {
        return MAIN_THREAD_EXECUTOR;
    }

    @androidx.annotation.VisibleForTesting
    public static void shutdownAndAwaitTermination(java.util.concurrent.ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, timeUnit)) {
            } else {
                throw new java.lang.RuntimeException("Failed to shutdown");
            }
        } catch (java.lang.InterruptedException e) {
            executorService.shutdownNow();
            java.lang.Thread.currentThread().interrupt();
            throw new java.lang.RuntimeException(e);
        }
    }
}
