package com.bumptech.glide.load;

/* loaded from: classes.dex */
public final class HttpException extends java.io.IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public HttpException(java.lang.String str) {
        this(str, -1);
    }

    public HttpException(java.lang.String str, int i) {
        this(str, i, null);
    }

    public HttpException(java.lang.String str, int i, @androidx.annotation.Nullable java.lang.Throwable th) {
        super(str, th);
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
