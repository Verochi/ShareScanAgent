package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> extends com.google.common.util.concurrent.FluentFuture.TrustedFuture<V> implements java.lang.Runnable {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.lang.Class<X> A;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public F B;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.util.concurrent.ListenableFuture<? extends V> z;

    public static final class AsyncCatchingFuture<V, X extends java.lang.Throwable> extends com.google.common.util.concurrent.AbstractCatchingFuture<V, X, com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V>, com.google.common.util.concurrent.ListenableFuture<? extends V>> {
        public AsyncCatchingFuture(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public com.google.common.util.concurrent.ListenableFuture<? extends V> y(com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws java.lang.Exception {
            com.google.common.util.concurrent.ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            com.google.common.base.Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }
    }

    public static final class CatchingFuture<V, X extends java.lang.Throwable> extends com.google.common.util.concurrent.AbstractCatchingFuture<V, X, com.google.common.base.Function<? super X, ? extends V>, V> {
        public CatchingFuture(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.base.Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
            set(v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public V y(com.google.common.base.Function<? super X, ? extends V> function, X x) throws java.lang.Exception {
            return function.apply(x);
        }
    }

    public AbstractCatchingFuture(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, F f) {
        this.z = (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(listenableFuture);
        this.A = (java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls);
        this.B = (F) com.google.common.base.Preconditions.checkNotNull(f);
    }

    public static <V, X extends java.lang.Throwable> com.google.common.util.concurrent.ListenableFuture<V> w(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.base.Function<? super X, ? extends V> function, java.util.concurrent.Executor executor) {
        com.google.common.util.concurrent.AbstractCatchingFuture.CatchingFuture catchingFuture = new com.google.common.util.concurrent.AbstractCatchingFuture.CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, com.google.common.util.concurrent.MoreExecutors.d(executor, catchingFuture));
        return catchingFuture;
    }

    public static <X extends java.lang.Throwable, V> com.google.common.util.concurrent.ListenableFuture<V> x(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture, java.lang.Class<X> cls, com.google.common.util.concurrent.AsyncFunction<? super X, ? extends V> asyncFunction, java.util.concurrent.Executor executor) {
        com.google.common.util.concurrent.AbstractCatchingFuture.AsyncCatchingFuture asyncCatchingFuture = new com.google.common.util.concurrent.AbstractCatchingFuture.AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, com.google.common.util.concurrent.MoreExecutors.d(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        s(this.z);
        this.z = null;
        this.A = null;
        this.B = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public java.lang.String pendingToString() {
        java.lang.String str;
        com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture = this.z;
        java.lang.Class<X> cls = this.A;
        F f = this.B;
        java.lang.String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || f == null) {
            if (pendingToString == null) {
                return null;
            }
            return str + pendingToString;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        java.lang.Object obj;
        com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture = this.z;
        java.lang.Class<X> cls = this.A;
        F f = this.B;
        if (((f == null) | (listenableFuture == null) | (cls == null)) || isCancelled()) {
            return;
        }
        ?? r3 = (java.lang.Class<X>) null;
        this.z = null;
        try {
            obj = com.google.common.util.concurrent.Futures.getDone(listenableFuture);
            th = null;
        } catch (java.util.concurrent.ExecutionException e) {
            th = (java.lang.Throwable) com.google.common.base.Preconditions.checkNotNull(e.getCause());
            obj = null;
            if (th == null) {
            }
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
            if (th == null) {
            }
        }
        if (th == null) {
            set(obj);
            return;
        }
        if (!com.google.common.util.concurrent.Platform.a(th, cls)) {
            setFuture(listenableFuture);
            return;
        }
        try {
            java.lang.Object y = y(f, th);
            this.A = null;
            this.B = null;
            setResult(y);
        } catch (java.lang.Throwable th2) {
            try {
                setException(th2);
            } finally {
                this.A = null;
                this.B = null;
            }
        }
    }

    @com.google.errorprone.annotations.ForOverride
    public abstract void setResult(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.errorprone.annotations.ForOverride
    public abstract T y(F f, X x) throws java.lang.Exception;
}
