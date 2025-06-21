package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class ListenableFutureTask<V> extends java.util.concurrent.FutureTask<V> implements com.google.common.util.concurrent.ListenableFuture<V> {
    public final com.google.common.util.concurrent.ExecutionList n;

    public ListenableFutureTask(java.lang.Runnable runnable, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        super(runnable, v);
        this.n = new com.google.common.util.concurrent.ExecutionList();
    }

    public ListenableFutureTask(java.util.concurrent.Callable<V> callable) {
        super(callable);
        this.n = new com.google.common.util.concurrent.ExecutionList();
    }

    public static <V> com.google.common.util.concurrent.ListenableFutureTask<V> create(java.lang.Runnable runnable, @org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new com.google.common.util.concurrent.ListenableFutureTask<>(runnable, v);
    }

    public static <V> com.google.common.util.concurrent.ListenableFutureTask<V> create(java.util.concurrent.Callable<V> callable) {
        return new com.google.common.util.concurrent.ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        this.n.add(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.n.execute();
    }
}
