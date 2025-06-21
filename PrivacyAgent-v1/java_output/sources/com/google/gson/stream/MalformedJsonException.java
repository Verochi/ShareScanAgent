package com.google.gson.stream;

/* loaded from: classes22.dex */
public final class MalformedJsonException extends java.io.IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(java.lang.String str) {
        super(str);
    }

    public MalformedJsonException(java.lang.String str, java.lang.Throwable th) {
        super(str);
        initCause(th);
    }

    public MalformedJsonException(java.lang.Throwable th) {
        initCause(th);
    }
}
