package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class UnsupportedDrmException extends java.lang.Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public UnsupportedDrmException(int i) {
        this.reason = i;
    }

    public UnsupportedDrmException(int i, java.lang.Exception exc) {
        super(exc);
        this.reason = i;
    }
}
