package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractTransformFuture<I, O, F, T> extends com.google.common.util.concurrent.FluentFuture.TrustedFuture<O> implements java.lang.Runnable {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public F A;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.util.concurrent.ListenableFuture<? extends I> z;

    public static final class AsyncTransformFuture<I, O> extends com.google.common.util.concurrent.AbstractTransformFuture<I, O, com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O>, com.google.common.util.concurrent.ListenableFuture<? extends O>> {
        public AsyncTransformFuture(com.google.common.util.concurrent.ListenableFuture<? extends I> listenableFuture, com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(com.google.common.util.concurrent.ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public com.google.common.util.concurrent.ListenableFuture<? extends O> y(com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O> asyncFunction, @org.checkerframework.checker.nullness.compatqual.NullableDecl I i) throws java.lang.Exception {
            com.google.common.util.concurrent.ListenableFuture<? extends O> apply = asyncFunction.apply(i);
            com.google.common.base.Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }
    }

    public static final class TransformFuture<I, O> extends com.google.common.util.concurrent.AbstractTransformFuture<I, O, com.google.common.base.Function<? super I, ? extends O>, O> {
        public TransformFuture(com.google.common.util.concurrent.ListenableFuture<? extends I> listenableFuture, com.google.common.base.Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(@org.checkerframework.checker.nullness.compatqual.NullableDecl O o) {
            set(o);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public O y(com.google.common.base.Function<? super I, ? extends O> function, @org.checkerframework.checker.nullness.compatqual.NullableDecl I i) {
            return function.apply(i);
        }
    }

    public AbstractTransformFuture(com.google.common.util.concurrent.ListenableFuture<? extends I> listenableFuture, F f) {
        this.z = (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(listenableFuture);
        this.A = (F) com.google.common.base.Preconditions.checkNotNull(f);
    }

    public static <I, O> com.google.common.util.concurrent.ListenableFuture<O> w(com.google.common.util.concurrent.ListenableFuture<I> listenableFuture, com.google.common.base.Function<? super I, ? extends O> function, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(function);
        com.google.common.util.concurrent.AbstractTransformFuture.TransformFuture transformFuture = new com.google.common.util.concurrent.AbstractTransformFuture.TransformFuture(listenableFuture, function);
        listenableFuture.addListener(transformFuture, com.google.common.util.concurrent.MoreExecutors.d(executor, transformFuture));
        return transformFuture;
    }

    public static <I, O> com.google.common.util.concurrent.ListenableFuture<O> x(com.google.common.util.concurrent.ListenableFuture<I> listenableFuture, com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O> asyncFunction, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(executor);
        com.google.common.util.concurrent.AbstractTransformFuture.AsyncTransformFuture asyncTransformFuture = new com.google.common.util.concurrent.AbstractTransformFuture.AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, com.google.common.util.concurrent.MoreExecutors.d(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        s(this.z);
        this.z = null;
        this.A = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public java.lang.String pendingToString() {
        java.lang.String str;
        com.google.common.util.concurrent.ListenableFuture<? extends I> listenableFuture = this.z;
        F f = this.A;
        java.lang.String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + f + "]";
        }
        if (pendingToString == null) {
            return null;
        }
        return str + pendingToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        com.google.common.util.concurrent.ListenableFuture<? extends I> listenableFuture = this.z;
        F f = this.A;
        if ((isCancelled() | (listenableFuture == null)) || (f == null)) {
            return;
        }
        this.z = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                java.lang.Object y = y(f, com.google.common.util.concurrent.Futures.getDone(listenableFuture));
                this.A = null;
                setResult(y);
            } catch (java.lang.Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.A = null;
                }
            }
        } catch (java.lang.Error e) {
            setException(e);
        } catch (java.util.concurrent.CancellationException unused) {
            cancel(false);
        } catch (java.lang.RuntimeException e2) {
            setException(e2);
        } catch (java.util.concurrent.ExecutionException e3) {
            setException(e3.getCause());
        }
    }

    @com.google.errorprone.annotations.ForOverride
    public abstract void setResult(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.errorprone.annotations.ForOverride
    public abstract T y(F f, @org.checkerframework.checker.nullness.compatqual.NullableDecl I i) throws java.lang.Exception;
}
