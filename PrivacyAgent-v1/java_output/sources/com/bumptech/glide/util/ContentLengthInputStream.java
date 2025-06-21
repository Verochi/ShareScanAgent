package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends java.io.FilterInputStream {
    private static final java.lang.String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(@androidx.annotation.NonNull java.io.InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    private int checkReadSoFarOrThrow(int i) throws java.io.IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - this.readSoFar > 0) {
            throw new java.io.IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return i;
    }

    @androidx.annotation.NonNull
    public static java.io.InputStream obtain(@androidx.annotation.NonNull java.io.InputStream inputStream, long j) {
        return new com.bumptech.glide.util.ContentLengthInputStream(inputStream, j);
    }

    @androidx.annotation.NonNull
    public static java.io.InputStream obtain(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    private static int parseContentLength(@androidx.annotation.Nullable java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                return java.lang.Integer.parseInt(str);
            } catch (java.lang.NumberFormatException unused) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("failed to parse content length header: ");
                    sb.append(str);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws java.io.IOException {
        return (int) java.lang.Math.max(this.contentLength - this.readSoFar, ((java.io.FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        int read;
        read = super.read();
        checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i, i2));
    }
}
