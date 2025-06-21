package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends java.io.FilterInputStream {
    private static final java.lang.String TAG = "BufferedIs";
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public static class InvalidMarkException extends java.lang.RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(java.lang.String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(java.io.InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.markpos = -1;
        if (bArr == null || bArr.length == 0) {
            throw new java.lang.IllegalArgumentException("buffer is null or empty");
        }
        this.buf = bArr;
    }

    private int fillbuf(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        int i = this.markpos;
        if (i != -1) {
            int i2 = this.pos - i;
            int i3 = this.marklimit;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("allocate buffer of length: ");
                        sb.append(i3);
                    }
                    byte[] bArr2 = new byte[i3];
                    java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    bArr = bArr2;
                } else if (i > 0) {
                    java.lang.System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.pos - this.markpos;
                this.pos = i4;
                this.markpos = 0;
                this.count = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                this.count = read <= 0 ? this.pos : this.pos + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = read2;
        }
        return read2;
    }

    private static java.io.IOException streamClosed() throws java.io.IOException {
        throw new java.io.IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws java.io.IOException {
        java.io.InputStream inputStream;
        inputStream = ((java.io.FilterInputStream) this).in;
        if (this.buf == null || inputStream == null) {
            streamClosed();
            throw null;
        }
        return inputStream.available() + (this.count - this.pos);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.buf = null;
        java.io.InputStream inputStream = ((java.io.FilterInputStream) this).in;
        ((java.io.FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.marklimit = java.lang.Math.max(this.marklimit, i);
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        byte[] bArr = this.buf;
        java.io.InputStream inputStream = ((java.io.FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            streamClosed();
            throw null;
        }
        if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.buf && (bArr = this.buf) == null) {
            streamClosed();
            throw null;
        }
        int i = this.count;
        int i2 = this.pos;
        if (i - i2 <= 0) {
            return -1;
        }
        this.pos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            streamClosed();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        java.io.InputStream inputStream = ((java.io.FilterInputStream) this).in;
        if (inputStream == null) {
            streamClosed();
            throw null;
        }
        int i5 = this.pos;
        int i6 = this.count;
        if (i5 < i6) {
            int i7 = i6 - i5;
            if (i7 >= i2) {
                i7 = i2;
            }
            java.lang.System.arraycopy(bArr2, i5, bArr, i, i7);
            this.pos += i7;
            if (i7 == i2 || inputStream.available() == 0) {
                return i7;
            }
            i += i7;
            i3 = i2 - i7;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.markpos == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (fillbuf(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                    streamClosed();
                    throw null;
                }
                int i8 = this.count;
                int i9 = this.pos;
                i4 = i8 - i9;
                if (i4 >= i3) {
                    i4 = i3;
                }
                java.lang.System.arraycopy(bArr2, i9, bArr, i, i4);
                this.pos += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        if (this.buf == null) {
            throw new java.io.IOException("Stream is closed");
        }
        int i = this.markpos;
        if (-1 == i) {
            throw new com.alimm.tanx.ui.image.glide.load.resource.bitmap.RecyclableBufferedInputStream.InvalidMarkException("Mark has been invalidated");
        }
        this.pos = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws java.io.IOException {
        byte[] bArr = this.buf;
        java.io.InputStream inputStream = ((java.io.FilterInputStream) this).in;
        if (bArr == null) {
            streamClosed();
            throw null;
        }
        if (j < 1) {
            return 0L;
        }
        if (inputStream == null) {
            streamClosed();
            throw null;
        }
        int i = this.count;
        int i2 = this.pos;
        long j2 = i - i2;
        if (j2 >= j) {
            this.pos = (int) (i2 + j);
            return j;
        }
        this.pos = i;
        if (this.markpos == -1 || j > this.marklimit) {
            return inputStream.skip(j - j2) + j2;
        }
        if (fillbuf(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.count;
        int i4 = this.pos;
        long j3 = j - j2;
        if (i3 - i4 >= j3) {
            this.pos = (int) (i4 + j3);
            return j;
        }
        long j4 = (j2 + i3) - i4;
        this.pos = i3;
        return j4;
    }
}
