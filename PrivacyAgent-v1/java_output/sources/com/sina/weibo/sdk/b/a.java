package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public final class a {
    private static final int J;
    private static final int K;
    private static final int L;
    private static final java.util.Comparator<java.lang.Runnable> N;
    java.util.concurrent.ThreadPoolExecutor M;

    /* renamed from: com.sina.weibo.sdk.b.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.lang.Runnable> {
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(java.lang.Runnable runnable, java.lang.Runnable runnable2) {
            return 0;
        }
    }

    static {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        J = availableProcessors;
        K = availableProcessors + 1;
        L = (availableProcessors * 2) + 1;
        N = new com.sina.weibo.sdk.b.a.AnonymousClass1();
    }

    public a() {
        if (this.M == null) {
            this.M = new java.util.concurrent.ThreadPoolExecutor(K, L, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.PriorityBlockingQueue(5, N));
        }
    }
}
