package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class ExoPlaybackException extends java.lang.Exception {
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED = 0;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;

    @androidx.annotation.Nullable
    private final java.lang.Throwable cause;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @androidx.annotation.Nullable
    public final java.lang.String rendererName;
    public final int timeoutOperation;
    public final long timestampMs;
    public final int type;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TimeoutOperation {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i, java.lang.String str) {
        this(i, null, str, null, -1, null, 4, 0);
    }

    private ExoPlaybackException(int i, java.lang.Throwable th) {
        this(i, th, null, null, -1, null, 4, 0);
    }

    private ExoPlaybackException(int i, @androidx.annotation.Nullable java.lang.Throwable th, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, int i4) {
        this(deriveMessage(i, str, str2, i2, format, i3), th, i, str2, i2, format, i3, null, i4, android.os.SystemClock.elapsedRealtime());
    }

    private ExoPlaybackException(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th, int i, @androidx.annotation.Nullable java.lang.String str2, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, int i4, long j) {
        super(str, th);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = mediaPeriodId;
        this.timeoutOperation = i4;
        this.timestampMs = j;
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForOutOfMemory(java.lang.OutOfMemoryError outOfMemoryError) {
        return new com.google.android.exoplayer2.ExoPlaybackException(4, outOfMemoryError);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForRemote(java.lang.String str) {
        return new com.google.android.exoplayer2.ExoPlaybackException(3, str);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForRenderer(java.lang.Exception exc, java.lang.String str, int i, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i2) {
        return new com.google.android.exoplayer2.ExoPlaybackException(1, exc, null, str, i, format, format == null ? 4 : i2, 0);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForSource(java.io.IOException iOException) {
        return new com.google.android.exoplayer2.ExoPlaybackException(0, iOException);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForTimeout(java.util.concurrent.TimeoutException timeoutException, int i) {
        return new com.google.android.exoplayer2.ExoPlaybackException(5, timeoutException, null, null, -1, null, 4, i);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForUnexpected(java.lang.RuntimeException runtimeException) {
        return new com.google.android.exoplayer2.ExoPlaybackException(2, runtimeException);
    }

    @androidx.annotation.Nullable
    private static java.lang.String deriveMessage(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3) {
        java.lang.String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            java.lang.String valueOf = java.lang.String.valueOf(format);
            java.lang.String e = defpackage.ub2.e(i3);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 53 + valueOf.length() + java.lang.String.valueOf(e).length());
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i2);
            sb.append(", format=");
            sb.append(valueOf);
            sb.append(", format_supported=");
            sb.append(e);
            str3 = sb.toString();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return str3;
        }
        java.lang.String valueOf2 = java.lang.String.valueOf(str3);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf2.length() + 2 + java.lang.String.valueOf(str).length());
        sb2.append(valueOf2);
        sb2.append(": ");
        sb2.append(str);
        return sb2.toString();
    }

    @androidx.annotation.CheckResult
    public com.google.android.exoplayer2.ExoPlaybackException copyWithMediaPeriodId(@androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return new com.google.android.exoplayer2.ExoPlaybackException(getMessage(), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, this.timeoutOperation, this.timestampMs);
    }

    public java.lang.OutOfMemoryError getOutOfMemoryError() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 4);
        return (java.lang.OutOfMemoryError) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cause);
    }

    public java.lang.Exception getRendererException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 1);
        return (java.lang.Exception) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cause);
    }

    public java.io.IOException getSourceException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 0);
        return (java.io.IOException) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cause);
    }

    public java.util.concurrent.TimeoutException getTimeoutException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 5);
        return (java.util.concurrent.TimeoutException) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cause);
    }

    public java.lang.RuntimeException getUnexpectedException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 2);
        return (java.lang.RuntimeException) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cause);
    }
}
