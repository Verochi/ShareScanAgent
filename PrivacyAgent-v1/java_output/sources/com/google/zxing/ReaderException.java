package com.google.zxing;

/* loaded from: classes22.dex */
public abstract class ReaderException extends java.lang.Exception {
    protected static final java.lang.StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = java.lang.System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new java.lang.StackTraceElement[0];
    }

    public ReaderException() {
    }

    public ReaderException(java.lang.Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final synchronized java.lang.Throwable fillInStackTrace() {
        return null;
    }
}
