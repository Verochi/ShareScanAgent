package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public class UncheckedExecutionException extends java.lang.RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        super(str);
    }

    public UncheckedExecutionException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(th);
    }
}
