package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface AsyncFunction<I, O> {
    com.google.common.util.concurrent.ListenableFuture<O> apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl I i) throws java.lang.Exception;
}
