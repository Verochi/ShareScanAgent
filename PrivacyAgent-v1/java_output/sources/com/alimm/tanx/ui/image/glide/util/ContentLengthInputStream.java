package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends java.io.FilterInputStream {
    private static final java.lang.String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    public ContentLengthInputStream(java.io.InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    private int checkReadSoFarOrThrow(int i) throws java.io.IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - this.readSoFar > 0) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Failed to read all expected data, expected: ");
            tanxu_do2.append(this.contentLength);
            tanxu_do2.append(", but read: ");
            tanxu_do2.append(this.readSoFar);
            throw new java.io.IOException(tanxu_do2.toString());
        }
        return i;
    }

    public static java.io.InputStream obtain(java.io.InputStream inputStream, long j) {
        return new com.alimm.tanx.ui.image.glide.util.ContentLengthInputStream(inputStream, j);
    }

    public static java.io.InputStream obtain(java.io.InputStream inputStream, java.lang.String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    private static int parseContentLength(java.lang.String str) {
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
        return checkReadSoFarOrThrow(super.read());
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
