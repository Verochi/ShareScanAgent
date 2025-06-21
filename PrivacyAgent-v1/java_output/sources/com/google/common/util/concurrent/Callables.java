package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Callables {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.util.concurrent.Callables$1, reason: invalid class name */
    public static class AnonymousClass1<T> implements java.util.concurrent.Callable<T> {
        public final /* synthetic */ java.lang.Object n;

        public AnonymousClass1(java.lang.Object obj) {
            this.n = obj;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            return (T) this.n;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.util.concurrent.Callables$2, reason: invalid class name */
    public static class AnonymousClass2<T> implements com.google.common.util.concurrent.AsyncCallable<T> {
        public final /* synthetic */ com.google.common.util.concurrent.ListeningExecutorService a;
        public final /* synthetic */ java.util.concurrent.Callable b;

        public AnonymousClass2(com.google.common.util.concurrent.ListeningExecutorService listeningExecutorService, java.util.concurrent.Callable callable) {
            this.a = listeningExecutorService;
            this.b = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public com.google.common.util.concurrent.ListenableFuture<T> call() throws java.lang.Exception {
            return this.a.submit((java.util.concurrent.Callable) this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.common.util.concurrent.Callables$3, reason: invalid class name */
    public static class AnonymousClass3<T> implements java.util.concurrent.Callable<T> {
        public final /* synthetic */ com.google.common.base.Supplier n;
        public final /* synthetic */ java.util.concurrent.Callable t;

        public AnonymousClass3(com.google.common.base.Supplier supplier, java.util.concurrent.Callable callable) {
            this.n = supplier;
            this.t = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws java.lang.Exception {
            java.lang.Thread currentThread = java.lang.Thread.currentThread();
            java.lang.String name = currentThread.getName();
            boolean d = com.google.common.util.concurrent.Callables.d((java.lang.String) this.n.get(), currentThread);
            try {
                return (T) this.t.call();
            } finally {
                if (d) {
                    com.google.common.util.concurrent.Callables.d(name, currentThread);
                }
            }
        }
    }

    /* renamed from: com.google.common.util.concurrent.Callables$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.google.common.base.Supplier n;
        public final /* synthetic */ java.lang.Runnable t;

        public AnonymousClass4(com.google.common.base.Supplier supplier, java.lang.Runnable runnable) {
            this.n = supplier;
            this.t = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Thread currentThread = java.lang.Thread.currentThread();
            java.lang.String name = currentThread.getName();
            boolean d = com.google.common.util.concurrent.Callables.d((java.lang.String) this.n.get(), currentThread);
            try {
                this.t.run();
            } finally {
                if (d) {
                    com.google.common.util.concurrent.Callables.d(name, currentThread);
                }
            }
        }
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static <T> com.google.common.util.concurrent.AsyncCallable<T> asAsyncCallable(java.util.concurrent.Callable<T> callable, com.google.common.util.concurrent.ListeningExecutorService listeningExecutorService) {
        com.google.common.base.Preconditions.checkNotNull(callable);
        com.google.common.base.Preconditions.checkNotNull(listeningExecutorService);
        return new com.google.common.util.concurrent.Callables.AnonymousClass2(listeningExecutorService, callable);
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.lang.Runnable b(java.lang.Runnable runnable, com.google.common.base.Supplier<java.lang.String> supplier) {
        com.google.common.base.Preconditions.checkNotNull(supplier);
        com.google.common.base.Preconditions.checkNotNull(runnable);
        return new com.google.common.util.concurrent.Callables.AnonymousClass4(supplier, runnable);
    }

    @com.google.common.annotations.GwtIncompatible
    public static <T> java.util.concurrent.Callable<T> c(java.util.concurrent.Callable<T> callable, com.google.common.base.Supplier<java.lang.String> supplier) {
        com.google.common.base.Preconditions.checkNotNull(supplier);
        com.google.common.base.Preconditions.checkNotNull(callable);
        return new com.google.common.util.concurrent.Callables.AnonymousClass3(supplier, callable);
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean d(java.lang.String str, java.lang.Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (java.lang.SecurityException unused) {
            return false;
        }
    }

    public static <T> java.util.concurrent.Callable<T> returning(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        return new com.google.common.util.concurrent.Callables.AnonymousClass1(t);
    }
}
