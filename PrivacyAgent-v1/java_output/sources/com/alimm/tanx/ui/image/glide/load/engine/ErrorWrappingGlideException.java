package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
public class ErrorWrappingGlideException extends java.lang.Exception {
    public ErrorWrappingGlideException(java.lang.Error error) {
        super(error);
        if (error == null) {
            throw new java.lang.NullPointerException("The causing error must not be null");
        }
    }

    @Override // java.lang.Throwable
    public java.lang.Error getCause() {
        return (java.lang.Error) super.getCause();
    }
}
