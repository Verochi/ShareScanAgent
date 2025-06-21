package com.google.common.cache;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class RemovalListeners {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: com.google.common.cache.RemovalListeners$1, reason: invalid class name */
    public static class AnonymousClass1<K, V> implements com.google.common.cache.RemovalListener<K, V> {
        public final /* synthetic */ java.util.concurrent.Executor n;
        public final /* synthetic */ com.google.common.cache.RemovalListener t;

        /* renamed from: com.google.common.cache.RemovalListeners$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC03381 implements java.lang.Runnable {
            public final /* synthetic */ com.google.common.cache.RemovalNotification n;

            public RunnableC03381(com.google.common.cache.RemovalNotification removalNotification) {
                this.n = removalNotification;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.common.cache.RemovalListeners.AnonymousClass1.this.t.onRemoval(this.n);
            }
        }

        public AnonymousClass1(java.util.concurrent.Executor executor, com.google.common.cache.RemovalListener removalListener) {
            this.n = executor;
            this.t = removalListener;
        }

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(com.google.common.cache.RemovalNotification<K, V> removalNotification) {
            this.n.execute(new com.google.common.cache.RemovalListeners.AnonymousClass1.RunnableC03381(removalNotification));
        }
    }

    public static <K, V> com.google.common.cache.RemovalListener<K, V> asynchronous(com.google.common.cache.RemovalListener<K, V> removalListener, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(removalListener);
        com.google.common.base.Preconditions.checkNotNull(executor);
        return new com.google.common.cache.RemovalListeners.AnonymousClass1(executor, removalListener);
    }
}
