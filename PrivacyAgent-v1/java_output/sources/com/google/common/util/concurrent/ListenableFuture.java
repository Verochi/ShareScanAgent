package com.google.common.util.concurrent;

/* loaded from: classes22.dex */
public interface ListenableFuture<V> extends java.util.concurrent.Future<V> {
    void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor);
}
