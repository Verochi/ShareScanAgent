package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public class ExecutionError extends java.lang.Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Error error) {
        super(error);
    }

    public ExecutionError(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        super(str);
    }

    public ExecutionError(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Error error) {
        super(str, error);
    }
}
