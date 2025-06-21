package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
final class CallbackException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(java.lang.Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
