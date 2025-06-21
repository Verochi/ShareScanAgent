package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public class VerifyException extends java.lang.RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        super(str);
    }

    public VerifyException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(str, th);
    }

    public VerifyException(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        super(th);
    }
}
