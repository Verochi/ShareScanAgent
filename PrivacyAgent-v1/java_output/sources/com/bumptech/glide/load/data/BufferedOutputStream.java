package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public final class BufferedOutputStream extends java.io.OutputStream {
    private com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private byte[] buffer;
    private int index;

    @androidx.annotation.NonNull
    private final java.io.OutputStream out;

    public BufferedOutputStream(@androidx.annotation.NonNull java.io.OutputStream outputStream, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    @androidx.annotation.VisibleForTesting
    public BufferedOutputStream(@androidx.annotation.NonNull java.io.OutputStream outputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, int i) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i, byte[].class);
    }

    private void flushBuffer() throws java.io.IOException {
        int i = this.index;
        if (i > 0) {
            this.out.write(this.buffer, 0, i);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws java.io.IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (java.lang.Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        maybeFlushBuffer();
    }

    @Override // java.io.OutputStream
    public void write(@androidx.annotation.NonNull byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@androidx.annotation.NonNull byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.index;
            if (i6 == 0 && i4 >= this.buffer.length) {
                this.out.write(bArr, i5, i4);
                return;
            }
            int min = java.lang.Math.min(i4, this.buffer.length - i6);
            java.lang.System.arraycopy(bArr, i5, this.buffer, this.index, min);
            this.index += min;
            i3 += min;
            maybeFlushBuffer();
        } while (i3 < i2);
    }
}
