package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class UncheckedTimeoutException extends java.lang.RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        super(str);
    }

    public UncheckedTimeoutException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(str, th);
    }

    public UncheckedTimeoutException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(th);
    }
}
